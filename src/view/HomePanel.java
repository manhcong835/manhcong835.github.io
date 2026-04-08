package view;

import controller.DashboardController;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class HomePanel extends javax.swing.JPanel {

    private DashboardController controller;
    

    public HomePanel() {
        initComponents();
        controller = new DashboardController();
        reloadData();
        num1.setHorizontalAlignment(SwingConstants.CENTER);
        num1.setVerticalAlignment(SwingConstants.CENTER);

        num1.setHorizontalAlignment(SwingConstants.CENTER);
        num1.setVerticalAlignment(SwingConstants.CENTER);

        num2.setHorizontalAlignment(SwingConstants.CENTER);
        num2.setVerticalAlignment(SwingConstants.CENTER);

        num3.setHorizontalAlignment(SwingConstants.CENTER);
        num3.setVerticalAlignment(SwingConstants.CENTER);

        num4.setHorizontalAlignment(SwingConstants.CENTER);
        num4.setVerticalAlignment(SwingConstants.CENTER);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setVerticalAlignment(SwingConstants.CENTER);

        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setVerticalAlignment(SwingConstants.CENTER);

        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setVerticalAlignment(SwingConstants.CENTER);

        title3.setHorizontalAlignment(SwingConstants.CENTER);
        title3.setVerticalAlignment(SwingConstants.CENTER);

        title4.setHorizontalAlignment(SwingConstants.CENTER);
        title4.setVerticalAlignment(SwingConstants.CENTER);

        Color shadowColor = new Color(0, 0, 0, 50); // Màu đổ bóng trong suốt

        Border shadowBorder = BorderFactory.createMatteBorder(0, 0, 10, 10, shadowColor);
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10); // Padding bên trong

        card1.setBorder(BorderFactory.createCompoundBorder(shadowBorder, paddingBorder));
        card2.setBorder(BorderFactory.createCompoundBorder(shadowBorder, paddingBorder));
        card3.setBorder(BorderFactory.createCompoundBorder(shadowBorder, paddingBorder));
        card4.setBorder(BorderFactory.createCompoundBorder(shadowBorder, paddingBorder));

    }
    public static String formatWithDotSeparator(double number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
        return formatter.format(number);
    }
    public void reloadData() {
        int totalMovie = controller.getTotalPhim();
        int totalSuatChieu = controller.getTotalSuatChieu();
        int totalAccount = controller.getTotalAccount();
        int totalTicket= controller.getTotalTicket();
        double Money = controller.getTotalMoney();
        num1.setText(String.valueOf(totalMovie));
        num2.setText(String.valueOf(totalAccount));
        num3.setText(String.valueOf(totalTicket));
        num4.setText(String.valueOf(totalSuatChieu));
        totalMoney.setText(formatWithDotSeparator(Money) + " vnđ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalMoney = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        num1 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        card2 = new javax.swing.JPanel();
        num2 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        card3 = new javax.swing.JPanel();
        num3 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        card4 = new javax.swing.JPanel();
        num4 = new javax.swing.JLabel();
        title4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 90, 115));
        jLabel1.setText("Trang chủ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(16, 90, 115));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(16, 90, 115));
        jLabel3.setText("Tổng doanh thu:");

        totalMoney.setBackground(new java.awt.Color(197, 213, 213));
        totalMoney.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalMoney.setForeground(new java.awt.Color(16, 90, 117));
        totalMoney.setText("5.000.000 vnđ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalMoney)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(2, 2, 30, 30));

        card1.setBackground(new java.awt.Color(25, 132, 146));

        num1.setBackground(new java.awt.Color(242, 50, 48));
        num1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        num1.setForeground(new java.awt.Color(90, 225, 147));

        title1.setForeground(new java.awt.Color(90, 225, 147));
        title1.setText("🎬 Tổng phim");

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(num1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        jPanel10.add(card1);

        card2.setBackground(new java.awt.Color(25, 132, 146));

        num2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        num2.setForeground(new java.awt.Color(90, 225, 147));

        title2.setForeground(new java.awt.Color(90, 225, 147));
        title2.setText("👤 Tổng tài khoản");

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(num2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        jPanel10.add(card2);

        card3.setBackground(new java.awt.Color(25, 132, 146));

        num3.setBackground(new java.awt.Color(242, 137, 165));
        num3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        num3.setForeground(new java.awt.Color(90, 225, 147));
        num3.setText("50");

        title3.setForeground(new java.awt.Color(90, 225, 147));
        title3.setText("🎟️ Tổng vé đã đặt");

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
            .addComponent(num3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        jPanel10.add(card3);

        card4.setBackground(new java.awt.Color(25, 132, 146));

        num4.setBackground(new java.awt.Color(242, 50, 48));
        num4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        num4.setForeground(new java.awt.Color(90, 225, 147));

        title4.setForeground(new java.awt.Color(90, 225, 147));
        title4.setText("📅 Tổng suất chiếu");

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(num4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title4, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addComponent(num4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        jPanel10.add(card4);

        add(jPanel10, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel num1;
    private javax.swing.JLabel num2;
    private javax.swing.JLabel num3;
    private javax.swing.JLabel num4;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel totalMoney;
    // End of variables declaration//GEN-END:variables
}
