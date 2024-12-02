/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import dao.UserBalanceDAO;
import dao.UserDAO;
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
public class ManageUsers extends javax.swing.JFrame {

    private Login login;
    private List<UserDAO> userList;
    private static final String FILE_NAME = "USER.DAT";
    private UserDAO user = new UserDAO();
    private AdminDashboard adminDashboard;

    private List<UserBalanceDAO> userBalanceList;
    private static final String FILE_NAME_USERBALANCE = "USERBALANCE.DAT";

    private DefaultTableModel model;

    /**
     * Creates new form ManageUsers
     */
    public ManageUsers() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblUser.getModel();
        LoadData();
    }

    public ManageUsers(Login login, AdminDashboard adminDashboard) {
        this();
        this.login = login;
        this.adminDashboard = adminDashboard;
        LoadDataUserBalance();
        addUsersToTable();
    }

    public void addUsersToTable() {

        for (UserDAO user : userList) {
            Object[] newRow = {
                user.getUserID(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getSecurityQuestion(),
                user.getSecurityQuestionAns(),
                user.getAddress()
            };

            model.addRow(newRow);
        }
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

    private void clear() {
        txtUserID.setText("");
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtPhone.setText("");
        cbSecurity.setSelectedIndex(-1);
        txtAnswer.setText("");
        txtAddress.setText("");
        tblUser.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbSecurity = new javax.swing.JComboBox<>();
        txtUserID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        btnSearchByEmail = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("User ID:");

        cbSecurity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite color?", "What is your favourite drink?", "What is your favourite game?", "What is your favourite song?" }));
        cbSecurity.setSelectedIndex(-1);
        cbSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecurityActionPerformed(evt);
            }
        });

        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Address:");

        jLabel3.setText("Username:");

        jLabel9.setText("Answer:");

        jLabel4.setText("Email:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("Password:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("Phone:");

        jLabel7.setText("Security:");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "Email", "Password", "Phone", "Security Question", "Answer", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        txtSearchQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchQueryActionPerformed(evt);
            }
        });

        btnSearchByEmail.setText("Search By Email:");
        btnSearchByEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByEmailActionPerformed(evt);
            }
        });

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
                        .addGap(224, 224, 224)
                        .addComponent(btnSearchByEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(btnClear)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(51, 51, 51)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchByEmail))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(259, 259, 259))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (tblUser.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Choose a User First!", "Warning", 2);
        } else {
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
                        adminDashboard.setTotalUsersNew();
                        JOptionPane.showMessageDialog(rootPane, "Xoa thong tin thanh cong!");
                        clear();
                        model.setRowCount(0);
                        addUsersToTable();
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ok");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSearchQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchQueryActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblUser.getSelectedRow();

        // Đảm bảo rằng dòng được chọn hợp lệ
        if (rowIndex != -1) {
            // Lấy mô hình dữ liệu của bảng
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();

            // Gán giá trị từ các cột của dòng được chọn vào các JTextField
            txtUserID.setText(model.getValueAt(rowIndex, 0).toString()); // Cột 0 - User ID
            txtUsername.setText(model.getValueAt(rowIndex, 1).toString()); // Cột 1 - Username
            txtEmail.setText(model.getValueAt(rowIndex, 2).toString()); // Cột 2 - Email
            txtPassword.setText(model.getValueAt(rowIndex, 3).toString()); // Cột 3 - Password
            txtPhone.setText(model.getValueAt(rowIndex, 4).toString()); // Cột 4 - Phone
            cbSecurity.setSelectedItem(model.getValueAt(rowIndex, 5).toString()); // Cột 5 - Security Question
            txtAnswer.setText(model.getValueAt(rowIndex, 6).toString()); // Cột 6 - Answer
            txtAddress.setText(model.getValueAt(rowIndex, 7).toString()); // Cột 7 - Address
        }
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnSearchByEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByEmailActionPerformed
        // TODO add your handling code here:
        String searchQuery = txtSearchQuery.getText().trim();

        // Gọi hàm tìm kiếm nếu người dùng nhập tên
        if (!searchQuery.isEmpty()) {
            searchByEmail(searchQuery);
        } else {
            model.setRowCount(0);
            addUsersToTable();
        }
    }//GEN-LAST:event_btnSearchByEmailActionPerformed

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
                        clear();
                        login.setUserListData(userList);
                        adminDashboard.setTotalUsersNew();
                        model.setRowCount(0);
                        addUsersToTable();
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecurityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSecurityActionPerformed

    private void searchByEmail(String searchQuery) {
        model.setRowCount(0);

        for (UserDAO user : userList) {
            if (user.getEmail().toLowerCase().contains(searchQuery.toLowerCase())) {
                model.addRow(new Object[]{
                    user.getUserID(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.getSecurityQuestion(),
                    user.getSecurityQuestionAns(),
                    user.getAddress()
                });
            }
        }
    }

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
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearchByEmail;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSecurity;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchQuery;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
