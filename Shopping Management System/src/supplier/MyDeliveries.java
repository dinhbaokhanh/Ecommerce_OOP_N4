/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supplier;

import dao.SupplierDAO;
import dao.TransactionDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import user.Login;

/**
 *
 * @author admin
 */
public class MyDeliveries extends javax.swing.JFrame {

    /**
     * Creates new form MyDelivery
     */
    private Login login;
    private SupplierDashboard supplierDashboard;
    private SupplierDAO supplier;
    private TransactionDTO transactionDTO;

    private List<TransactionDTO> transactionListMain = new ArrayList<>();
    private static final String FILE_NAME_TRANSACTION = "TRANSACTION.DAT";

    private DefaultTableModel transactionModel;

    public MyDeliveries() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDataTransaction();
        transactionModel = (DefaultTableModel) tblTransaction.getModel();
    }

    public MyDeliveries(Login login, SupplierDashboard supplierDashboard, SupplierDAO supplier) {
        this();
        this.login = login;
        this.supplierDashboard = supplierDashboard;
        this.supplier = supplier;
        addTransactionToTable();
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
            if (transaction.getSupplierName().equals(supplier.getSupplierName())) {
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
        tblTransaction = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 107, 189));

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTransaction);

        txtSearchQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchQueryActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnSearch.setText("Search By Product Name:");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(649, 649, 649)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void searchByName(String searchQuery) {
        transactionModel.setRowCount(0);
        for (TransactionDTO transaction : transactionListMain) {
            if (transaction.getProductName().toLowerCase().contains(searchQuery.toLowerCase())
                    && transaction.getSupplierName().equals(supplier.getSupplierName())) {
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MyDeliveries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDeliveries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDeliveries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDeliveries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyDeliveries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtSearchQuery;
    // End of variables declaration//GEN-END:variables
}
