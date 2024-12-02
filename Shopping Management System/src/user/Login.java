/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import admin.AdminDashboard;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import dao.TransactionDTO;
import dao.UserBalanceDAO;
import dao.UserDAO;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import supplier.SupplierDashboard;

/**
 *
 * @author admin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
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

    private ButtonGroup bg = new ButtonGroup();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        bg.add(rbtnUser);
        bg.add(rbtnSupplier);
        bg.add(rbtnAdmin);
        rbtnUser.setSelected(true);
        LoadData();
        LoadDataToSupplierList();
        LoadDataToCategoryList();
        LoadDataToProductList();
        LoadDataToTransactionList();
        LoadDataToUserBalanceList();
    }

    public void setEmailAndPasswordToDefault() {
        txtEmail.setText("");
        txtPassword.setText("");
    }

/////////////////////////////////////////////////////////////
    private void LoadData() {
        File file = new File(FILE_NAME);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME); ObjectInputStream ois = new ObjectInputStream(fis)) {
                userList = (List<UserDAO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            userList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFile() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(userList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setAccount(UserDAO user) {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user);
        writeDataToFile();
    }

    public void setUserListData(List<UserDAO> ExternalUserList) {
        userList = ExternalUserList;
        writeDataToFile();
    }
///////////////////////////////////////////////

    private void LoadDataToSupplierList() {
        File file = new File(FILE_NAME_SUPPLIER);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_SUPPLIER); ObjectInputStream ois = new ObjectInputStream(fis)) {
                supplierList = (List<SupplierDAO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            supplierList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFileSupplier() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME_SUPPLIER); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(supplierList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setSupplierListData(List<SupplierDAO> ExternalSupplierList) {
        supplierList = ExternalSupplierList;
        writeDataToFileSupplier();
    }

///////////////////////////////////////////////////
    private void LoadDataToCategoryList() {
        File file = new File(FILE_NAME_CATEGORY);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_CATEGORY); ObjectInputStream ois = new ObjectInputStream(fis)) {
                categoryList = (List<CategoryDAO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            categoryList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFileCategory() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME_CATEGORY); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(categoryList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setCategoryListData(List<CategoryDAO> ExternalCategoryList) {
        categoryList = ExternalCategoryList;
        writeDataToFileCategory();
    }

///////////////////////////////////////////////////
    private void LoadDataToProductList() {
        File file = new File(FILE_NAME_PRODUCT);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_PRODUCT); ObjectInputStream ois = new ObjectInputStream(fis)) {
                productList = (List<ProductDAO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            productList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFileProduct() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME_PRODUCT); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(productList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setProductListData(List<ProductDAO> ExternalProductList) {
        productList = ExternalProductList;
        writeDataToFileProduct();
    }
///////////////////////////////////////////////////

    private void LoadDataToTransactionList() {
        File file = new File(FILE_NAME_TRANSACTION);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_TRANSACTION); ObjectInputStream ois = new ObjectInputStream(fis)) {
                transactionList = (List<TransactionDTO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            transactionList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFileTransaction() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME_TRANSACTION); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(transactionList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setTransactionListDataReplace(List<TransactionDTO> ExternalTransactionList) {
        // Thêm tất cả phần tử của ExternalTransactionList vào transactionList
        transactionList = ExternalTransactionList;
        writeDataToFileTransaction();
    }

    public void setTransactionListData(List<TransactionDTO> ExternalTransactionList) {
        // Thêm tất cả phần tử của ExternalTransactionList vào transactionList
        transactionList.addAll(ExternalTransactionList);
        writeDataToFileTransaction();
    }
///////////////////////////////////////////////////

    private void LoadDataToUserBalanceList() {
        File file = new File(FILE_NAME_USERBALANCE);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_USERBALANCE); ObjectInputStream ois = new ObjectInputStream(fis)) {
                userBalanceList = (List<UserBalanceDAO>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            userBalanceList = new ArrayList<>();  // Nếu file rỗng, khởi tạo danh sách trống
        }
    }

    private void writeDataToFileUserBalance() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME_USERBALANCE); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(userBalanceList);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setUserBalanceListDataReplace(List<UserBalanceDAO> ExternalUserBalanceList) {
        // Thêm tất cả phần tử của ExternalTransactionList vào transactionList
        userBalanceList = ExternalUserBalanceList;
        writeDataToFileUserBalance();
    }

    public void setUserBalanceListData(List<UserBalanceDAO> ExternalUserBalanceList) {
        // Thêm tất cả phần tử của ExternalTransactionList vào transactionList
        userBalanceList.addAll(ExternalUserBalanceList);
        writeDataToFileUserBalance();
    }
///////////////////////////////////////////////////

    private boolean isEmailAndPasswordValid() {
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Email is required!", "Warning", 2);
            return false;
        }
        if (!txtEmail.getText().contains("@")) {
            JOptionPane.showMessageDialog(rootPane, "Email is invalid!", "Warning", 2);
            return false;
        }
        if (!txtEmail.getText().contains(".com")) {
            JOptionPane.showMessageDialog(rootPane, "Email is invalid!", "Warning", 2);
            return false;
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Password is required!", "Warning", 2);
            return false;
        }
        return true;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbtnUser = new javax.swing.JRadioButton();
        rbtnSupplier = new javax.swing.JRadioButton();
        rbtnAdmin = new javax.swing.JRadioButton();
        btnLogin = new javax.swing.JButton();
        lbSignUp = new javax.swing.JLabel();
        lbResetPassword = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/200px-Shopee-logo.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel2.setText("WELCOME");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setText("TO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel4.setText("SHOPEE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 440));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Login");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Password:");

        rbtnUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbtnUser.setText("User");
        rbtnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnUserActionPerformed(evt);
            }
        });

        rbtnSupplier.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbtnSupplier.setText("Supplier");

        rbtnAdmin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rbtnAdmin.setText("Admin");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbSignUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSignUp.setText("Sign Up");
        lbSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSignUpMouseExited(evt);
            }
        });

        lbResetPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbResetPassword.setText("Reset Password");
        lbResetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbResetPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbResetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbResetPasswordMouseExited(evt);
            }
        });

        jButton2.setText("X");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(189, 189, 189))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnUser)
                                .addGap(36, 36, 36)
                                .addComponent(rbtnSupplier)
                                .addGap(26, 26, 26)
                                .addComponent(rbtnAdmin))
                            .addComponent(lbResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnUser)
                    .addComponent(rbtnSupplier)
                    .addComponent(rbtnAdmin))
                .addGap(37, 37, 37)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSignUp)
                .addGap(18, 18, 18)
                .addComponent(lbResetPassword)
                .addGap(0, 56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 410, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void rbtnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnUserActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void lbSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignUpMouseClicked
        // TODO add your handling code here:
        SignUp signUp = new SignUp(this);
        signUp.setVisible(true);
        lbSignUp.setBackground(null); // Khôi phục màu nền mặc định
        lbSignUp.setOpaque(false); // Không hiển thị màu nền
        this.dispose();
    }//GEN-LAST:event_lbSignUpMouseClicked

    private void lbResetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbResetPasswordMouseClicked
        // TODO add your handling code here:
        ForgotPassword forgotPassword = new ForgotPassword(this);
        forgotPassword.setVisible(true);
        lbResetPassword.setBackground(null); // Khôi phục màu nền mặc định
        lbResetPassword.setOpaque(false); // Không hiển thị màu nền
        this.dispose();
    }//GEN-LAST:event_lbResetPasswordMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        if (txtPassword.getEchoChar() == '*') {
            txtPassword.setEchoChar((char) 0); // Hiển thị mật khẩu
        } else {
            txtPassword.setEchoChar('*'); // Ẩn mật khẩu
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        jLabel11.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        jLabel11.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        jLabel11.setBackground(null); // Khôi phục màu nền mặc định
        jLabel11.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_jLabel11MouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (isEmailAndPasswordValid()) {
            String email = txtEmail.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if (rbtnUser.isSelected()) {
                boolean check = false;
                for (UserDAO user : userList) {
                    if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                        UserDAO newUser = user;
                        UserDashboard userDashboard = new UserDashboard(newUser, this);
                        userDashboard.setVisible(true);
                        userDashboard.pack();

                        check = true;
                        this.dispose();
                        break;
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect email or password", "Cannot Login", JOptionPane.ERROR_MESSAGE);
                }
            } else if (rbtnAdmin.isSelected()) {
                if (email.equals("admin@gmail.com") && password.equals("admin")) {
                    AdminDashboard adminDashboard = new AdminDashboard(this);
                    adminDashboard.setVisible(true);
                    adminDashboard.pack();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "You are not admin!", "Cannot Login", JOptionPane.ERROR_MESSAGE);
                }
            } else if (rbtnSupplier.isSelected()) {
                // do something
                boolean check = false;
                for (SupplierDAO supplier : supplierList) {
                    if (email.equals(supplier.getSupplierEmail()) && password.equals(supplier.getSupplierPassword())) {
                        SupplierDAO newSupplier = supplier;
                        SupplierDashboard supplierDashboard = new SupplierDashboard(newSupplier, this);
                        supplierDashboard.setVisible(true);
                        supplierDashboard.pack();

                        check = true;
                        this.dispose();
                        break;
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect email or password", "Cannot Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lbSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignUpMouseEntered
        // TODO add your handling code here:
        lbSignUp.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbSignUp.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbSignUpMouseEntered

    private void lbSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignUpMouseExited
        // TODO add your handling code here:
        lbSignUp.setBackground(null); // Khôi phục màu nền mặc định
        lbSignUp.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbSignUpMouseExited

    private void lbResetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbResetPasswordMouseEntered
        // TODO add your handling code here:
        lbResetPassword.setBackground(Color.LIGHT_GRAY); // Màu nền sáng
        lbResetPassword.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
    }//GEN-LAST:event_lbResetPasswordMouseEntered

    private void lbResetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbResetPasswordMouseExited
        // TODO add your handling code here:
        lbResetPassword.setBackground(null); // Khôi phục màu nền mặc định
        lbResetPassword.setOpaque(false); // Không hiển thị màu nền
    }//GEN-LAST:event_lbResetPasswordMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbResetPassword;
    private javax.swing.JLabel lbSignUp;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnSupplier;
    private javax.swing.JRadioButton rbtnUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
