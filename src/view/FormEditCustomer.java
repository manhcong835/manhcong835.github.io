/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AccountController;
import controller.CustomerUpdateController;
import dao.AccountDao;
import java.awt.Image;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Account;
import model.Movie;

public class FormEditCustomer extends javax.swing.JFrame {

    private CustomerUpdateController controller;
    private Account account;
    private CustomerUpdatePanel customer;
    private userHeaderPanel homeUser;
    private AccountController accountController;
    public FormEditCustomer() {
        initComponents();
        jLabel2.setIcon(getScaledIcon("/images/logo-user.png", 300, 200));
        controller = new CustomerUpdateController();
        accountController = new AccountController();
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(nam);
        genderGroup.add(nu);

    }

    public void setCustomer(CustomerUpdatePanel customer) {
        this.customer = customer;
    }

    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void setHome(userHeaderPanel homeUser) {
        this.homeUser = homeUser;
    }
    
    public void setAccount(Account account) {
        this.account = account;
        reload();
    }

    void reload() {
        Account acc = controller.getCustomerById(account.getId());
        txtUsername.setText(acc.getUsername());
        txtName.setText(acc.getName());
        txtPass.setText(acc.getPassword());
        txtEmail.setText(acc.getEmail());
        txtPhone.setText(acc.getPhone());
        if (acc.getSex().equalsIgnoreCase("Nam")) {
            nam.setSelected(true);
            nu.setSelected(false);
        } else if (acc.getSex().equalsIgnoreCase("Nữ")) {
            nu.setSelected(true);
            nam.setSelected(false);
        }
    }
//    private boolean validateRegisterForm() {
//        String username = txtUsername.getText().trim();
//        String password = new String(newpass.getPassword());
//        String confirmPassword = new String(renewpass.getPassword());
//        String email = txtEmail.getText().trim();
//        String phone = txtPhone.getText().trim();
//        String name = txtName.getText().trim();
//
//        if (username.isEmpty() || 
//               email.isEmpty() || phone.isEmpty() || name.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
//            return false;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp.");
//            return false;
//        }
//
//        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
//            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
//            return false;
//        }
//
//        if (!phone.matches("^[0-9]{9,11}$")) {
//            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
//            return false;
//        }
//
//        if (password.length() < 6) {
//            JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 ký tự trở lên.");
//            return false;
//        }
//
//        return true;
//    }

    private void saveCustomer() {
        String username = txtUsername.getText().trim();
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String sex = nam.isSelected() ? "Nam" : "Nữ";
        String currentPass = new String(txtPass.getPassword());
        String newPass = new String(newpass.getPassword());
        String reNewPass = new String(renewpass.getPassword());
        userHeaderPanel homeUser = userHeaderPanel.instance;
        homeUser.getNameLabel().setText("Xin chào, " + name);
        if (accountController.isUsernameExistsExceptId(account.getId(), username)){
            JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại.");
            return;
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            return;
        }
        if (!phone.matches("^[0-9]{9,11}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            return;
        }
        // Kiểm tra nếu user có nhập mật khẩu mới
        String finalPass;
        if (!newPass.isEmpty() || !reNewPass.isEmpty()) {
            if (!newPass.equals(reNewPass)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu mới không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
             if (newPass.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 ký tự trở lên.");
            return;
        }
            finalPass = newPass;
        } else {
            finalPass = currentPass;
        }
        // Tạo đối tượng account mới
        Account updated = new Account();
        updated.setId(account.getId());
        updated.setUsername(username);
        updated.setPassword(finalPass);
        updated.setRole(account.getRole()); // giữ nguyên role
        updated.setName(name);
        updated.setEmail(email);
        updated.setPhone(phone);
        updated.setSex(sex);
        // Lưu vào DB
        if (controller.saveCustomer(updated)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
            this.dispose();
            customer.setAccount(updated);  // cập nhật lại đối tượng
            customer.getInfo();            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbGender = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lbPassAgain = new javax.swing.JLabel();
        renewpass = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnRegister1 = new javax.swing.JButton();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        lbPassAgain1 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(38, 93, 132));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(73, 224, 232), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(450, 550));
        jPanel2.setPreferredSize(new java.awt.Dimension(490, 590));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Thông tin cá nhân");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(100, 110, 350, 41);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-user.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(160, 10, 150, 120);

        lbUsername.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbUsername.setText("Tên đăng nhập:");
        jPanel2.add(lbUsername);
        lbUsername.setBounds(60, 171, 130, 30);

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername);
        txtUsername.setBounds(220, 170, 210, 30);

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbEmail.setText("Email:");
        jPanel2.add(lbEmail);
        lbEmail.setBounds(60, 210, 130, 30);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail);
        txtEmail.setBounds(220, 210, 210, 30);

        lbPhone.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbPhone.setText("Số điện thoại:");
        jPanel2.add(lbPhone);
        lbPhone.setBounds(60, 250, 130, 30);

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        jPanel2.add(txtPhone);
        txtPhone.setBounds(220, 250, 210, 30);

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbName.setText("Họ tên: ");
        jPanel2.add(lbName);
        lbName.setBounds(60, 290, 130, 30);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName);
        txtName.setBounds(220, 290, 210, 30);

        lbGender.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbGender.setText("Giới tính:");
        jPanel2.add(lbGender);
        lbGender.setBounds(60, 330, 130, 30);

        lbPass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbPass.setText("Mật khẩu:");
        jPanel2.add(lbPass);
        lbPass.setBounds(60, 370, 130, 30);

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel2.add(txtPass);
        txtPass.setBounds(220, 370, 210, 30);

        lbPassAgain.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbPassAgain.setText("Nhập lại mật khẩu:");
        jPanel2.add(lbPassAgain);
        lbPassAgain.setBounds(60, 450, 150, 30);

        renewpass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        renewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renewpassActionPerformed(evt);
            }
        });
        jPanel2.add(renewpass);
        renewpass.setBounds(220, 450, 210, 30);

        btnRegister.setBackground(new java.awt.Color(255, 51, 51));
        btnRegister.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Lưu");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegister);
        btnRegister.setBounds(270, 520, 120, 32);

        btnRegister1.setBackground(new java.awt.Color(255, 51, 51));
        btnRegister1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnRegister1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister1.setText("Huỷ");
        btnRegister1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegister1MouseClicked(evt);
            }
        });
        btnRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegister1);
        btnRegister1.setBounds(80, 520, 120, 32);

        nam.setText("Nam");
        jPanel2.add(nam);
        nam.setBounds(220, 340, 90, 21);

        nu.setText("Nữ");
        jPanel2.add(nu);
        nu.setBounds(320, 340, 90, 21);

        lbPassAgain1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbPassAgain1.setText("Mật khẩu mới:");
        jPanel2.add(lbPassAgain1);
        lbPassAgain1.setBounds(60, 410, 140, 30);

        newpass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        jPanel2.add(newpass);
        newpass.setBounds(220, 410, 210, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 480, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void renewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renewpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renewpassActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked

        saveCustomer();
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnRegister1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister1MouseClicked

        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnRegister1MouseClicked

    private void btnRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegister1ActionPerformed

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegister1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbPassAgain;
    private javax.swing.JLabel lbPassAgain1;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JRadioButton nam;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JRadioButton nu;
    private javax.swing.JPasswordField renewpass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
