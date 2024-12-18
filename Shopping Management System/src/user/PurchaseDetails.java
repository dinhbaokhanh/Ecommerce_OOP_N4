/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.TransactionDTO;
import dao.UserBalanceDAO;
import dao.UserDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class PurchaseDetails extends javax.swing.JFrame {

    private Login login;
    private UserDashboard userDashboard;
    private UserDAO user;
    private TransactionDTO transaction;
    private ProductDAO product;

    private List<ProductDAO> productList;
    private static final String FILE_NAME_PRODUCT = "PRODUCT.DAT";

    private List<TransactionDTO> transactionListMain = new ArrayList<>();
    private static final String FILE_NAME_TRANSACTION = "TRANSACTION.DAT";

    private List<UserBalanceDAO> userBalanceList;
    private static final String FILE_NAME_USERBALANCE = "USERBALANCE.DAT";

    private DefaultTableModel transactionModel;

    /**
     * Creates new form PurchaseDetails
     */
    public PurchaseDetails() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDataProduct();
        LoadDataTransaction();
        transactionModel = (DefaultTableModel) tblTransaction.getModel();
    }

    public PurchaseDetails(Login login, UserDAO user, UserDashboard userDashboard) {
        this();
        this.login = login;
        this.user = user;
        this.userDashboard = userDashboard;
        addTransactionToTable();
        txtCurrentDate.setText(getCurrentDate());
        LoadDataUserBalance();
    }

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    private void LoadDataProduct() {
        File file = new File(FILE_NAME_PRODUCT);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_PRODUCT); ObjectInputStream ois = new ObjectInputStream(fis)) {
                productList = (List<ProductDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            productList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void LoadDataTransaction() {
        File file = new File(FILE_NAME_TRANSACTION);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_TRANSACTION); ObjectInputStream ois = new ObjectInputStream(fis)) {
                transactionListMain = (List<TransactionDTO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            transactionListMain = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void LoadDataUserBalance() {
        File file = new File(FILE_NAME_USERBALANCE);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_USERBALANCE); ObjectInputStream ois = new ObjectInputStream(fis)) {
                userBalanceList = (List<UserBalanceDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            userBalanceList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    public void addTransactionToTable() {
        for (TransactionDTO transaction : transactionListMain) {
            if (transaction.getUserID().equals(user.getUserID())) {
                Object[] newRow = {
                    transaction.getPurchaseID(),
                    transaction.getProductID(),
                    transaction.getProductName(),
                    transaction.getProductPurchaseQuantity(),
                    transaction.getProductPrice(),
                    transaction.getTotalPrice(),
                    transaction.getPurchaseDate(),
                    transaction.getReceivedDate(),
                    transaction.getSupplierName(),
                    transaction.getStatus()
                };
                transactionModel.addRow(newRow);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPurchaseID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtReceivedDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCurrentDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 107, 189));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Received Date");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Current Date");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transaction_light.png"))); // NOI18N
        jButton1.setText("Refund");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total", "Purchase Date", "Received Date", "Supplier Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransactionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaction);

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnSearch.setText("Search by Product Name");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(lbStatus))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                            .addComponent(jButton1))
                        .addGap(68, 68, 68)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchByName(String searchQuery) {
        transactionModel.setRowCount(0);

        for (TransactionDTO transaction : transactionListMain) {
            if (transaction.getProductName().toLowerCase().contains(searchQuery.toLowerCase())) {
                transactionModel.addRow(new Object[]{
                    transaction.getPurchaseID(),
                    transaction.getProductID(),
                    transaction.getProductName(),
                    transaction.getProductPurchaseQuantity(),
                    transaction.getProductPrice(),
                    transaction.getTotalPrice(),
                    transaction.getPurchaseDate(),
                    transaction.getReceivedDate(),
                    transaction.getSupplierName(),
                    transaction.getStatus()
                });
            }
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String searchQuery = txtSearchQuery.getText().trim();

        // Gọi hàm tìm kiếm nếu người dùng nhập tên
        if (!searchQuery.isEmpty()) {
            searchByName(searchQuery);
        } else {
            transactionModel.setRowCount(0);
            addTransactionToTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransactionMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblTransaction.getSelectedRow();

        // Đảm bảo rằng dòng được chọn hợp lệ
        if (rowIndex != -1) {
            // Lấy mô hình dữ liệu của bảng
            DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();

            // Gán giá trị từ các cột của dòng được chọn vào các JTextField
            txtPurchaseID.setText(model.getValueAt(rowIndex, 0).toString());
            txtReceivedDate.setText(model.getValueAt(rowIndex, 7).toString());
            txtStatus.setText(model.getValueAt(rowIndex, 9).toString());
        }
    }//GEN-LAST:event_tblTransactionMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean isRefundInformationValid() {
        if (txtPurchaseID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Transaction ID is required", "Warning", 2);
            return false;
        }
        if (tblTransaction.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Select a Transaction first", "Warning", 2);
            return false;
        }
        return true;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (tblTransaction.getSelectedRow() == -1 || txtPurchaseID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Choose a Transaction First!", "Warning", 2);
        } else if (!txtStatus.getText().toString().equals("Delivered")) {
            JOptionPane.showMessageDialog(rootPane, "The item cannot be refunded!", "Warning", 2);
        } else {
            int confirm = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure to refund this product?", "Refund Product", JOptionPane.OK_CANCEL_OPTION, 0);
            if (confirm == JOptionPane.OK_OPTION) {
                String currentTransactionID = txtPurchaseID.getText().toString();
                TransactionDTO tmpTransaction;
                for (int i = 0; i < transactionListMain.size(); i++) {
                    TransactionDTO tmpTransactionInMainList = transactionListMain.get(i);
                    tmpTransaction = tmpTransactionInMainList;
                    if (tmpTransactionInMainList.getPurchaseID().equals(currentTransactionID)) {
                        tmpTransactionInMainList.setStatus("Refunded");
                        login.setTransactionListDataReplace(transactionListMain);
                        String addBackProductQuantityID = tmpTransaction.getProductID();
                        for (int j = 0; j < productList.size(); j++) {
                            ProductDAO tmpProductDaoToAddQuantity = productList.get(j);
                            if (tmpProductDaoToAddQuantity.getProductID().equals(addBackProductQuantityID)) {
                                tmpProductDaoToAddQuantity.setQuantity(tmpProductDaoToAddQuantity.getQuantity()
                                        + tmpTransaction.getProductPurchaseQuantity());
                                login.setProductListData(productList);
                                break;
                            }

                        }
                        String tmpUserID = tmpTransaction.getUserID();
                        for (int z = 0; z < userBalanceList.size(); z++) {
                            UserBalanceDAO tmpUserBalanceDAO = userBalanceList.get(z);
                            if (tmpUserBalanceDAO.getUserID().equals(tmpUserID)) {
                                tmpUserBalanceDAO.setBalance(tmpUserBalanceDAO.getBalance() + tmpTransaction.getTotalPrice());
                                login.setUserBalanceListDataReplace(userBalanceList);
                                userDashboard.setBackUserBalanceAfterChange();
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(rootPane, "Refund thanh cong!");
                        txtPurchaseID.setText("");
                        txtReceivedDate.setText("");
                        txtStatus.setText("");
                        tblTransaction.clearSelection();
                        transactionModel.setRowCount(0);
                        addTransactionToTable();
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ok");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtPurchaseID.setText("");
        txtReceivedDate.setText("");
        txtStatus.setText("");
        tblTransaction.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtCurrentDate;
    private javax.swing.JTextField txtPurchaseID;
    private javax.swing.JTextField txtReceivedDate;
    private javax.swing.JTextField txtSearchQuery;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
