/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import model.Account;
import controller.LoginController;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Login extends javax.swing.JFrame {

    private Home home;
    private userHeaderPanel homeUser;
    private Register register;
    private BookTicketUserPanel book;
    private AdminUpdatePanel adminUpdatePanel;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        Home(home);
        HomeUser(homeUser);
        setResizable(false);
    }

    public void Home(Home home) {
        this.home = home;
    }

    public void Register(Register register) {
        this.register = register;
    }

    public void HomeUser(userHeaderPanel homeUser) {
        this.homeUser = homeUser;
    }

    public void AdminUpdatePanel(AdminUpdatePanel adminUpdatePanel) {
        this.adminUpdatePanel = adminUpdatePanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        Login_Tittle = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        Login_Button = new javax.swing.JButton();
        ChangePassword_Button = new javax.swing.JButton();
        Login_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setMaximumSize(new java.awt.Dimension(700, 400));

        Login_Tittle.setBackground(new java.awt.Color(51, 51, 255));
        Login_Tittle.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        Login_Tittle.setForeground(new java.awt.Color(255, 51, 51));
        Login_Tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login_Tittle.setText("Đăng nhập");

        Username.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 51, 51));
        Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username.setText("Tên đăng nhập : ");

        Password.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 51, 51));
        Password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Password.setText("Mật khẩu : ");

        Login_Button.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Login_Button.setForeground(new java.awt.Color(255, 51, 51));
        Login_Button.setText("Đăng nhập");
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });

        ChangePassword_Button.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ChangePassword_Button.setForeground(new java.awt.Color(255, 51, 51));
        ChangePassword_Button.setText("Đăng ký");
        ChangePassword_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePassword_ButtonMouseClicked(evt);
            }
        });
        ChangePassword_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePassword_ButtonActionPerformed(evt);
            }
        });

        Login_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login_Icon.png"))); // NOI18N

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(Login_Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Login_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Username))
                        .addGap(28, 28, 28)))
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameField)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ChangePassword_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Login_Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChangePassword_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(Login_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonActionPerformed
        // TODO add your handling code here:
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        // Gọi controller để kiểm tra đăng nhập
        LoginController loginController = new LoginController();
        Account account = loginController.login(username, password);
        if (account != null) {
            if (account.getRole().equalsIgnoreCase("user")) {
                if (account.getTrangthai().equalsIgnoreCase("Không hoạt động")) {
                    JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                this.homeUser = new userHeaderPanel();
                homeUser.setVisible(true);
                homeUser.setAccount(account);
                homeUser.getLbHello().setText("Xin chào, "+ account.getName());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                // Mở màn hình chính
                Home home = new Home();
                home.setAccount(account);
                home.setVisible(true);
                if (adminUpdatePanel == null) {
                    adminUpdatePanel = new AdminUpdatePanel();
                }
                adminUpdatePanel.setAccount(account);
                home.getLbHello().setText("Xin chào, " + account.getName() + "!");
                String roles = account.getRole();
                String[] roleArray = roles.split(",");
                // Chuyển sang List nếu cần
                List<String> roleList = Arrays.asList(roleArray);
                if (roleList.contains("Quản lý phim")) {
                    home.getLbMovie().setVisible(true);
                }
                if (roleList.contains("Quản lý vé")) {
                    home.getLbTicket().setVisible(true);
                }
                if (roleList.contains("Quản lý tài khoản")) {
                    home.getLbAccount().setVisible(true);
                }
                if (roleList.contains("Quản lý suất chiếu")) {
                    home.getLbScreen().setVisible(true);
                }
                if (roleList.contains("Quản lý khách hàng")) {
                    home.getLbCustomer().setVisible(true);
                }
                if (roleList.contains("Quản lý hoá đơn")) {
                    home.getLbBill().setVisible(true);
                }
                if (roleList.contains("Quản lý tất cả")) {
                    home.getLbScreen().setVisible(true);
                    home.getLbAccount().setVisible(true);
                    home.getLbTicket().setVisible(true);
                    home.getLbMovie().setVisible(true);
                    home.getLbCustomer().setVisible(true);
                    home.getLbBill().setVisible(true);
                }
                // Đóng màn hình đăng nhập
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Tên đăng nhập hoặc mật khẩu không đúng!",
                    "Lỗi đăng nhập",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Login_ButtonActionPerformed

    private void ChangePassword_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePassword_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePassword_ButtonActionPerformed

    private void ChangePassword_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassword_ButtonMouseClicked
        Register register = new Register();
        register.setVisible(true);
        register.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_ChangePassword_ButtonMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangePassword_Button;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JButton Login_Button;
    private javax.swing.JLabel Login_Icon;
    private javax.swing.JLabel Login_Tittle;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
