/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.TicketController;
import dao.CancelTicket;
import dao.SeatRepository;
import dao.orderTicket;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import model.Showtime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Acer
 */
public class TicketPanel extends javax.swing.JPanel {

    // Khai báo danh sách ghế
    ArrayList<JButton> danhSachGhe = new ArrayList<>();
    private Showtime clickedShowTime;
    List<JButton> selectedButton = new ArrayList<>();

    /**
     * Creates new form TicketPanel
     */
    public TicketPanel() {
        initComponents();
        jTableFilm.getTableHeader().setReorderingAllowed(false);
        jTableFilm.getTableHeader().setResizingAllowed(false);
        setHoverEffect(cancelTicket, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(orderTicket, new Color(16, 90, 115), new Color(255, 255, 255));
        taoGhe();
        loadShowTime();
    }

    private TicketController ticketController;
    private SeatRepository seatRepository;
    private orderTicket or;
    private CancelTicket cancelTickets;

    public void loadShowTime() {
        ticketController = new TicketController();
        seatRepository = new SeatRepository();
        or = new orderTicket();
        cancelTickets = new CancelTicket();
        DefaultTableModel tableModel = (DefaultTableModel) jTableFilm.getModel();
        ticketController.showMovie(tableModel);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titles = new javax.swing.JPanel();
        Time = new javax.swing.JPanel();
        chooseTime = new javax.swing.JLabel();
        SEAT = new javax.swing.JPanel();
        cancelTicket = new javax.swing.JButton();
        orderTicket = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilm = new javax.swing.JTable();
        ticketManagement = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        Titles.setBackground(new java.awt.Color(255, 255, 255));
        Titles.setLayout(new java.awt.BorderLayout());

        Time.setBackground(new java.awt.Color(255, 255, 255));

        chooseTime.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        chooseTime.setText("Chọn suất chiếu: ");

        SEAT.setBackground(new java.awt.Color(153, 204, 255));
        SEAT.setLayout(new java.awt.GridLayout(5, 8));

        cancelTicket.setBackground(new java.awt.Color(153, 204, 255));
        cancelTicket.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        cancelTicket.setForeground(new java.awt.Color(255, 255, 255));
        cancelTicket.setText("Hủy vé");
        cancelTicket.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTicketActionPerformed(evt);
            }
        });

        orderTicket.setBackground(new java.awt.Color(153, 204, 255));
        orderTicket.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        orderTicket.setForeground(new java.awt.Color(255, 255, 255));
        orderTicket.setText("Đặt vé");
        orderTicket.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        orderTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderTicketActionPerformed(evt);
            }
        });

        jTableFilm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã suất chiếu", "Giờ chiếu", "Tên phim", "Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilm);

        ticketManagement.setBackground(new java.awt.Color(255, 255, 255));
        ticketManagement.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        ticketManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ticketManagement.setText("Quản lý vé");

        javax.swing.GroupLayout TimeLayout = new javax.swing.GroupLayout(Time);
        Time.setLayout(TimeLayout);
        TimeLayout.setHorizontalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimeLayout.createSequentialGroup()
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(ticketManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseTime)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SEAT, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TimeLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(cancelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(orderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        TimeLayout.setVerticalGroup(
            TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ticketManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(SEAT, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(TimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelTicket)
                    .addComponent(orderTicket))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        Titles.add(Time, java.awt.BorderLayout.CENTER);

        add(Titles, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTicketActionPerformed

        if (selectedButton.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn ghế nào để hủy!");
            return;
        }

        for (JButton gheXoa : selectedButton) {
            if (!gheXoa.getBackground().equals(Color.ORANGE)) {
                JOptionPane.showMessageDialog(null, "Bạn chỉ có thể hủy những ghế đã đặt");
                return;
            }
        }

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn hủy vé không?",
                "Xác nhận hủy vé",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (confirm == JOptionPane.OK_OPTION) {
            List<JButton> successfullyCancelled = new ArrayList<>();
            List<String> gheKhachDat = new ArrayList<>();

            for (JButton gheXoa : selectedButton) {
                String seatName = gheXoa.getName();
                String roomId = clickedShowTime.getScreenRoomId();
                String seatId = ticketController.getSeatId(seatName, roomId);
                String showTimeId = clickedShowTime.getId();

                if (cancelTickets.isCustomerTicket(showTimeId, seatId)) {
                    gheKhachDat.add(seatName); // Ghi lại tên ghế không thể hủy
                    continue; // Bỏ qua ghế này
                }
                boolean isCancelled = cancelTickets.huyVe(showTimeId, seatId);

                if (isCancelled) {
                    gheXoa.setBackground(UIManager.getColor("Button.background"));
                    successfullyCancelled.add(gheXoa);
                }
                // Nếu không thành công, CancelTicket sẽ hiện thông báo
            }

            selectedButton.removeAll(successfullyCancelled);
            if (!gheKhachDat.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không thể hủy các vé do khách hàng đã đặt: " + String.join(", ", gheKhachDat)+"\nCó thể hủy ở quản lý đơn");
            }
        }
    }//GEN-LAST:event_cancelTicketActionPerformed

    private void jTableFilmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilmMouseClicked
        ArrayList<Showtime> list;
        try {
            int index = jTableFilm.getSelectedRow();
            list = (ArrayList<Showtime>) ticketController.showShowTime();
            Showtime item = list.get(index);
            clickedShowTime = item;
            //Lấy danh sách tên các ghế đã được đặt
            ArrayList<String> danhSachGheDaDat = seatRepository.searchSeatNameFromsShowTime("DaDat", item.getId());
            System.out.println(danhSachGheDaDat.toString());
            for (JButton ghe : danhSachGhe) {
                if (danhSachGheDaDat.indexOf(ghe.getText()) != -1) {
                    ghe.setBackground(Color.red);
                } else {
                    ghe.setBackground(UIManager.getColor("Button.background"));
                }
            }
        } catch (Exception e1) {
        }
    }//GEN-LAST:event_jTableFilmMouseClicked

    private void orderTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderTicketActionPerformed
        if (clickedShowTime == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "❌ Vui lòng chọn suất chiếu trước khi đặt vé!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        boolean hasSelectedSeat = false;
        for (JButton ghe : danhSachGhe) {
            if (ghe.getBackground().equals(Color.GREEN)) {
                hasSelectedSeat = true;
                break;
            }
        }

        if (!hasSelectedSeat) {
            JOptionPane.showMessageDialog(
                    null,
                    "Vui lòng chọn ít nhất một ghế trước khi đặt vé!",
                    "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Hiển thị hộp thoại xác nhận DUY NHẤT MỘT LẦN
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn đặt các ghế đã chọn không?",
                "Xác nhận đặt vé",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Nếu người dùng hủy bỏ, thoát luôn
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Duyệt qua danh sách ghế và đặt vé
        for (JButton ghe : danhSachGhe) {
            if (ghe.getBackground().equals(Color.GREEN)) {
                String seatName = ghe.getName();
                ghe.setBackground(Color.RED); // Đánh dấu ghế đã đặt

                String roomId = clickedShowTime.getScreenRoomId();
                String seatId = ticketController.getSeatId(seatName, roomId);
                String showTimeId = clickedShowTime.getId();

                try {
                    boolean result = or.datVe(showTimeId, seatId);
                    if (!result) {
                        JOptionPane.showMessageDialog(
                                null,
                                "❌ Đặt vé thất bại cho ghế " + seatName + ".",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE
                        );
                        ghe.setBackground(Color.GREEN); // Khôi phục màu nếu lỗi
                    }
                } catch (Exception e) {
                    ghe.setBackground(Color.GREEN); // Khôi phục nếu lỗi
                    JOptionPane.showMessageDialog(
                            null,
                            "💥 Lỗi khi kết nối hoặc truy vấn CSDL với ghế " + seatName + ":\n" + e.getMessage(),
                            "Lỗi CSDL",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    }//GEN-LAST:event_orderTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SEAT;
    private javax.swing.JPanel Time;
    private javax.swing.JPanel Titles;
    private javax.swing.JButton cancelTicket;
    private javax.swing.JLabel chooseTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFilm;
    private javax.swing.JButton orderTicket;
    private javax.swing.JLabel ticketManagement;
    // End of variables declaration//GEN-END:variables

    private void taoGhe() {
        SEAT.setLayout(new GridLayout(5, 8, 5, 5));
        SEAT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        String[] hangGhe = {"A", "B", "C", "D", "E"};
        for (String hang : hangGhe) {
            for (int col = 1; col <= 8; col++) {
                String gheText = hang + col;
                JButton button = new JButton(gheText);
                button.setBackground(UIManager.getColor("Button.background"));
                button.setName(gheText);

                button.addActionListener(new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        if (button.getBackground().equals(Color.RED)) {
                            selectedButton.add(button);
                            button.setBackground(Color.ORANGE);
                        } else if (button.getBackground().equals(Color.ORANGE)) {
                            button.setBackground(Color.RED);
                            selectedButton.remove(button);
                        } else if (button.getBackground().equals(Color.GREEN)) {
                            button.setBackground(UIManager.getColor("Button.background"));
                        } else {
                            button.setBackground(Color.green);
                        }
                    }
                });

                button.setFont(new Font("Arial", Font.BOLD, 12));
                SEAT.add(button);
                danhSachGhe.add(button);
            }
        }
    }
}
