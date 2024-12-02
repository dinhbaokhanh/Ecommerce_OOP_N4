/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import dao.UserBalanceDAO;
import dao.UserDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class UserAccount extends javax.swing.JFrame {

    private List<UserDAO> userList;
    private static final String FILE_NAME = "USER.DAT";

    private List<UserBalanceDAO> userBalanceList;
    private static final String FILE_NAME_USERBALANCE = "USERBALANCE.DAT";

    private Login login;
    private UserDAO user;
    private UserDashboard userDashboard;

    /**
     * Creates new form UserAccount
     */
    public UserAccount() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public UserAccount(Login login, UserDAO user, UserDashboard userDashboard) {
        this();
        this.login = login;
        this.user = user;
        this.userDashboard = userDashboard;
        initUserData();
        LoadData();
        LoadDataUserBalance();
        txtUserID.setEditable(false);
    }

    private void initUserData() {
        txtUserID.setText(user.getUserID());
        txtUsername.setText(user.getUsername());
        txtEmail.setText(user.getEmail());
        txtPassword.setText(user.getPassword());
        txtPhone.setText(user.getPhoneNumber());
        cbSecurity.setSelectedItem(user.getSecurityQuestion());
        txtAnswer.setText(user.getSecurityQuestionAns());
        txtAddress.setText(user.getAddress());
    }

    private void LoadData() {
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

    public boolean isInformationValid() {
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Username is required", "Warning", 2);
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Email is required", "Warning", 2);
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
        if (txtPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "phone is required", "Warning", 2);
            return false;
        }
        if (cbSecurity.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Security is needed", "Warning", 2);
            return false;
        }
        if (txtAnswer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Security Answer is required", "Warning", 2);
            return false;
        }
        if (txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Address is required", "Warning", 2);
            return false;
        }
        return true;
    }

    private boolean checkIfNewInformationValid() {
        String newEmail = txtEmail.getText();
        String newPhone = txtPhone.getText();
        for (UserDAO user : userList) {
            if (user.getEmail().equals(newEmail)) {
                JOptionPane.showMessageDialog(rootPane, "Email already exists", "Warning", 2);
                return false;
            }
            if (user.getPhoneNumber().equals(newPhone)) {
                JOptionPane.showMessageDialog(rootPane, "PhoneNumber already exists", "Warning", 2);
                return false;
            }
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

        cbSecurity = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbSecurity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite color?", "What is your favourite drink?", "What is your favourite game?", "What is your favourite song?" }));
        cbSecurity.setSelectedIndex(-1);
        cbSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecurityActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Answer:");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setText("Sign Up");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("User ID:");

        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Password:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Phone:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Security:");

        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserID)
                            .addComponent(txtUsername)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)
                            .addComponent(txtPhone)
                            .addComponent(cbSecurity, 0, 198, Short.MAX_VALUE)
                            .addComponent(txtAnswer)
                            .addComponent(txtAddress))
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(111, 111, 111)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecurityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSecurityActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane,
                "Are you sure to delete this account?", "Delete Account", JOptionPane.OK_CANCEL_OPTION, 0);
        if (confirm == JOptionPane.OK_OPTION) {
            String currentUserId = txtUserID.getText();
            for (int i = 0; i < userList.size(); i++) {
                UserDAO tmpUser = userList.get(i);
                if (tmpUser.getUserID().equals(currentUserId)) {
                    userList.remove(i);
                    login.setUserListData(userList);
                    for (int j = 0; j < userBalanceList.size(); i++) {
                        UserBalanceDAO tmpUserBalanceDAO = userBalanceList.get(j);
                        if (tmpUserBalanceDAO.getUserID().equals(currentUserId)) {
                            userBalanceList.remove(j);
                            login.setUserBalanceListDataReplace(userBalanceList);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(rootPane, "Xoa thong tin thanh cong!");
                    this.dispose();
                    userDashboard.dispose();
                    login.setEmailAndPasswordToDefault();
                    login.setVisible(true);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "ok");
            this.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (isInformationValid()) {
            if (checkIfNewInformationValid()) {
                String userId = txtUserID.getText();
                String newUsername = txtUsername.getText();
                String newEmail = txtEmail.getText();
                String newPassword = String.valueOf(txtPassword.getPassword());
                String newPhone = txtPhone.getText();
                String newSecurityQuestion = cbSecurity.getSelectedItem().toString();
                String newAnswer = txtAnswer.getText();
                String newAddress = txtAddress.getText();

                for (int i = 0; i < userList.size(); i++) {
                    UserDAO user = userList.get(i);
                    if (user.getUserID().equals(userId)) {
                        user.setUsername(newUsername);
                        user.setEmail(newEmail);
                        user.setPassword(newPassword);
                        user.setPhoneNumber(newPhone);
                        user.setSecurityQuestion(newSecurityQuestion);
                        user.setSecurityQuestionAns(newAnswer);
                        user.setAddress(newAddress);
                        JOptionPane.showMessageDialog(rootPane, "Sua thong tin thanh cong!");
                        login.setUserListData(userList);
                        this.user = user;
                        userDashboard.setUser(this.user);
                        userDashboard.setLbEmailText();
                        this.dispose();
                        break;
                    }
                }
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMouseEntered

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
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSecurity;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
