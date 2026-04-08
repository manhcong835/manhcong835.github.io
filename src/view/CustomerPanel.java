package view;

import controller.CustomerController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Account;

public class CustomerPanel extends javax.swing.JPanel {

    private CustomerController controller = new CustomerController();

    public CustomerPanel() {
        initComponents();
        reloadTableData();
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
             boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                 table, value, isSelected, hasFocus, row, column);

                lbl.setBackground(Color.decode("#105A73"));  // Màu nền
                lbl.setForeground(Color.decode("#ABFA87"));  // Màu chữ
                lbl.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font
                lbl.setOpaque(true);
                lbl.setHorizontalAlignment(SwingConstants.CENTER);

                return lbl;
            }
        });
        table.setComponentPopupMenu(jPopupMenu1);
    }

    public void reloadTableData() {
        List<Account> list = controller.getAllUsers(); // Lấy danh sách user có role là "user"
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        // Thêm cột
        model.addColumn("ID");
        model.addColumn("Tên người dùng");
        model.addColumn("Email");
        model.addColumn("SĐT");
        model.addColumn("Họ tên");
        model.addColumn("Giới tính");
        model.addColumn("Trạng thái");

        // Đổ dữ liệu ra bảng
        for (Account a : list) {
            Object[] row = {
                a.getId(),
                a.getUsername(),
                a.getEmail(),
                a.getPhone(),
                a.getName(),
                a.getSex(),
                a.getTrangthai()
            };
            model.addRow(row);
        }

        // Set popup menu nếu có
//        myTable.setComponentPopupMenu(jPopupMenu1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        open = new javax.swing.JMenuItem();
        close = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnLockAccount = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        open.setText("Mở tài khoản");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPopupMenu1.add(open);

        close.setText("Xoá tài khoản");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPopupMenu1.add(close);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý khách hàng");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        btnLockAccount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLockAccount.setText("Khoá tài khoản");
        btnLockAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLockAccountMouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Mở tài khoản");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLockAccount)
                .addGap(402, 402, 402))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLockAccount)
                    .addComponent(jButton2))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLockAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLockAccountMouseClicked
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một tài khoản để khóa!");
            return;
        }

        String id = table.getValueAt(selectedRow, 0).toString(); // Cột ID là cột 0

        int confirm = JOptionPane.showConfirmDialog(null,
         "Bạn có chắc chắn muốn khóa tài khoản " + id + "?",
         "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = controller.khoaTaiKhoan(id);
            if (success) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã được khóa!");
                reloadTableData(); // Hoặc setTableData() để cập nhật lại bảng
            } else {
                JOptionPane.showMessageDialog(null, "Khóa tài khoản thất bại.");
            }
        }
    }//GEN-LAST:event_btnLockAccountMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một tài khoản để mở!");
            return;
        }

        String id = table.getValueAt(selectedRow, 0).toString();
        String trangThai = table.getValueAt(selectedRow, 6).toString(); // Cột trạng thái là cột 6

        if ("Đang hoạt động".equalsIgnoreCase(trangThai)) {
            JOptionPane.showMessageDialog(null, "Tài khoản này đã đang hoạt động!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
         "Bạn có chắc muốn mở lại tài khoản " + id + "?",
         "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = controller.moTaiKhoan(id);
            if (success) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã được mở!");
                reloadTableData(); // cập nhật lại bảng
            } else {
                JOptionPane.showMessageDialog(null, "Mở tài khoản thất bại.");
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một tài khoản để mở!");
            return;
        }

        String id = table.getValueAt(selectedRow, 0).toString();
        String trangThai = table.getValueAt(selectedRow, 6).toString(); // Cột trạng thái là cột 6

        if ("Đang hoạt động".equalsIgnoreCase(trangThai)) {
            JOptionPane.showMessageDialog(null, "Tài khoản này đã đang hoạt động!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
         "Bạn có chắc muốn mở lại tài khoản " + id + "?",
         "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = controller.moTaiKhoan(id);
            if (success) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã được mở!");
                reloadTableData(); // cập nhật lại bảng
            } else {
                JOptionPane.showMessageDialog(null, "Mở tài khoản thất bại.");
            }
        }
    }//GEN-LAST:event_openActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một tài khoản để khóa!");
            return;
        }

        String id = table.getValueAt(selectedRow, 0).toString(); // Cột ID là cột 0

        int confirm = JOptionPane.showConfirmDialog(null,
         "Bạn có chắc chắn muốn khóa tài khoản " + id + "?",
         "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = controller.khoaTaiKhoan(id);
            if (success) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã được khóa!");
                reloadTableData(); // Hoặc setTableData() để cập nhật lại bảng
            } else {
                JOptionPane.showMessageDialog(null, "Khóa tài khoản thất bại.");
            }
        }
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLockAccount;
    private javax.swing.JMenuItem close;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem open;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
