package view;

import controller.UserHomeController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
//import java.awt.*;
import model.Movie;
import java.util.Arrays;
import java.util.List;

public class userHomePanel extends javax.swing.JPanel {

    private UserHomeController controller;
    private userHeaderPanel home;

    public userHomePanel(userHeaderPanel home) {
        initComponents();
        this.home = home;

        this.setSize(1400, 600);
        controller = new UserHomeController();
        JPanel gridPanel = new JPanel(new GridLayout(0, 4, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gridPanel.setBackground(Color.WHITE);

        // Lấy dữ liệu từ DB
        List<Movie> movies = controller.getAllMovies();
        for (Movie m : movies) {
            gridPanel.add(createMovieCard(m));

        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        // ===== Tiêu đề "Suất Chiếu" =====
        JLabel titleLabel = new JLabel("Suất Chiếu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(30, 30, 60));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0x45a29e)); // Màu xanh #45a29e

        // Tạo một JPanel chứa title + gridPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Thêm centerPanel vào giữa giao diện
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createMovieCard(Movie movie) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(150, 500));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(0, 400));
        imagePanel.setBackground(Color.LIGHT_GRAY);
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = panel.getWidth();
                int height = 400;
                if (movie.getImage() == null || movie.getImage().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "ảnh null", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    JPanel imagePanel = new JPanel();
                    imagePanel.setPreferredSize(new Dimension(200, 140));
                    imagePanel.setBackground(Color.LIGHT_GRAY);
                    imagePanel.add(new JLabel("Ảnh đang được cập nhật"));
                    panel.add(imagePanel, BorderLayout.NORTH);
                } else {
                    ImageIcon icon = new ImageIcon(movie.getImage());
                    Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaled));
                }
            }
        });
        panel.add(imagePanel, BorderLayout.NORTH);
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(0, 100));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font boldFont = new Font("Arial", Font.BOLD, 13);
        JLabel titleLabel = new JLabel(movie.getTitle());
        JLabel genreLabel = new JLabel("Thể loại: " + movie.getGenre());
        JLabel durationLabel = new JLabel("Thời lượng: " + movie.getDuration());
        titleLabel.setFont(boldFont);
        genreLabel.setFont(boldFont);
        durationLabel.setFont(boldFont);
        infoPanel.add(titleLabel);
        infoPanel.add(genreLabel);
        infoPanel.add(durationLabel);
        panel.add(infoPanel, BorderLayout.CENTER);
        Color normalBg = Color.WHITE;
        Color hoverBg = new Color(70, 130, 180); 
        Color normalFg = Color.BLACK;
        Color hoverFg = Color.WHITE;
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoPanel.setBackground(hoverBg);
                titleLabel.setForeground(hoverFg);
                genreLabel.setForeground(hoverFg);
                durationLabel.setForeground(hoverFg);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoPanel.setBackground(normalBg);
                titleLabel.setForeground(normalFg);
                genreLabel.setForeground(normalFg);
                durationLabel.setForeground(normalFg);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoPanel.setBackground(hoverBg);
                titleLabel.setForeground(hoverFg);
                genreLabel.setForeground(hoverFg);
                durationLabel.setForeground(hoverFg);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoPanel.setBackground(normalBg);
                titleLabel.setForeground(normalFg);
                genreLabel.setForeground(normalFg);
                durationLabel.setForeground(normalFg);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.showDetail(movie);
            }
        });return panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(1400, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
