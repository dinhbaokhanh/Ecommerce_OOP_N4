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
import java.awt.Color;
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
        lbAddSupplier = new javax.swing.JLabel();
        lbManageSupplier = new javax.swing.JLabel();
        lbSelectSupplier = new javax.swing.JLabel();
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(lbAdminEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
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
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbManageCategories.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbManageCategories.setForeground(new java.awt.Color(255, 255, 255));
        lbManageCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/purchasedetails_light.png"))); // NOI18N
        lbManageCategories.setText("Manage Categories");
        lbManageCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageCategoriesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbManageCategoriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbManageCategoriesMouseExited(evt);
            }
        });

        lbManageProducts.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbManageProducts.setForeground(new java.awt.Color(255, 255, 255));
        lbManageProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box_light.png"))); // NOI18N
        lbManageProducts.setText("Manage Products");
        lbManageProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbManageProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbManageProductsMouseExited(evt);
            }
        });

        lbManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbManageUsers.setForeground(new java.awt.Color(255, 255, 255));
        lbManageUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        lbManageUsers.setText("Manage Users");
        lbManageUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbManageUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbManageUsersMouseExited(evt);
            }
        });

        lbAddSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbAddSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbAddSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier_light.png"))); // NOI18N
        lbAddSupplier.setText("Add Supplier");
        lbAddSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAddSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAddSupplierMouseExited(evt);
            }
        });

        lbManageSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbManageSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbManageSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_supplier_light.png"))); // NOI18N
        lbManageSupplier.setText("Manage Suppliers");
        lbManageSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbManageSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbManageSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbManageSupplierMouseExited(evt);
            }
        });

        lbSelectSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSelectSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbSelectSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delivery_light.png"))); // NOI18N
        lbSelectSupplier.setText("Select Supplier");
        lbSelectSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSelectSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSelectSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSelectSupplierMouseExited(evt);
            }
        });

        lbTransaction.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTransaction.setForeground(new java.awt.Color(255, 255, 255));
        lbTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transaction_light.png"))); // NOI18N
        lbTransaction.setText("Transaction");
        lbTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbTransactionMouseExited(evt);
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
                    .addComponent(lbManageSupplier)
                    .addComponent(lbAddSupplier)
                    .addComponent(lbManageUsers)
                    .addComponent(lbManageCategories)
                    .addComponent(lbTransaction)
                    .addComponent(lbManageProducts)
                    .addComponent(lbSelectSupplier))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbManageCategories)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbManageProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbManageUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAddSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbManageSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSelectSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTransaction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 107, 189));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Statistics");

        lbTotalCategories.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalCategories.setText("Total Categories:");

        lbTotalProducts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalProducts.setText("Total Products:");

        lbTotalUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalUsers.setText("Total Users:");

        lbTotalSuppliers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalSuppliers.setText("Total Suppliers:");

        lbTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                        .addContainerGap(196, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout now?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            login.setVisible(true);
            login.setEmailAndPasswordToDefault();
            this.dispose();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbManageUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageUsersMouseClicked
        // TODO add your handling code here:
        ManageUsers manageUsers = new ManageUsers(login, this);
        manageUsers.setVisible(true);
    }//GEN-LAST:event_lbManageUsersMouseClicked

    private void lbAddSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddSupplierMouseClicked
        // TODO add your handling code here:
        AddSupplier addSupplier = new AddSupplier(login, this);
        addSupplier.setVisible(true);
    }//GEN-LAST:event_lbAddSupplierMouseClicked

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

    private void lbSelectSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSelectSupplierMouseClicked
        // TODO add your handling code here:
        SelectSupplier selectSupplier = new SelectSupplier(login, this);
        selectSupplier.setVisible(true);
    }//GEN-LAST:event_lbSelectSupplierMouseClicked

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

    private void lbManageCategoriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageCategoriesMouseEntered
        // TODO add your handling code here:
        lbManageCategories.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbManageCategories.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbManageCategoriesMouseEntered

    private void lbManageCategoriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageCategoriesMouseExited
        // TODO add your handling code here:
        lbManageCategories.setBackground(null); // Khôi phục màu nền mặc định
        lbManageCategories.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbManageCategoriesMouseExited

    private void lbManageProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageProductsMouseEntered
        // TODO add your handling code here:
        lbManageProducts.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbManageProducts.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbManageProductsMouseEntered

    private void lbManageProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageProductsMouseExited
        // TODO add your handling code here:
        lbManageProducts.setBackground(null); // Khôi phục màu nền mặc định
        lbManageProducts.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbManageProductsMouseExited

    private void lbManageUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageUsersMouseEntered
        // TODO add your handling code here:
        lbManageUsers.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbManageUsers.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbManageUsersMouseEntered

    private void lbManageUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageUsersMouseExited
        // TODO add your handling code here:
        lbManageUsers.setBackground(null); // Khôi phục màu nền mặc định
        lbManageUsers.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbManageUsersMouseExited

    private void lbAddSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddSupplierMouseEntered
        // TODO add your handling code here:
        lbAddSupplier.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbAddSupplier.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbAddSupplierMouseEntered

    private void lbAddSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddSupplierMouseExited
        // TODO add your handling code here:
        lbAddSupplier.setBackground(null); // Khôi phục màu nền mặc định
        lbAddSupplier.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbAddSupplierMouseExited

    private void lbManageSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageSupplierMouseEntered
        // TODO add your handling code here:
        lbManageSupplier.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbManageSupplier.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbManageSupplierMouseEntered

    private void lbManageSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbManageSupplierMouseExited
        // TODO add your handling code here:
        lbManageSupplier.setBackground(null); // Khôi phục màu nền mặc định
        lbManageSupplier.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbManageSupplierMouseExited

    private void lbSelectSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSelectSupplierMouseEntered
        // TODO add your handling code here:
        lbSelectSupplier.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbSelectSupplier.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbSelectSupplierMouseEntered

    private void lbSelectSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSelectSupplierMouseExited
        // TODO add your handling code here:
        lbSelectSupplier.setBackground(null); // Khôi phục màu nền mặc định
        lbSelectSupplier.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbSelectSupplierMouseExited

    private void lbTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseEntered
        // TODO add your handling code here:
        lbTransaction.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbTransaction.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbTransactionMouseEntered

    private void lbTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTransactionMouseExited
        // TODO add your handling code here:
        lbTransaction.setBackground(null); // Khôi phục màu nền mặc định
        lbTransaction.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbTransactionMouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        jLabel2.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setBackground(null); // Khôi phục màu nền mặc định
        jLabel2.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_jLabel2MouseExited

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbAddSupplier;
    private javax.swing.JLabel lbAdminEmail;
    private javax.swing.JLabel lbManageCategories;
    private javax.swing.JLabel lbManageProducts;
    private javax.swing.JLabel lbManageSupplier;
    private javax.swing.JLabel lbManageUsers;
    private javax.swing.JLabel lbSelectSupplier;
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
