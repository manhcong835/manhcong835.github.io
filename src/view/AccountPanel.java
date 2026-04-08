/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.AccountController;
import dao.AccountDao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Account;

/**
 *
 * @author Acer
 */
public class AccountPanel extends javax.swing.JPanel {

    private AccountController controller;
    private String oldId = null;

    /**
     * Creates new form AccountPanel
     */
    public AccountPanel() {
        initComponents();
        controller = new AccountController();
        setTableData();
        setHoverEffect(btnAddAccount, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(jButton2, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(jButton3, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(btnSaveAccount, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(refesh, new Color(16, 90, 115), new Color(255, 255, 255));
        setHoverEffect(jButton6, new Color(16, 90, 115), new Color(255, 255, 255));
        // Tạo render tùy chỉnh cho tiêu đề bảng
        JTableHeader header = myTable.getTableHeader();
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

    public void setTableData() {
        List<Account> list = controller.getData();
        DefaultTableModel model = new DefaultTableModel();
        myTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Tên người dùng");
        model.addColumn("Mật khẩu");
        model.addColumn("Quyền");

        int max = 0;
        for (Account acc : list) {
            String id = acc.getId(); // Ví dụ: TK001
            if (id.startsWith("TK")) {
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
            ma = "TK00" + next;
        } else if (next < 100) {
            ma = "TK0" + next;
        } else {
            ma = "TK" + next;
        }

        for (Account a : list) {
            Object[] row = {a.getId(), a.getUsername(), a.getPassword(), a.getRole()};
            model.addRow(row);
        }
        idInput.setText(ma);
        idInput.setEditable(false);
        myTable.setComponentPopupMenu(jPopupMenu1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        usernamelb = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        passwordlb = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        refesh = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSaveAccount = new javax.swing.JButton();
        btnAddAccount = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cb4 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        rolelb = new javax.swing.JLabel();
        cb3 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb1 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb7 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        searchInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        deleteItem.setText("Xoá");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteItem);

        editItem.setText("Sửa");
        editItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(editItem);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(153, 204, 255));
        id.setText("ID: ");
        id.setPreferredSize(new java.awt.Dimension(25, 25));

        idInput.setPreferredSize(new java.awt.Dimension(64, 25));

        usernamelb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernamelb.setForeground(new java.awt.Color(153, 204, 255));
        usernamelb.setText("Tên người dùng:");

        usernameInput.setPreferredSize(new java.awt.Dimension(64, 25));
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });

        passwordlb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordlb.setForeground(new java.awt.Color(153, 204, 255));
        passwordlb.setText("Mật khẩu:");

        passwordInput.setMinimumSize(new java.awt.Dimension(64, 25));
        passwordInput.setPreferredSize(new java.awt.Dimension(64, 25));
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        refesh.setBackground(new java.awt.Color(153, 204, 255));
        refesh.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        refesh.setForeground(new java.awt.Color(255, 255, 255));
        refesh.setText("Làm mới");
        refesh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refeshActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sửa");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSaveAccount.setBackground(new java.awt.Color(153, 204, 255));
        btnSaveAccount.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnSaveAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveAccount.setText("Lưu");
        btnSaveAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSaveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAccountActionPerformed(evt);
            }
        });

        btnAddAccount.setBackground(new java.awt.Color(153, 204, 255));
        btnAddAccount.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnAddAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAccount.setText("Thêm");
        btnAddAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Xoá");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        cb4.setBackground(new java.awt.Color(255, 255, 255));
        cb4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb4.setText("Quản lý suất chiếu");
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });

        cb5.setBackground(new java.awt.Color(255, 255, 255));
        cb5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb5.setText("Quản lý vé");
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });

        rolelb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rolelb.setForeground(new java.awt.Color(153, 204, 255));
        rolelb.setText("Quyền:");

        cb3.setBackground(new java.awt.Color(255, 255, 255));
        cb3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb3.setText("Quản lý tài khoản");

        cb2.setBackground(new java.awt.Color(255, 255, 255));
        cb2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb2.setText("Quản lý phim");
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });

        cb1.setBackground(new java.awt.Color(255, 255, 255));
        cb1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb1.setText("Quản lý tất cả");
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });

        cb6.setBackground(new java.awt.Color(255, 255, 255));
        cb6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb6.setText("Quản lý hoá đơn");

        cb7.setBackground(new java.awt.Color(255, 255, 255));
        cb7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cb7.setText("Quản lý khách hàng");
        cb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rolelb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb2)
                    .addComponent(cb1)
                    .addComponent(cb3)
                    .addComponent(cb4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb5)
                    .addComponent(cb6)
                    .addComponent(cb7))
                .addGap(9, 9, 9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rolelb)
                    .addComponent(cb1)
                    .addComponent(cb5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb2)
                    .addComponent(cb6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb3)
                    .addComponent(cb7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernamelb, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordlb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(89, 89, 89)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamelb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordlb)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        searchInput.setMinimumSize(new java.awt.Dimension(65, 22));
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 132, 146));

        jButton6.setBackground(new java.awt.Color(153, 204, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("🔍 Tìm kiếm");
        jButton6.setAutoscrolls(true);
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setPreferredSize(new java.awt.Dimension(94, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 204, 255));
        jLabel6.setText("Bảng tài khoản ");

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        myTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(myTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý tài khoản");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setAutoscrolls(true);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameInputActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = myTable.getSelectedRow();
        if (selectedRow != -1) {
            oldId = myTable.getValueAt(selectedRow, 0).toString();
            String username = myTable.getValueAt(selectedRow, 1).toString();
            String password = myTable.getValueAt(selectedRow, 2).toString();
            String roleString = myTable.getValueAt(selectedRow, 3).toString();
            List<String> roles = Arrays.asList(roleString.split(","));
            // Hiển thị lên các input
            idInput.setText(oldId);
            usernameInput.setText(username);
            passwordInput.setText(password);
            JCheckBox[] checkboxes = {cb1, cb2, cb3, cb4, cb5, cb6, cb7};
            for (JCheckBox cb : checkboxes) {
                if (roles.contains(cb.getText())) {
                    cb.setSelected(true);
                } else {
                    cb.setSelected(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần sửa!");
            return;
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = myTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần xóa!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        // Lấy ID String từ cột đầu tiên
        String idToDelete = (String) myTable.getValueAt(selectedRow, 0);
        boolean success = controller.deleteAccountById(idToDelete);
        if (success) {
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            refeshActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSaveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAccountActionPerformed
        int selectedRow = myTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần sửa!");
            return;
        }
        String username = usernameInput.getText().trim();
        String password = passwordInput.getText().trim();
        String role = "";
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 ký tự trở lên.");
            return;
        }
        String id = idInput.getText().trim();
//        if (!id.equalsIgnoreCase(oldId)) {
//            if (controller.checkIdandUsername(id, username)) {
//                JOptionPane.showMessageDialog(AccountPanel.this,
//                        "id hoặc username đã tồn tại!.");
//                return;
//            }
//        }
        if (controller.isUsernameExistsExceptId(id, username)) {
                JOptionPane.showMessageDialog(AccountPanel.this,
                        "id hoặc username đã tồn tại!.");
                return;
            }
        JCheckBox[] checkboxes = {cb1, cb2, cb3, cb4, cb5, cb6, cb7};
        List<String> selected = new ArrayList<>();
        for (JCheckBox cb : checkboxes) {
            if (cb.isSelected()) {
                selected.add(cb.getText());
            }
        }
        String dataToSave = String.join(",", selected);
        role += dataToSave;
        boolean newId = controller.updateAccount(id, username, password, role);
        if (newId) {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "cập nhật khoản thành công!");
            setTableData();
        } else {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "Cập nhật không thành công!.");
        }
        refeshActionPerformed(null);
    }//GEN-LAST:event_btnSaveAccountActionPerformed

    private void refeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refeshActionPerformed
        usernameInput.setText("");
        passwordInput.setText("");
        JCheckBox[] checkboxes = {cb1, cb2, cb3, cb4, cb5, cb6, cb7};
        for (JCheckBox cb : checkboxes) {
            cb.setSelected(false);
        }
        searchInput.setText("");
        setTableData();
    }//GEN-LAST:event_refeshActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String key = searchInput.getText().trim();

        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm kiếm");
            setTableData();
            return;
        }

        List<Account> result = controller.searchAccountById(key);

        if (result != null) {

            // Gọi hàm setTableData để hiển thị lên bảng
            DefaultTableModel model = new DefaultTableModel();
            myTable.setModel(model);
            model.addColumn("ID");
            model.addColumn("Tên người dùng");
            model.addColumn("Mật khẩu");
            model.addColumn("Quyền");
            for (Account a : result) {
                Object[] row = {a.getId(), a.getUsername(), a.getPassword(), a.getRole()};
                model.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy tài khoản");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        String username = usernameInput.getText().trim();
        String password = passwordInput.getText().trim();
        String role = "";
        String id = idInput.getText().trim();
        JCheckBox[] checkboxes = {cb1, cb2, cb3, cb4, cb5, cb6, cb7};
        List<String> selected = new ArrayList<>();
        for (JCheckBox cb : checkboxes) {
            if (cb.isSelected()) {
                selected.add(cb.getText());
            }
        }
        String dataToSave = String.join(",", selected);
        role += dataToSave;
        if (controller.checkIdandUsername(id, username)) {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "id hoặc username đã tồn tại!.");
            return;
        }
        
        if (role.equalsIgnoreCase("") || username.trim().equalsIgnoreCase("") || password.trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "Bạn chưa điền đủ thông tin!.");
            return;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(AccountPanel.this, "Mật khẩu phải từ 6 ký tự trở lên.");
            return;
        }
        boolean newId = controller.addAccount(id, username, password, role);
        if (newId) {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "Thêm tài khoản thành công!");
            setTableData();
        } else {
            JOptionPane.showMessageDialog(AccountPanel.this,
                    "Bạn chưa điền đủ thông tin!.");
        }
        refeshActionPerformed(null);
    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        int selectedRow = myTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

// Lấy ID String từ cột đầu tiên
        String idToDelete = (String) myTable.getValueAt(selectedRow, 0);

        boolean success = controller.deleteAccountById(idToDelete);
        if (success) {
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            refeshActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
        }
    }//GEN-LAST:event_deleteItemActionPerformed

    private void myTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTableMouseClicked

    }//GEN-LAST:event_myTableMouseClicked

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed
        int selectedRow = myTable.getSelectedRow();
        if (selectedRow != -1) {
            oldId = myTable.getValueAt(selectedRow, 0).toString();
            String username = myTable.getValueAt(selectedRow, 1).toString();
            String password = myTable.getValueAt(selectedRow, 2).toString();
            String roleString = myTable.getValueAt(selectedRow, 3).toString();

            List<String> roles = Arrays.asList(roleString.split(","));
            // Hiển thị lên các input
            idInput.setText(oldId);
            usernameInput.setText(username);
            passwordInput.setText(password);
            JCheckBox[] checkboxes = {cb1, cb2, cb3, cb4, cb5, cb6, cb7};
            for (JCheckBox cb : checkboxes) {
                if (roles.contains(cb.getText())) {
                    cb.setSelected(true);
                } else {
                    cb.setSelected(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn dòng cần sửa!");
            return;
        }
    }//GEN-LAST:event_editItemActionPerformed

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb4ActionPerformed

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb5ActionPerformed

    private void cb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnSaveAccount;
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JCheckBox cb4;
    private javax.swing.JCheckBox cb5;
    private javax.swing.JCheckBox cb6;
    private javax.swing.JCheckBox cb7;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idInput;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myTable;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel passwordlb;
    private javax.swing.JButton refesh;
    private javax.swing.JLabel rolelb;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernamelb;
    // End of variables declaration//GEN-END:variables

}
