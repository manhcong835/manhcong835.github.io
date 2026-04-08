/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.ScreeningController;
import java.awt.Color;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import model.Showtime;
  

public class ScreeningPanel extends javax.swing.JPanel {
    private ScreeningController controller;
    private TicketPanel ticketPanel;
    private String selectedScreeningId = null;
    
    public ScreeningPanel(TicketPanel ticketPanel) {
        initComponents();
        this.ticketPanel= ticketPanel;
        controller = new ScreeningController();
        initTable();
        loadMoviesToComboBox();
        loadRoomsToComboBox();
        loadScreeningsToTable();
        
        // Thiết lập spinner ngày và giờ
        jSpinnerDate.setModel(new SpinnerDateModel());
        jSpinnerTime.setModel(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(jSpinnerDate, "dd/MM/yyyy");
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinnerTime, "HH:mm");
        jSpinnerDate.setEditor(dateEditor);
        jSpinnerTime.setEditor(timeEditor);
        
        setHoverEffect(btnAdd, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnEdit, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnDelete, new Color(16, 90, 115), new Color(255, 255, 255));
        
    // Thêm sự kiện cho nút "Thêm"
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addScreening(); // Gọi phương thức xử lý thêm suất chiếu
        }
    });

    // (Tương tự, thêm sự kiện cho nút "Sửa" và "Xóa" nếu cần)
    btnEdit.addActionListener(e -> updateScreening());
    btnDelete.addActionListener(e -> deleteScreening());

    // Thêm sự kiện chọn hàng trong bảng
    tblScreenings.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            fillFormFromSelectedRow();
        }
    });
    }
    
    private void setHoverEffect(JButton button, Color hoverColor, Color defaultColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(defaultColor);
                button.setForeground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
                button.setForeground(defaultColor);
            }
        });
    }
    
    private void initTable() {
        DefaultTableModel model = (DefaultTableModel) tblScreenings.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"ID", "Tên Phim", "Phòng", "Giờ Chiếu", "Giá Vé"});
    }
    
    void loadMoviesToComboBox() {
        cbMovie.removeAllItems();
        List<String> movies = controller.getAllMovies();
        for (String movie : movies) {
            cbMovie.addItem(movie);
        }
    }
    
    private void loadRoomsToComboBox() {
        cbRoom.removeAllItems();
        List<String> rooms = controller.getAllRooms();
        for (String room : rooms) {
            cbRoom.addItem(room);
        }
    }
    
    private void loadScreeningsToTable() {
        DefaultTableModel model = (DefaultTableModel) tblScreenings.getModel();
        model.setRowCount(0);
        
        List<Showtime> screenings = controller.getAllScreenings();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        for (Showtime screening : screenings) {
            Object[] row = {
                screening.getId(),
                screening.getMovieName(),
                screening.getRoomName(),
                sdf.format(screening.getStartTime()),
                screening.getTicketPrice()
            };
            model.addRow(row);
        }
    }
    
    private void addScreening() {
        try {
            String movieInfo = (String) cbMovie.getSelectedItem(); 
            String roomInfo = (String) cbRoom.getSelectedItem();
            
            // Lấy ngày và giờ từ spinner
            Date date = (Date) jSpinnerDate.getValue();
            Date time = (Date) jSpinnerTime.getValue();
            
            // Kết hợp ngày và giờ
            Calendar dateCal = Calendar.getInstance();
            dateCal.setTime(date);
            
            Calendar timeCal = Calendar.getInstance();
            timeCal.setTime(time);
            
            dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
            dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
            
            Date screeningTime = dateCal.getTime();
            
            // Lấy giá vé từ text field
            double price = Double.parseDouble(txtPrice.getText().trim());
            
            String movieId = controller.extractIdFromCombinedString(movieInfo);
            String roomId = controller.extractIdFromCombinedString(roomInfo);
            
            if (!controller.isRoomAvailable(roomId, new Timestamp(screeningTime.getTime()), movieId)) {
                JOptionPane.showMessageDialog(this, 
                    "Phòng chiếu đã có suất chiếu khác trong khoảng thời gian này!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Showtime newScreening = new Showtime();
            newScreening.setId(controller.generateNewScreeningId());
            newScreening.setMovieId(movieId);
            newScreening.setScreenRoomId(roomId);
            newScreening.setStartTime(new Timestamp(screeningTime.getTime()));
            newScreening.setTicketPrice(price);
            newScreening.setStatus("Sẵn sàng");
            
            if (controller.addScreening(newScreening)) {
                JOptionPane.showMessageDialog(this, "Thêm suất chiếu thành công", 
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadScreeningsToTable();
                clearForm();
                ticketPanel.loadShowTime();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm suất chiếu thất bại", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá vé hợp lệ", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm suất chiếu: " + e.getMessage(), 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateScreening() {
        if (selectedScreeningId == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn suất chiếu để sửa", 
                "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String movieInfo = (String) cbMovie.getSelectedItem();
            String roomInfo = (String) cbRoom.getSelectedItem();
            
            // Lấy ngày và giờ từ spinner
            Date date = (Date) jSpinnerDate.getValue();
            Date time = (Date) jSpinnerTime.getValue();
            
            // Kết hợp ngày và giờ
            Calendar dateCal = Calendar.getInstance();
            dateCal.setTime(date);
            
            Calendar timeCal = Calendar.getInstance();
            timeCal.setTime(time);
            
            dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
            dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
            
            Date screeningTime = dateCal.getTime();
            
            // Lấy giá vé từ text field
            double price = Double.parseDouble(txtPrice.getText().trim());
            
            String movieId = controller.extractIdFromCombinedString(movieInfo);
            String roomId = controller.extractIdFromCombinedString(roomInfo);
            
            if (!controller.isRoomAvailableForUpdate(roomId, new Timestamp(screeningTime.getTime()), 
                    movieId, selectedScreeningId)) {
                JOptionPane.showMessageDialog(this, 
                    "Phòng chiếu đã có suất chiếu khác trong khoảng thời gian này!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Showtime updatedScreening = new Showtime();
            updatedScreening.setId(selectedScreeningId);
            updatedScreening.setMovieId(movieId);
            updatedScreening.setScreenRoomId(roomId);
            updatedScreening.setStartTime(new Timestamp(screeningTime.getTime()));
            updatedScreening.setTicketPrice(price);
            updatedScreening.setStatus("Sẵn sàng");
            
            if (controller.updateScreening(updatedScreening)) {
                JOptionPane.showMessageDialog(this, "Cập nhật suất chiếu thành công", 
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadScreeningsToTable();
                clearForm();
                ticketPanel.loadShowTime();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật suất chiếu thất bại", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá vé hợp lệ", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật suất chiếu: " + e.getMessage(), 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteScreening() {
        if (selectedScreeningId == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn suất chiếu để xóa", 
                "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa suất chiếu này?", 
            "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (controller.deleteScreening(selectedScreeningId)) {
                    JOptionPane.showMessageDialog(this, "Xóa suất chiếu thành công", 
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    loadScreeningsToTable();
                    clearForm();
                    ticketPanel.loadShowTime();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa suất chiếu thất bại", 
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                String message = ex.getMessage();
                if (message != null && message.contains("REFERENCE constraint")) {
                    JOptionPane.showMessageDialog(this, 
                        "Không thể xóa suất chiếu vì vẫn còn vé liên quan.",
                        "Lỗi ràng buộc dữ liệu",
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Đã xảy ra lỗi: " + message,
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private void clearForm() {
        selectedScreeningId = null;
        cbMovie.setSelectedIndex(0);
        cbRoom.setSelectedIndex(0);
        jSpinnerDate.setValue(new Date());
        jSpinnerTime.setValue(new Date());
        txtPrice.setText("");
    }
    
    private void fillFormFromSelectedRow() {
        int selectedRow = tblScreenings.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblScreenings.getModel();
            selectedScreeningId = (String) model.getValueAt(selectedRow, 0);
            String movieName = (String) model.getValueAt(selectedRow, 1);
            String roomName = (String) model.getValueAt(selectedRow, 2);
            String timeString = (String) model.getValueAt(selectedRow, 3);
            String price = model.getValueAt(selectedRow, 4).toString();
            
            cbMovie.setSelectedItem(movieName);
            cbRoom.setSelectedItem(roomName);
            txtPrice.setText(price);

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date = sdf.parse(timeString);
                jSpinnerDate.setValue(date);
                jSpinnerTime.setValue(date);
            } catch (Exception e) {
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbMovie = new javax.swing.JComboBox<>();
        cbRoom = new javax.swing.JComboBox<>();
        jSpinnerTime = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerDate = new javax.swing.JSpinner();
        txtPrice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblScreenings = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản Lý Suất Chiếu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel6)
                        .addGap(0, 980, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 200));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 204, 255));
        jLabel2.setText("Chọn Phim");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 204, 255));
        jLabel3.setText("Phòng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 204, 255));
        jLabel4.setText("Giờ Chiếu");

        cbMovie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMovieActionPerformed(evt);
            }
        });

        cbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 204, 255));
        jLabel5.setText("Giá Vé");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 204, 255));
        jLabel7.setText("Ngày Chiếu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbRoom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMovie, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinnerTime)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1200, 275));

        tblScreenings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Phim", "Phòng", "Giờ Chiếu", "Giá Vé"
            }
        ));
        jScrollPane1.setViewportView(tblScreenings);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1200, 100));

        btnAdd.setBackground(new java.awt.Color(153, 204, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/themm.png"))); // NOI18N
        btnAdd.setText("Thêm");

        btnDelete.setBackground(new java.awt.Color(153, 204, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoaaa.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(153, 204, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suaaa.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(86, 86, 86)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMovieActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbMovie;
    private javax.swing.JComboBox<String> cbRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JSpinner jSpinnerTime;
    private javax.swing.JTable tblScreenings;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
