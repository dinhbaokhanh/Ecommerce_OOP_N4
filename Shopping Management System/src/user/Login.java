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
        if (file.exists()) {
            file.delete();
        }
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
        if (file.exists()) {
            file.delete();
        }
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
        if (file.exists()) {
            file.delete();
        }
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
        if (file.exists()) {
            file.delete();
        }
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
        if (file.exists()) {
            file.delete();
        }
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
        if (file.exists()) {
            file.delete();
        }
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 107, 189));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(0, 107, 189));
        jLayeredPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 107, 189));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Login");
        jLabel7.setToolTipText("");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        btnLogin.setBackground(new java.awt.Color(0, 107, 189));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 189)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbSignUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSignUp.setText("Sign Up");
        lbSignUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 189)));
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

        lbResetPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        jLabel11.setOpaque(true);
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

        jLabel1.setText("Forgot password ?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(267, 267, 267))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rbtnUser)
                            .addGap(36, 36, 36)
                            .addComponent(rbtnSupplier)
                            .addGap(26, 26, 26)
                            .addComponent(rbtnAdmin))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lbSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(7, 7, 7)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnUser)
                    .addComponent(rbtnSupplier)
                    .addComponent(rbtnAdmin))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSignUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbResetPassword)
                    .addComponent(jLabel1))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 470));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
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
