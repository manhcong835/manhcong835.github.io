/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.AccountController;
import controller.BillController;
import controller.DetailBillController;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.Bill;
import model.BillDetail;
import model.Showtime;
import model.Ticket;

/**
 *
 * @author Acer
 */
public class BillPanel extends javax.swing.JPanel {

    private BillController billController = new BillController();
    private DetailBillController billDetailController = new DetailBillController();
    private AccountController accountController = new AccountController();
    private List<Bill> billList = new ArrayList<>();
    private List<BillDetail> billDetailList = new ArrayList<>();

    public BillPanel() {
        initComponents();
        jScrollPane2.setVisible(false);
        icon1.setIcon(getScaledIcon("/images/film-budget.png", 75, 75));
        loadTable();
        addTableSelectionListener();
    }

    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    void loadTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        billList = billController.getAllBills();
        for (Bill b : billList) {
            String customerName = billController.getCustomerNameById(b.getAccountId());
            if (customerName == null || customerName.isEmpty()) {
                customerName = "Admin";
            }

            model.addRow(new Object[]{
                b.getBillId(),
                customerName,
                b.getCreatedAt(),
                b.getTotalAmount()
            });
        }
    }

    private void addTableSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) {
                jScrollPane2.setVisible(true);

                String billId = jTable1.getValueAt(selectedRow, 0).toString();
                Bill selectedBill = billController.getBillById(billId); // <-- Truy vấn chính xác bằng ID

                if (selectedBill != null) {
                    lbIDBill.setText("Mã hóa đơn: " + selectedBill.getBillId());
                    lbDate.setText("Ngày lập: " + selectedBill.getCreatedAt());
                    lbTotal.setText("Tổng tiền: " + selectedBill.getTotalAmount() + " VNĐ");
                    lbNote.setText("Ghi chú: " + selectedBill.getNote());

                    // Lấy tên khách hàng
                    String customerName = billController.getCustomerNameById(selectedBill.getAccountId());
                    lbUsername.setText("Tài khoản: " + customerName);

                    // Hiển thị chi tiết vé
                    StringBuilder ticketInfo = new StringBuilder();
                    DetailBillController detailController = new DetailBillController();
                    List<BillDetail> details = detailController.getBillDetailsByBillId(selectedBill.getBillId());

                    for (BillDetail detail : details) {
                        Ticket ticket = detailController.getTicketById(detail.getTicketId());
                        Showtime showtime = detailController.getShowtimeById(ticket.getShowtimeId());
                        String seatName = detailController.getSeatNameById(ticket.getSeatId());

                        ticketInfo.append("Phim: ").append(showtime.getMovieName())
                                .append(" | ").append(showtime.getRoomName())
                                .append(" | Ghế: ").append(seatName)
                                .append(" | Giá: ").append(showtime.getTicketPrice()).append(" VNĐ\n");
                    }

                    if (ticketInfo.length() == 0) {
                        lbTicket.setText("Vé: Không có vé nào");
                    } else {
                        lbTicket.setText("<html>Vé:<br>" + ticketInfo.toString().replaceAll("\n", "<br>") + "</html>");
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbIDBill = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbNote = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        lbTicket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDeleteBill = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 200));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quản lý hóa đơn");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 20, 304, 48);

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/film-budget.png"))); // NOI18N
        icon1.setPreferredSize(new java.awt.Dimension(75, 75));
        jPanel1.add(icon1);
        icon1.setBounds(380, 10, 80, 68);

        txtInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtInput);
        txtInput.setBounds(380, 120, 330, 30);

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm kiếm");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(740, 120, 120, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 204, 255));
        jLabel3.setText("Nhập mã hóa đơn/ tên khách hàng:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(380, 90, 350, 20);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 500));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(171, 250, 135)));
        jPanel3.setForeground(new java.awt.Color(16, 90, 115));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 350));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Chi tiết hóa đơn");

        lbIDBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbIDBill.setForeground(new java.awt.Color(171, 250, 135));

        lbUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(171, 250, 135));

        lbDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDate.setForeground(new java.awt.Color(171, 250, 135));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(171, 250, 135));

        lbNote.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNote.setForeground(new java.awt.Color(171, 250, 135));

        jScrollPane2.setBackground(new java.awt.Color(16, 90, 115));
        jScrollPane2.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        lbTicket.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTicket.setForeground(new java.awt.Color(171, 250, 135));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTicket)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIDBill, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(lbNote, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbIDBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 350));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "Ngày lập", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnDeleteBill.setBackground(new java.awt.Color(153, 204, 255));
        btnDeleteBill.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnDeleteBill.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBill.setText("Hủy đơn");
        btnDeleteBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteBillMouseClicked(evt);
            }
        });
        btnDeleteBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDeleteBill)
                        .addGap(278, 278, 278))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteBill)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String keyword = txtInput.getText().trim();

        List<Bill> list = billController.searchBills(keyword);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

        for (Bill bill : list) {
            Object[] row = new Object[]{
                bill.getBillId(),
                bill.getAccountId(), // hoặc bill.getCustomerName() nếu bạn đặt tên rõ ràng
                bill.getCreatedAt(),
                bill.getTotalAmount()
            };
            model.addRow(row);
        }

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn phù hợp.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBillActionPerformed

    private void btnDeleteBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBillMouseClicked
        try {
            String fullText = lbIDBill.getText().trim(); // "Mã hóa đơn: HD001"
            String billId = fullText.contains(":") ? fullText.split(":")[1].trim() : "";
            // Kiểm tra nếu không có hóa đơn nào được chọn
            if (billId.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng chọn hóa đơn cần hủy!",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (billController.hasShowtimeStarted(billId)) {
                JOptionPane.showMessageDialog(this,
                        "Không thể hủy hóa đơn vì có suất chiếu đã diễn ra.",
                        "Không thể hủy",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Hỏi xác nhận người dùng
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn hủy hóa đơn có mã: " + billId + "?",
                    "Xác nhận hủy hóa đơn",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = billController.deleteBill(billId);
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công!");
                    lbIDBill.setText("");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Hủy hóa đơn thất bại.");
                }
            }

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            if (errorMessage != null && errorMessage.contains("REFERENCE constraint")) {
                JOptionPane.showMessageDialog(this,
                        "Không thể hủy hóa đơn này vì vẫn còn vé hoặc suất chiếu liên quan.",
                        "Lỗi ràng buộc dữ liệu",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Đã xảy ra lỗi: " + errorMessage,
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteBillMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JLabel icon1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbIDBill;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbTicket;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
