/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AccountController;
import dao.AccountDao;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Account;
import model.Movie;

/**
 *
 * @author Acer
 */
public class Register extends javax.swing.JFrame {

    //private AccountDao dao = new AccountDao();
    private AccountController controller;

    public Register() {
        initComponents();
        controller = new AccountController();
        jLabel2.setIcon(getScaledIcon("/images/logo-user.png", 300, 200));
    }

    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
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
        txtPassAgain = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        btnRegister1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(450, 550));
        jPanel2.setPreferredSize(new java.awt.Dimension(490, 590));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Đăng ký");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(180, 110, 160, 41);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-user.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 0, 150, 110);

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
        lbPassAgain.setBounds(60, 410, 140, 30);

        txtPassAgain.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPassAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassAgainActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassAgain);
        txtPassAgain.setBounds(220, 410, 210, 30);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(220, 330, 80, 30);

        btnRegister.setBackground(new java.awt.Color(255, 51, 51));
        btnRegister.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Đăng ký");
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
        btnRegister.setBounds(290, 480, 120, 32);

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
        btnRegister1.setBounds(60, 480, 120, 32);

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

    private void txtPassAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassAgainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassAgainActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        if (!validateRegisterForm()) {
            return;
        }

        // Tạo đối tượng Account từ dữ liệu nhập
        String id = autoID();
        String username = txtUsername.getText().trim();
        String password = new String(txtPass.getPassword());
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String name = txtName.getText().trim();
        String sex = jComboBox1.getSelectedItem().toString();
        String role = "user";
        String trangThai = "Đang hoạt động";

        Account acc = new Account(id, username, email, password, role, name, sex, phone, trangThai);

        boolean success = controller.register(acc);

        if (success) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
            this.dispose();

            // Mở form đăng nhập
            new Login().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Đăng ký thất bại. Tài khoản đã tồn tại hoặc lỗi kết nối.");
        }
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnRegister1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister1MouseClicked
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegister1MouseClicked

    private void btnRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegister1ActionPerformed

    private boolean validateRegisterForm() {
        String id=autoID();
        String username = txtUsername.getText().trim();
        String password = new String(txtPass.getPassword());
        String confirmPassword = new String(txtPassAgain.getPassword());
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String name = txtName.getText().trim();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                || email.isEmpty() || phone.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp.");
            return false;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            return false;
        }

        if (!phone.matches("^[0-9]{9,11}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            return false;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 ký tự trở lên.");
            return false;
        }

        return true;
    }

    public String autoID() {
        List<Account> list = controller.getAllUsers();
        int max = 0;
        for (Account m : list) {
            String id = m.getId(); // Ví dụ: KH001
            if (id.startsWith("KH")) {
                try {
                    int num = Integer.parseInt(id.substring(2));
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                    // Bỏ qua
                }
            }
        }

        int next = max + 1;
        if (next < 10) {
            return "KH00" + next;
        } else if (next < 100) {
            return "KH0" + next;
        } else {
            return "KH" + next;
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegister1;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassAgain;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
