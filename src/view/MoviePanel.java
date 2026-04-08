/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.MovieController;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Movie;
import java.util.List;

public class MoviePanel extends javax.swing.JPanel {

    private MovieController movieController;
    private ScreeningPanel screeningPanel;

    public MoviePanel(ScreeningPanel screeningPanel) {
        initComponents();
        this.screeningPanel = screeningPanel;
        movieController = new MovieController();
        loadTable();
        autoID();     // Sinh mã mới
        tableMovie.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedMovieToFormFromDatabase();
            }
        });
        txtIDMovie.setEditable(false);
        icon1.setIcon(getScaledIcon("/images/movie-projector.png", 75, 75));
        lbIconIDMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconTitleMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconDurationMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconGenreMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconReleaseMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconActorMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconDescriptionMovie.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        lbIconDirectorMovie1.setIcon(getScaledIcon("/images/IDMovie.png", 25, 25));
        setHoverEffect(btnResetMovie, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnAddMovie, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnEditMovie, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnDeleteMovie, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnSearchMovie, new Color(16, 90, 115), new Color(255, 255, 255));
        txtDescriptionMovie.setLineWrap(true);        
        txtDescriptionMovie.setWrapStyleWord(true);
    }

    //set lại kích thước ảnh
    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    //hover button
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

    public ImageIcon getScaledIconFromPath(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void loadTable() {
        List<Movie> movies = movieController.getAllMovies();
        DefaultTableModel model = (DefaultTableModel) tableMovie.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (Movie m : movies) {
            model.addRow(new Object[]{
                m.getId(),
                m.getTitle(),
                m.getGenre(),
                m.getDuration(),
                m.getReleaseDate(),
                m.getImage(),
                m.getActors(),
                m.getDescription(),
                m.getDirector()
            });
        }
    }

    // Điền thông tin vào form nhập
    private void loadSelectedMovieToFormFromDatabase() {
        int selectedRow = tableMovie.getSelectedRow();
        if (selectedRow >= 0) {
            String movieId = tableMovie.getValueAt(selectedRow, 0).toString();
            // Lấy đối tượng Movie thông qua controller
            Movie selectedMovie = movieController.getMovieById(movieId);
            if (selectedMovie != null) {
                txtIDMovie.setText(selectedMovie.getId());
                txtTitleMovie.setText(selectedMovie.getTitle());
                txtGenreMovie.setText(selectedMovie.getGenre());
                txtDurationMovie.setText(String.valueOf(selectedMovie.getDuration()));
                txtReleaseMovie.setText(selectedMovie.getReleaseDate().toString());
                txtDirectorMovie.setText(selectedMovie.getDirector());
                txtActorMovie.setText(selectedMovie.getActors());
                txtDescriptionMovie.setText(selectedMovie.getDescription());
                String selectedImagePath = selectedMovie.getImage();
                ImageIcon icon = getScaledIconFromPath(selectedImagePath, 200, 260);
                displayImage.setIcon(icon);
                displayImage.setToolTipText(selectedImagePath);
            }
        }
    }

    public void clearForm() {
        txtTitleMovie.setText("");
        txtGenreMovie.setText("");
        txtDurationMovie.setText("");
        txtReleaseMovie.setText("");
        displayImage.setIcon(null);
        displayImage.setToolTipText(null);
        txtActorMovie.setText("");
        txtDescriptionMovie.setText("");
        txtDirectorMovie.setText("");
    }

    public void autoID() {
        List<Movie> list = movieController.getAllMovies();
        int max = 0;
        for (Movie m : list) {
            String id = m.getId(); // Ví dụ: P001
            if (id.startsWith("P")) {
                try {
                    int num = Integer.parseInt(id.substring(2));
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                    // Bỏ qua ID không hợp lệ
                }
            }
        }
        String ma;
        int next = max + 1;
        if (next < 10) {
            ma = "P00" + next;
        } else if (next < 100) {
            ma = "P0" + next;
        } else {
            ma = "P" + next;
        }
        txtIDMovie.setText(ma);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MidPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMovie = new javax.swing.JTable();
        txtSearchMovie = new javax.swing.JTextField();
        btnSearchMovie = new javax.swing.JButton();
        BottomPanel = new javax.swing.JPanel();
        txtIDMovie = new javax.swing.JTextField();
        lbIDMovie = new javax.swing.JLabel();
        lbIconIDMovie = new javax.swing.JLabel();
        txtTitleMovie = new javax.swing.JTextField();
        lbTitleMovie = new javax.swing.JLabel();
        lbIconTitleMovie = new javax.swing.JLabel();
        txtGenreMovie = new javax.swing.JTextField();
        lbGenreMovie = new javax.swing.JLabel();
        lbIconGenreMovie = new javax.swing.JLabel();
        txtDurationMovie = new javax.swing.JTextField();
        lbDurationMovie = new javax.swing.JLabel();
        lbIconDurationMovie = new javax.swing.JLabel();
        txtReleaseMovie = new javax.swing.JTextField();
        lbReleaseMovie = new javax.swing.JLabel();
        lbIconReleaseMovie = new javax.swing.JLabel();
        btnDeleteMovie = new javax.swing.JButton();
        btnAddMovie = new javax.swing.JButton();
        btnEditMovie = new javax.swing.JButton();
        chooseImage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        displayImage = new javax.swing.JLabel();
        btnResetMovie = new javax.swing.JButton();
        txtDirectorMovie = new javax.swing.JTextField();
        lbDirectorMovie = new javax.swing.JLabel();
        lbIconDirectorMovie1 = new javax.swing.JLabel();
        txtActorMovie = new javax.swing.JTextField();
        lbActorMovie = new javax.swing.JLabel();
        lbIconActorMovie = new javax.swing.JLabel();
        lbDescriptionMovie = new javax.swing.JLabel();
        lbIconDescriptionMovie = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescriptionMovie = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.setPreferredSize(new java.awt.Dimension(912, 75));

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/movie-projector.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(90, 225, 147));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý phim");

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(425, 425, 425))
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleLayout.createSequentialGroup()
                .addGroup(TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TitleLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(Title, java.awt.BorderLayout.PAGE_START);

        MidPanel.setBackground(new java.awt.Color(255, 255, 255));
        MidPanel.setPreferredSize(new java.awt.Dimension(1200, 300));
        MidPanel.setLayout(null);

        jScrollPane2.setAutoscrolls(true);

        tableMovie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phim", "Tên phim", "Thể loại", "Thời lượng", "Ngày khởi chiếu", "Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableMovie.setPreferredSize(new java.awt.Dimension(500, 200));
        jScrollPane2.setViewportView(tableMovie);

        MidPanel.add(jScrollPane2);
        jScrollPane2.setBounds(50, 60, 1070, 200);
        MidPanel.add(txtSearchMovie);
        txtSearchMovie.setBounds(410, 20, 290, 30);

        btnSearchMovie.setBackground(new java.awt.Color(153, 204, 255));
        btnSearchMovie.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSearchMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchMovie.setText("Tìm kiếm");
        btnSearchMovie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearchMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMovieActionPerformed(evt);
            }
        });
        MidPanel.add(btnSearchMovie);
        btnSearchMovie.setBounds(700, 20, 120, 30);

        add(MidPanel, java.awt.BorderLayout.CENTER);

        BottomPanel.setBackground(new java.awt.Color(255, 255, 255));
        BottomPanel.setPreferredSize(new java.awt.Dimension(1200, 325));
        BottomPanel.setLayout(null);

        txtIDMovie.setAlignmentX(0.0F);
        txtIDMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtIDMovie);
        txtIDMovie.setBounds(150, 30, 210, 30);

        lbIDMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbIDMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbIDMovie.setText("Mã phim:");
        lbIDMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbIDMovie);
        lbIDMovie.setBounds(150, 10, 63, 20);

        lbIconIDMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconIDMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconIDMovie);
        lbIconIDMovie.setBounds(110, 30, 30, 20);

        txtTitleMovie.setAlignmentX(0.0F);
        txtTitleMovie.setAlignmentY(0.0F);
        txtTitleMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleMovieActionPerformed(evt);
            }
        });
        BottomPanel.add(txtTitleMovie);
        txtTitleMovie.setBounds(150, 80, 210, 30);

        lbTitleMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitleMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbTitleMovie.setText("Tên phim:");
        lbTitleMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbTitleMovie);
        lbTitleMovie.setBounds(150, 60, 66, 20);

        lbIconTitleMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconTitleMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconTitleMovie);
        lbIconTitleMovie.setBounds(110, 80, 30, 20);

        txtGenreMovie.setAlignmentX(0.0F);
        txtGenreMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtGenreMovie);
        txtGenreMovie.setBounds(150, 130, 210, 30);

        lbGenreMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGenreMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbGenreMovie.setText("Thể loại:");
        lbGenreMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbGenreMovie);
        lbGenreMovie.setBounds(150, 110, 57, 20);

        lbIconGenreMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconGenreMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconGenreMovie);
        lbIconGenreMovie.setBounds(110, 130, 30, 20);

        txtDurationMovie.setAlignmentX(0.0F);
        txtDurationMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtDurationMovie);
        txtDurationMovie.setBounds(150, 180, 210, 30);

        lbDurationMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDurationMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbDurationMovie.setText("Thời lượng:");
        lbDurationMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbDurationMovie);
        lbDurationMovie.setBounds(150, 160, 100, 20);

        lbIconDurationMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconDurationMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconDurationMovie);
        lbIconDurationMovie.setBounds(110, 180, 30, 20);

        txtReleaseMovie.setAlignmentX(0.0F);
        txtReleaseMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtReleaseMovie);
        txtReleaseMovie.setBounds(150, 230, 210, 30);

        lbReleaseMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbReleaseMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbReleaseMovie.setText("Ngày khởi chiếu:");
        lbReleaseMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbReleaseMovie);
        lbReleaseMovie.setBounds(150, 210, 140, 20);

        lbIconReleaseMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconReleaseMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconReleaseMovie);
        lbIconReleaseMovie.setBounds(110, 230, 30, 20);

        btnDeleteMovie.setBackground(new java.awt.Color(153, 204, 255));
        btnDeleteMovie.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnDeleteMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMovie.setText("Xóa");
        btnDeleteMovie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMovieActionPerformed(evt);
            }
        });
        BottomPanel.add(btnDeleteMovie);
        btnDeleteMovie.setBounds(480, 280, 120, 30);

        btnAddMovie.setBackground(new java.awt.Color(153, 204, 255));
        btnAddMovie.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnAddMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMovie.setText("Thêm");
        btnAddMovie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieActionPerformed(evt);
            }
        });
        BottomPanel.add(btnAddMovie);
        btnAddMovie.setBounds(180, 280, 120, 30);

        btnEditMovie.setBackground(new java.awt.Color(153, 204, 255));
        btnEditMovie.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnEditMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnEditMovie.setText("Sửa");
        btnEditMovie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMovieActionPerformed(evt);
            }
        });
        BottomPanel.add(btnEditMovie);
        btnEditMovie.setBounds(330, 280, 120, 30);

        chooseImage.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        chooseImage.setForeground(new java.awt.Color(16, 90, 115));
        chooseImage.setText("Chọn ảnh");
        chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageActionPerformed(evt);
            }
        });
        BottomPanel.add(chooseImage);
        chooseImage.setBounds(960, 280, 130, 27);

        jPanel3.setPreferredSize(new java.awt.Dimension(150, 200));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        BottomPanel.add(jPanel3);
        jPanel3.setBounds(930, 10, 200, 260);

        btnResetMovie.setBackground(new java.awt.Color(153, 204, 255));
        btnResetMovie.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnResetMovie.setForeground(new java.awt.Color(255, 255, 255));
        btnResetMovie.setText("Làm mới");
        btnResetMovie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetMovieActionPerformed(evt);
            }
        });
        BottomPanel.add(btnResetMovie);
        btnResetMovie.setBounds(630, 280, 120, 30);

        txtDirectorMovie.setAlignmentX(0.0F);
        txtDirectorMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtDirectorMovie);
        txtDirectorMovie.setBounds(480, 30, 210, 30);

        lbDirectorMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDirectorMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbDirectorMovie.setText("Đạo diễn:");
        lbDirectorMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbDirectorMovie);
        lbDirectorMovie.setBounds(480, 10, 64, 20);

        lbIconDirectorMovie1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconDirectorMovie1.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconDirectorMovie1);
        lbIconDirectorMovie1.setBounds(440, 30, 30, 20);

        txtActorMovie.setAlignmentX(0.0F);
        txtActorMovie.setAlignmentY(0.0F);
        BottomPanel.add(txtActorMovie);
        txtActorMovie.setBounds(480, 80, 210, 30);

        lbActorMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbActorMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbActorMovie.setText("Diễn viên:");
        lbActorMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbActorMovie);
        lbActorMovie.setBounds(480, 60, 80, 20);

        lbIconActorMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconActorMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconActorMovie);
        lbIconActorMovie.setBounds(440, 80, 30, 20);

        lbDescriptionMovie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDescriptionMovie.setForeground(new java.awt.Color(16, 90, 115));
        lbDescriptionMovie.setText("Mô tả:");
        lbDescriptionMovie.setAlignmentY(0.0F);
        BottomPanel.add(lbDescriptionMovie);
        lbDescriptionMovie.setBounds(480, 110, 43, 20);

        lbIconDescriptionMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IDMovie.png"))); // NOI18N
        lbIconDescriptionMovie.setPreferredSize(new java.awt.Dimension(25, 25));
        BottomPanel.add(lbIconDescriptionMovie);
        lbIconDescriptionMovie.setBounds(440, 130, 30, 20);

        txtDescriptionMovie.setColumns(20);
        txtDescriptionMovie.setRows(5);
        jScrollPane1.setViewportView(txtDescriptionMovie);

        BottomPanel.add(jScrollPane1);
        jScrollPane1.setBounds(480, 130, 320, 130);

        add(BottomPanel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMovieActionPerformed
        String keyword = txtSearchMovie.getText();
        List<Movie> searchResults = movieController.searchMoviesByTitle(keyword);
        DefaultTableModel model = (DefaultTableModel) tableMovie.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (Movie m : searchResults) {
            model.addRow(new Object[]{
                m.getId(),
                m.getTitle(),
                m.getGenre(),
                m.getDuration(),
                m.getReleaseDate(),
                m.getImage(),
                m.getDirector(),
                m.getActors(),
                m.getDescription()
            });
        }
    }//GEN-LAST:event_btnSearchMovieActionPerformed

    private void chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("png", "jpeg", "jpg", "jfif", "svg");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this, "Chọn file");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            displayImage.setIcon(getScaledIconFromPath(path, 200, 260));
            displayImage.setText("");
            displayImage.setToolTipText(path);
        }
    }//GEN-LAST:event_chooseImageActionPerformed

    private void btnEditMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMovieActionPerformed
        try {
            Movie movie = new Movie();
            movie.setId(txtIDMovie.getText());
            movie.setTitle(txtTitleMovie.getText());
            movie.setGenre(txtGenreMovie.getText());
            movie.setDuration(Integer.parseInt(txtDurationMovie.getText()));
            movie.setReleaseDate(java.sql.Date.valueOf(txtReleaseMovie.getText()));
            movie.setImage(displayImage.getToolTipText());
            movie.setDirector(txtDirectorMovie.getText());
            movie.setActors(txtActorMovie.getText());
            movie.setDescription(txtDescriptionMovie.getText());

            if (movieController.isDuplicateMovieExcludingSelf(txtIDMovie.getText(), txtTitleMovie.getText(), java.sql.Date.valueOf(txtReleaseMovie.getText()))) {
                JOptionPane.showMessageDialog(this, "Phim đã tồn tại");
                return;
            }
            if (movieController.updateMovie(movie)) {
                JOptionPane.showMessageDialog(this, "Cập nhật phim thành công");
                loadTable();
                screeningPanel.loadMoviesToComboBox();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật phim thất bại");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
        }
    }//GEN-LAST:event_btnEditMovieActionPerformed

    private void btnAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieActionPerformed
        try {
            autoID();
            String id = txtIDMovie.getText();
            String title = txtTitleMovie.getText();
            String genre = txtGenreMovie.getText();
            int duration = Integer.parseInt(txtDurationMovie.getText());
            java.sql.Date releaseDate = java.sql.Date.valueOf(txtReleaseMovie.getText());
            String image = displayImage.getToolTipText();
            String director = txtDirectorMovie.getText();
            String actors = txtActorMovie.getText();
            String description = txtDescriptionMovie.getText();

            Movie movie = new Movie();
            movie.setId(id);
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setDuration(duration);
            movie.setReleaseDate(releaseDate);
            movie.setImage(image);
            movie.setDirector(director);
            movie.setActors(actors);
            movie.setDescription(description);

            if (movieController.addMovie(movie)) {
                JOptionPane.showMessageDialog(this, "Thêm phim thành công");
                loadTable();
                autoID();     // Sinh mã mới
                clearForm();
                screeningPanel.loadMoviesToComboBox();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm phim thất bại");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
        }
    }//GEN-LAST:event_btnAddMovieActionPerformed

    private void btnDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMovieActionPerformed
        try {
            String movieId = txtIDMovie.getText();
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa phim này?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                if (movieController.deleteMovie(movieId)) {
                    JOptionPane.showMessageDialog(this, "Xóa phim thành công");
                    loadTable();
                    autoID();     // Sinh mã mới
                    clearForm();
                    screeningPanel.loadMoviesToComboBox();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa phim thất bại");
                }
            }

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            if (errorMessage != null && errorMessage.contains("REFERENCE constraint")) {
                JOptionPane.showMessageDialog(this,
                        "Không thể xóa phim này vì vẫn còn suất chiếu hoặc vé liên quan.",
                        "Lỗi ràng buộc dữ liệu",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Đã xảy ra lỗi: " + errorMessage,
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteMovieActionPerformed

    private void txtTitleMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleMovieActionPerformed

    }//GEN-LAST:event_txtTitleMovieActionPerformed

    private void btnResetMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetMovieActionPerformed
        autoID();
        clearForm();
        loadTable();
    }//GEN-LAST:event_btnResetMovieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel MidPanel;
    private javax.swing.JPanel Title;
    private javax.swing.JButton btnAddMovie;
    private javax.swing.JButton btnDeleteMovie;
    private javax.swing.JButton btnEditMovie;
    private javax.swing.JButton btnResetMovie;
    private javax.swing.JButton btnSearchMovie;
    private javax.swing.JButton chooseImage;
    private javax.swing.JLabel displayImage;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbActorMovie;
    private javax.swing.JLabel lbDescriptionMovie;
    private javax.swing.JLabel lbDirectorMovie;
    private javax.swing.JLabel lbDurationMovie;
    private javax.swing.JLabel lbGenreMovie;
    private javax.swing.JLabel lbIDMovie;
    private javax.swing.JLabel lbIconActorMovie;
    private javax.swing.JLabel lbIconDescriptionMovie;
    private javax.swing.JLabel lbIconDirectorMovie1;
    private javax.swing.JLabel lbIconDurationMovie;
    private javax.swing.JLabel lbIconGenreMovie;
    private javax.swing.JLabel lbIconIDMovie;
    private javax.swing.JLabel lbIconReleaseMovie;
    private javax.swing.JLabel lbIconTitleMovie;
    private javax.swing.JLabel lbReleaseMovie;
    private javax.swing.JLabel lbTitleMovie;
    private javax.swing.JTable tableMovie;
    private javax.swing.JTextField txtActorMovie;
    private javax.swing.JTextArea txtDescriptionMovie;
    private javax.swing.JTextField txtDirectorMovie;
    private javax.swing.JTextField txtDurationMovie;
    private javax.swing.JTextField txtGenreMovie;
    private javax.swing.JTextField txtIDMovie;
    private javax.swing.JTextField txtReleaseMovie;
    private javax.swing.JTextField txtSearchMovie;
    private javax.swing.JTextField txtTitleMovie;
    // End of variables declaration//GEN-END:variables
}
