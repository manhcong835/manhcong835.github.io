/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.Account;

public class Home extends javax.swing.JFrame {

    private HomePanel homePanel;
    private MoviePanel moviePanel;
    private ScreeningPanel screeningPanel;
    private TicketPanel ticketPanel;
    private AccountPanel accountPanel;
    private BillPanel billPanel;
    private CustomerPanel customerPanel;
    private AdminUpdatePanel adminUpdatePanel;
    private Account account;

    public Home() {
        initComponents();
        contentPanel.setPreferredSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        initPanels();
        this.setSize(1400, 700);
        this.setLocationRelativeTo(null);
        hideAllLabels();
        setHoverEffect(lbHome, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbMovie, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbTicket, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbScreen, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbAccount, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbBill, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbCustomer, new Color(255, 204, 0), new Color(171, 250, 136));
        setHoverEffect(lbLogout, new Color(255, 204, 0), new Color(171, 250, 136));
        lbHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20)); // top, left, bottom, right
        lbMovie.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbScreen.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbAccount.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbTicket.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbCustomer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        lbhello.setHorizontalAlignment(SwingConstants.CENTER);
        lbhello.setVerticalAlignment(SwingConstants.CENTER);
        avatar.setHorizontalAlignment(SwingConstants.CENTER);
        avatar.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void hideAllLabels() {
        lbBill.setVisible(false);
        lbAccount.setVisible(false);
        lbMovie.setVisible(false);
        lbScreen.setVisible(false);
        lbTicket.setVisible(false);
        lbCustomer.setVisible(false);
    }

    public void setAccount(Account account) {
        this.account = account;
        if (adminUpdatePanel != null) {
            adminUpdatePanel.setAccount(account);
        }
    }

    public JLabel getLbCustomer() {
        return lbCustomer;
    }

    public JLabel getLbBill() {
        return lbBill;
    }

    public JLabel getLbAccount() {
        return lbAccount;
    }

    public JLabel getLbHome() {
        return lbHome;
    }

    public JLabel getLbLogout() {
        return lbLogout;
    }

    public JLabel getLbHello() {
        return lbhello;
    }

    public JLabel getLbMovie() {
        return lbMovie;
    }

    public JLabel getLbScreen() {
        return lbScreen;
    }

    public JLabel getLbTicket() {
        return lbTicket;
    }

    private void initPanels() {
        Dimension fixedSize = new Dimension(1200, 700);
        homePanel = new HomePanel();
        homePanel.setPreferredSize(fixedSize);
        ticketPanel = new TicketPanel();
        ticketPanel.setPreferredSize(fixedSize);
        screeningPanel = new ScreeningPanel(ticketPanel);
        screeningPanel.setPreferredSize(fixedSize);
        moviePanel = new MoviePanel(screeningPanel);
        moviePanel.setPreferredSize(fixedSize);
        accountPanel = new AccountPanel();
        accountPanel.setPreferredSize(fixedSize);
        billPanel = new BillPanel();
        billPanel.setPreferredSize(fixedSize);
        customerPanel = new CustomerPanel();
        customerPanel.setPreferredSize(fixedSize);
        adminUpdatePanel = new AdminUpdatePanel();
        adminUpdatePanel.setPreferredSize(fixedSize);
        adminUpdatePanel.setHome(this);
        contentPanel.add(homePanel, "home");
        contentPanel.add(moviePanel, "movie");
        contentPanel.add(screeningPanel, "screening");
        contentPanel.add(ticketPanel, "ticket");
        contentPanel.add(accountPanel, "account");
        contentPanel.add(billPanel, "bill");
        contentPanel.add(customerPanel, "customer");
        contentPanel.add(adminUpdatePanel, "admininfo");
        contentPanel.revalidate();
        contentPanel.repaint();

        showPanel("home");
    }

    private void showPanel(String name) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, name);
    }

    private void setHoverEffect(JLabel label, Color hoverColor, Color defaultColor) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label.setForeground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                label.setForeground(defaultColor);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        lbhello = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbScreen = new javax.swing.JLabel();
        lbMovie = new javax.swing.JLabel();
        lbAccount = new javax.swing.JLabel();
        lbTicket = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        lbBill = new javax.swing.JLabel();
        lbCustomer = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 700));

        avatar.setForeground(new java.awt.Color(255, 255, 255));
        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar-main.png"))); // NOI18N
        avatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarMouseClicked(evt);
            }
        });

        lbhello.setText("Xin chào, Admin");

        lbHome.setBackground(new java.awt.Color(255, 255, 255));
        lbHome.setText("🏠 Trang chủ");
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
        });

        lbScreen.setText("📅 Quản lý suất chiếu");
        lbScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbScreenMouseClicked(evt);
            }
        });

        lbMovie.setText("🎬 Quản lý phim");
        lbMovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMovieMouseClicked(evt);
            }
        });

        lbAccount.setText("👤 Quản lý tài khoản");
        lbAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAccountMouseClicked(evt);
            }
        });

        lbTicket.setText("🎟️ Quản lý vé");
        lbTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTicketMouseClicked(evt);
            }
        });

        lbLogout.setForeground(new java.awt.Color(171, 250, 135));
        lbLogout.setText("↩️ Logout");
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
        });

        lbBill.setText("🎟️ Quản lý đơn");
        lbBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBillMouseClicked(evt);
            }
        });

        lbCustomer.setText("👤 Quản lý khách hàng");
        lbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(lbhello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbhello)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBill, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(lbLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        showPanel("home");
        homePanel.reloadData();
    }//GEN-LAST:event_lbHomeMouseClicked

    private void lbMovieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMovieMouseClicked
        showPanel("movie");
    }//GEN-LAST:event_lbMovieMouseClicked

    private void lbScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbScreenMouseClicked
        showPanel("screening");
    }//GEN-LAST:event_lbScreenMouseClicked

    private void lbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseClicked
        showPanel("account");
    }//GEN-LAST:event_lbAccountMouseClicked

    private void lbTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTicketMouseClicked
        showPanel("ticket");
    }//GEN-LAST:event_lbTicketMouseClicked

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Xác nhận đăng xuất",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // Mở lại màn hình đăng nhập
            new Login().setVisible(true);

            // Đóng cửa sổ hiện tại (Home)
            this.dispose();
        }
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void avatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarMouseClicked
        if (account != null) {
            adminUpdatePanel.setAccount(account); 
        }
        showPanel("admininfo");
    }//GEN-LAST:event_avatarMouseClicked

    private void lbBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBillMouseClicked
        showPanel("bill");
        billPanel.loadTable();
    }//GEN-LAST:event_lbBillMouseClicked

    private void lbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCustomerMouseClicked
        showPanel("customer");
    }//GEN-LAST:event_lbCustomerMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbCustomer;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbMovie;
    private javax.swing.JLabel lbScreen;
    private javax.swing.JLabel lbTicket;
    private javax.swing.JLabel lbhello;
    // End of variables declaration//GEN-END:variables
}
