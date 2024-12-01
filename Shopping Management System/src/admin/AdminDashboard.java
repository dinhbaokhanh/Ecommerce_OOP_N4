/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import dao.TransactionDTO;
import dao.UserBalanceDAO;
import dao.UserDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import user.Login;

/**
 *
 * @author admin
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    private Login login;

    private List<UserDAO> userList;
    private static final String FILE_NAME = "USER.DAT";

    private List<SupplierDAO> supplierList;
    private static final String FILE_NAME_SUPPLIER = "SUPPLIER.DAT";

    private List<CategoryDAO> categoryList;
    private static final String FILE_NAME_CATEGORY = "CATEGORY.DAT";

    private List<ProductDAO> productList;
    private static final String FILE_NAME_PRODUCT = "PRODUCT.DAT";

    private List<UserBalanceDAO> userBalanceList;
    private static final String FILE_NAME_USERBALANCE = "USERBALANCE.DAT";

    private List<TransactionDTO> transactionList;
    private static final String FILE_NAME_TRANSACTION = "TRANSACTION.DAT";

    public AdminDashboard() {
        initComponents();
        init();
        setLocationRelativeTo(null);
    }

    public AdminDashboard(Login login) {
        this();
        this.login = login;
        LoadDataUser();
        LoadDataSupplier();
        LoadDataCategory();
        LoadDataTransaction();
        LoadDataUserBalance();
        LoadDataProduct();
        setTxtTotalCategories();
        setTxtTotalProducts();
        setTxtTotalUsers();
        setTxtTotalSuppliers();
        setTxtTotalSales();
    }

    private void init() {
        lbAdminEmail.setText("admin@gmail.com");
    }

    private void LoadDataUser() {
        File file = new File(FILE_NAME);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME); ObjectInputStream ois = new ObjectInputStream(fis)) {
                userList = (List<UserDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            userList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
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

    private void LoadDataCategory() {
        File file = new File(FILE_NAME_CATEGORY);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_CATEGORY); ObjectInputStream ois = new ObjectInputStream(fis)) {
                categoryList = (List<CategoryDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            categoryList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void LoadDataTransaction() {
        File file = new File(FILE_NAME_TRANSACTION);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_TRANSACTION); ObjectInputStream ois = new ObjectInputStream(fis)) {
                transactionList = (List<TransactionDTO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            transactionList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
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

    public void setTxtTotalCategories() {
        txtTotalCategories.setText(String.valueOf(categoryList.size()));
    }

    public void setTxtTotalProducts() {
        txtTotalProducts.setText(String.valueOf(productList.size()));
    }

    public void setTxtTotalUsers() {
        txtTotalUsers.setText(String.valueOf(userList.size()));
    }

    public void setTxtTotalSuppliers() {
        txtTotalSuppliers.setText(String.valueOf(supplierList.size()));
    }

    public void setTxtTotalSales() {
        Double tmpTotal = (double) 0;
        for (TransactionDTO transaction : transactionList) {
            if (transaction.getStatus().equals("Delivered")) {
                tmpTotal += transaction.getTotalPrice();
            }
        }
        txtTotalSales.setText(String.valueOf(tmpTotal));
    }

    public void setTotalCategoriesNew() {
        LoadDataCategory();
        setTxtTotalCategories();
    }

    public void setTotalProductsNew() {
        LoadDataProduct();
        setTxtTotalProducts();
    }

    public void setTotalUsersNew() {
        LoadDataUser();
        setTxtTotalUsers();
    }

    public void setTotalSuppliersNew() {
        LoadDataSupplier();
        setTxtTotalSuppliers();
    }

    public void setTotalSalesNew() {
        LoadDataTransaction();
        setTxtTotalSales();
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
        jLabel2 = new javax.swing.JLabel();
        lbAdminEmail = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbManageCategories = new javax.swing.JLabel();
        lbManageProducts = new javax.swing.JLabel();
        lbManageUsers = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbManageSupplier = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbTransaction = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbTotalCategories = new javax.swing.JLabel();
        lbTotalProducts = new javax.swing.JLabel();
        lbTotalUsers = new javax.swing.JLabel();
        lbTotalSuppliers = new javax.swing.JLabel();
        lbTotalSales = new javax.swing.JLabel();
        txtTotalCategories = new javax.swing.JTextField();
        txtTotalProducts = new javax.swing.JTextField();
        txtTotalUsers = new javax.swing.JTextField();
        txtTotalSuppliers = new javax.swing.JTextField();
        txtTotalSales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 107, 189));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping.png"))); // NOI18N
        jLabel1.setText("ONLINE SHOPPING");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabel2.setText("Logout");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        lbAdminEmail.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbAdminEmail.setForeground(new java.awt.Color(255, 255, 255));
        lbAdminEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        lbAdminEmail.setText("admin@gmail.com");

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
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(lbAdminEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lbAdminEmail))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 107, 189));
        jPanel2.setForeground(new java.awt.Color(0, 107, 189));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboard.png"))); // NOI18N
        jLabel4.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        lbManageCategories.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbManageCategories.setForeground(new java.awt.Color(255, 255, 255));
        lbManageCategories.setText("Manage Categories");
        lbManageCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageCategoriesMouseClicked(evt);
            }
        });

        lbManageProducts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbManageProducts.setForeground(new java.awt.Color(255, 255, 255));
        lbManageProducts.setText("Manage Products");
        lbManageProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageProductsMouseClicked(evt);
            }
        });

        lbManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbManageUsers.setForeground(new java.awt.Color(255, 255, 255));
        lbManageUsers.setText("Manage Users");
        lbManageUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageUsersMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Add Supplier");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        lbManageSupplier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbManageSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbManageSupplier.setText("Manage Suppliers");
        lbManageSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageSupplierMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Select Supplier");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        lbTransaction.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTransaction.setForeground(new java.awt.Color(255, 255, 255));
        lbTransaction.setText("Transaction");
        lbTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTransactionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTransaction)
                    .addComponent(lbManageProducts)
                    .addComponent(lbManageCategories)
                    .addComponent(lbManageUsers)
                    .addComponent(jLabel15)
                    .addComponent(lbManageSupplier)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbManageCategories)
                .addGap(18, 18, 18)
                .addComponent(lbManageProducts)
                .addGap(18, 18, 18)
                .addComponent(lbManageUsers)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(lbManageSupplier)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(lbTransaction)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 107, 189));

        jLabel8.setText("Statistics");

        lbTotalCategories.setText("Total Categories:");

        lbTotalProducts.setText("Total Products:");

        lbTotalUsers.setText("Total Users:");

        lbTotalSuppliers.setText("Total Suppliers:");

        lbTotalSales.setText("Total Sales:");

        txtTotalUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalCategories)
                    .addComponent(lbTotalProducts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtTotalProducts))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalSuppliers)
                    .addComponent(lbTotalUsers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalSuppliers)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTotalUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(lbTotalSales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalCategories)
                    .addComponent(lbTotalUsers)
                    .addComponent(txtTotalCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalSales)
                    .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalProducts)
                    .addComponent(lbTotalSuppliers)
                    .addComponent(txtTotalProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout now?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbManageUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageUsersMouseClicked
        // TODO add your handling code here:
        ManageUsers manageUsers = new ManageUsers(login, this);
        manageUsers.setVisible(true);
    }//GEN-LAST:event_lbManageUsersMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        AddSupplier addSupplier = new AddSupplier(login, this);
        addSupplier.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void lbManageSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageSupplierMouseClicked
        // TODO add your handling code here:
        ManageSuppliers manageSuppliers = new ManageSuppliers(login, this);
        manageSuppliers.setVisible(true);
    }//GEN-LAST:event_lbManageSupplierMouseClicked

    private void lbManageCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageCategoriesMouseClicked
        // TODO add your handling code here:
        ManageCategory manageCategory = new ManageCategory(login, this);
        manageCategory.setVisible(true);
    }//GEN-LAST:event_lbManageCategoriesMouseClicked

    private void lbManageProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageProductsMouseClicked
        // TODO add your handling code here:
        ManageProduct manageProduct = new ManageProduct(login, this);
        manageProduct.setVisible(true);
    }//GEN-LAST:event_lbManageProductsMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        SelectSupplier selectSupplier = new SelectSupplier(login, this);
        selectSupplier.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void lbTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseClicked
        // TODO add your handling code here:
        Transaction transaction = new Transaction(login, this);
        transaction.setVisible(true);
    }//GEN-LAST:event_lbTransactionMouseClicked

    private void txtTotalUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalUsersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        login.setVisible(true);
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbAdminEmail;
    private javax.swing.JLabel lbManageCategories;
    private javax.swing.JLabel lbManageProducts;
    private javax.swing.JLabel lbManageSupplier;
    private javax.swing.JLabel lbManageUsers;
    private javax.swing.JLabel lbTotalCategories;
    private javax.swing.JLabel lbTotalProducts;
    private javax.swing.JLabel lbTotalSales;
    private javax.swing.JLabel lbTotalSuppliers;
    private javax.swing.JLabel lbTotalUsers;
    private javax.swing.JLabel lbTransaction;
    private javax.swing.JTextField txtTotalCategories;
    private javax.swing.JTextField txtTotalProducts;
    private javax.swing.JTextField txtTotalSales;
    private javax.swing.JTextField txtTotalSuppliers;
    private javax.swing.JTextField txtTotalUsers;
    // End of variables declaration//GEN-END:variables
}
