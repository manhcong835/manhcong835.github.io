package view;

import controller.AccountController;
import controller.CustomerController;
import javax.swing.*;
import java.awt.*;
import model.Account;
import model.Movie;

public class userHeaderPanel extends javax.swing.JFrame {

    private userHomePanel home;
    private MovieDetailPanel detail;
    private BookTicketUserPanel book;
    private BillPanel bill;
    private MovieTicketHistoryUser history;
    private CustomerUpdatePanel updateinfo;
    private Account account;
    private String id;
    private CustomerController controller;
    public static userHeaderPanel instance;
//    private CustomerUpdatePanel updateinfo;

    public userHeaderPanel() {
        initComponents();
        instance = this;
        content.setPreferredSize(new Dimension(1200, 700));
        this.setSize(1400, 700);
        setLocationRelativeTo(null);
        initPanels();
        FormEditCustomer form = new FormEditCustomer();
        form.setHome(this);
    }

    public JLabel getNameLabel() {
        return Name;
    }

    public void setNameLabel(JLabel name) {
        this.Name = name;
    }

    public JLabel getLbHello() {
        return Name;
    }

    public void setBook(BookTicketUserPanel book) {
        this.book = book;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (book != null) {
            book.setAccount(account);
        }
        if (history != null) {
            history.setAccount(account);
        }
        id = account.getId();
    }

    private void initPanels() {
        // Tạo CardLayout cho content
        content.setLayout(new CardLayout());
        // Khởi tạo panel con
        home = new userHomePanel(this);
        home.setPreferredSize(new Dimension(1400, 600));

        detail = new MovieDetailPanel();
        detail.setParent(this);
        detail.setPreferredSize(new Dimension(1400, 600));

        bill = new BillPanel();
        bill.setPreferredSize(new Dimension(1400, 600));

        history = new MovieTicketHistoryUser();
        history.setPreferredSize(new Dimension(1400, 600));

        book = new BookTicketUserPanel();
        book.setPreferredSize(new Dimension(1400, 600));

        updateinfo = new CustomerUpdatePanel();
        updateinfo.setPreferredSize(new Dimension(1400, 600));

        content.add(home, "home");
        content.add(detail, "detail");
        content.add(book, "book");
        content.add(bill, "bill");
        content.add(history, "history");
        content.add(updateinfo, "updateinfo");

        content.revalidate();
        content.repaint();
        showPanel("home");
    }

    void reloadName() {
        Account acc = controller.searchAccountById(id);
        Name.setText("Xin chào, " + acc.getName());
    }

    public void showPanel(String name) {
        CardLayout cl = (CardLayout) content.getLayout();
        cl.show(content, name);
    }

    public void showDetail(Movie movie) {
        detail.setMovie(movie); // truyền dữ liệu movie
        CardLayout cl = (CardLayout) content.getLayout();
        cl.show(content, "detail");
    }

    public void showBook(Movie movie) {
        if (book == null) {
            book = new BookTicketUserPanel(); // tạo nếu chưa có
            content.add(book, "book"); // thêm vào content nếu chưa có
        }

        if (account == null) {
            JOptionPane.showMessageDialog(this, "Tài khoản chưa được đăng nhập!");
            return;
        }

        book.setAccount(account);  // nên gọi trước nếu cần hiển thị dữ liệu cá nhân
        book.setMovie(movie);      // rồi mới set phim

        CardLayout cl = (CardLayout) content.getLayout();
        cl.show(content, "book");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setPreferredSize(new java.awt.Dimension(1400, 700));
        content.setLayout(new java.awt.CardLayout());
        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setPreferredSize(new java.awt.Dimension(1400, 100));
        header.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-user.png"))); // NOI18N
        header.add(jLabel1);
        jLabel1.setBounds(10, 0, 150, 107);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-info.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        header.add(jLabel4);
        jLabel4.setBounds(1190, 17, 66, 60);

        Name.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Name.setText("Xin Chào,");
        header.add(Name);
        Name.setBounds(880, 20, 300, 51);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Trang chủ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        header.add(jLabel3);
        jLabel3.setBounds(396, 0, 86, 101);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Lịch sử giao dịch");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        header.add(jLabel5);
        jLabel5.setBounds(521, 0, 150, 101);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Thông tin cá nhân");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        header.add(jLabel6);
        jLabel6.setBounds(703, 0, 155, 101);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        header.add(jLabel7);
        jLabel7.setBounds(1290, 20, 25, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Đăng xuất");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        header.add(jLabel8);
        jLabel8.setBounds(1270, 50, 70, 20);

        getContentPane().add(header, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        showPanel("home");
        book.reload();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (history == null) {
            history = new MovieTicketHistoryUser(); // Khởi tạo nếu chưa có
            history.setPreferredSize(new Dimension(1200, 700)); // Kích thước nếu cần
            content.add(history, "history"); // Thêm vào contentPanel nếu chưa
        }

        if (account != null) {
            history.setAccount(account);
            history.load();  // Load lịch sử sau khi đã set account
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản chưa đăng nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        showPanel("history");
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        if (account != null) {
            updateinfo.setAccount(account);
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản chưa đăng nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        showPanel("updateinfo");
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
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
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
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
    }//GEN-LAST:event_jLabel7MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(userHomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userHomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userHomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userHomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userHeaderPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
