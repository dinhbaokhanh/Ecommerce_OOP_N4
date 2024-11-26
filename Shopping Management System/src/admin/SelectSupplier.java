/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import dao.TransactionDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user.Login;

/**
 *
 * @author admin
 */
public class SelectSupplier extends javax.swing.JFrame {

    /**
     * Creates new form SelectSupplier
     */
    private Login login;
    private AdminDashboard adminDashboard;

    private List<SupplierDAO> supplierList;
    private static final String FILE_NAME_SUPPLIER = "SUPPLIER.DAT";

    private List<TransactionDTO> transactionListMain = new ArrayList<>();
    private static final String FILE_NAME_TRANSACTION = "TRANSACTION.DAT";

    private DefaultTableModel transactionModel;
    private TransactionDTO transactionDTO;

    public SelectSupplier() {
        initComponents();
        setLocationRelativeTo(null);
        transactionModel = (DefaultTableModel) tblSelectSupplier.getModel();
        LoadDataSupplier();
        LoadDataTransaction();
    }

    public SelectSupplier(Login login, AdminDashboard adminDashboard) {
        this();
        this.login = login;
        this.adminDashboard = adminDashboard;
        loadToComboBoxSupplier();
        addTransactionToTable();
    }

    private void LoadDataSupplier() {
        File file = new File(FILE_NAME_SUPPLIER);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_SUPPLIER); ObjectInputStream ois = new ObjectInputStream(fis)) {
                supplierList = (List<SupplierDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            supplierList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
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

    public void addTransactionToTable() {
        for (TransactionDTO transaction : transactionListMain) {
            if (transaction.getSupplierName().equals("tbd")) {
                Object[] newRow = {
                    transaction.getPurchaseID(),
                    transaction.getUserID(),
                    transaction.getUserName(),
                    transaction.getUserPhone(),
                    transaction.getProductID(),
                    transaction.getProductName(),
                    transaction.getProductPurchaseQuantity(),
                    transaction.getProductPrice(),
                    transaction.getTotalPrice(),
                    transaction.getPurchaseDate(),
                    transaction.getAddress(),
                    transaction.getReceivedDate(),
                    transaction.getSupplierName(),
                    transaction.getStatus()
                };
                transactionModel.addRow(newRow);
            }
        }
    }

    private void loadToComboBoxSupplier() {
        for (SupplierDAO supplier : supplierList) {
            String tmp = "";
            tmp += supplier.getSupplierName();
            cbSelectSupplier.addItem(tmp);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelectSupplier = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        cbSelectSupplier = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPurchaseID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        tblSelectSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "User ID", "User Name", "User Phone", "Product ID", "Product Name", "Quantity ", "Price", "Total", "Purchase Date", "Address", "Received Date", "Supplier Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelectSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelectSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelectSupplier);

        txtSearchQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchQueryActionPerformed(evt);
            }
        });

        cbSelectSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectSupplierActionPerformed(evt);
            }
        });

        jLabel2.setText("Supplier");

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Purchase ID");

        txtPurchaseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPurchaseIDActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbSelectSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSelectSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtSearchQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchQueryActionPerformed

    private void cbSelectSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSelectSupplierActionPerformed

    public boolean isSignUpInformationCreateValid() {
        if (cbSelectSupplier.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Supplier is needed", "Warning", 2);
            return false;
        }
        return true;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (isSignUpInformationCreateValid()) {
            String transactionID = txtPurchaseID.getText().toString();
            String supplierName = cbSelectSupplier.getSelectedItem().toString();

            for(int i = 0; i < transactionListMain.size(); i++){
                TransactionDTO transaction = transactionListMain.get(i);
                if (transaction.getPurchaseID().equals(transactionID)) {
                    transaction.setSupplierName(supplierName);
                    transaction.setStatus("On the way");
                    JOptionPane.showMessageDialog(rootPane, "Them supplier thanh cong!");
                    txtPurchaseID.setText("");
                    cbSelectSupplier.setSelectedIndex(-1);
                    tblSelectSupplier.clearSelection();
                    login.setTransactionListDataReplace(transactionListMain);
                    transactionModel.setRowCount(0);
                    addTransactionToTable();
                    break;
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblSelectSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelectSupplierMouseClicked
        // TODO add your handling code here:
           // TODO add your handling code here:
        int rowIndex = tblSelectSupplier.getSelectedRow();

    // Đảm bảo rằng dòng được chọn hợp lệ
    if (rowIndex != -1) {
        // Lấy mô hình dữ liệu của bảng
        DefaultTableModel model = (DefaultTableModel) tblSelectSupplier.getModel();
        String purchaseID = model.getValueAt(rowIndex, 0).toString();
        for (TransactionDTO transaction : transactionListMain) {
            if(transaction.getPurchaseID().equals(purchaseID)) {
                this.transactionDTO = transaction;
            }
        }
        txtPurchaseID.setText(purchaseID);
    }
    }//GEN-LAST:event_tblSelectSupplierMouseClicked

    private void txtPurchaseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPurchaseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPurchaseIDActionPerformed

    private void searchByName(String searchQuery) {
        transactionModel.setRowCount(0);
        for (TransactionDTO transaction : transactionListMain) {
            if (transaction.getProductName().toLowerCase().contains(searchQuery.toLowerCase())) {
                transactionModel.addRow(new Object[]{
                    transaction.getPurchaseID(),
                    transaction.getUserID(),
                    transaction.getUserName(),
                    transaction.getUserPhone(),
                    transaction.getProductID(),
                    transaction.getProductName(),
                    transaction.getProductPurchaseQuantity(),
                    transaction.getProductPrice(),
                    transaction.getTotalPrice(),
                    transaction.getPurchaseDate(),
                    transaction.getAddress(),
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
            java.util.logging.Logger.getLogger(SelectSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSelectSupplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSelectSupplier;
    private javax.swing.JTextField txtPurchaseID;
    private javax.swing.JTextField txtSearchQuery;
    // End of variables declaration//GEN-END:variables
}