/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import dao.UserDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class ForgotPassword extends javax.swing.JFrame {

    private Login login;

    private List<UserDAO> userList;
    private static final String FILE_NAME = "USER.DAT";

    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
        setLocationRelativeTo(null);
        LoadData();
        cbSecurity.setEnabled(false);
        txtAnswer.setEditable(false);
        txtNewPassword.setEditable(false);
    }

    public ForgotPassword(Login login) {
        this();
        this.login = login;
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
            System.out.println("hello");
            userList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
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

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        cbSecurity = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbSearch = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Answer:");

        cbSecurity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite color?", "What is your favourite drink?", "What is your favourite game?", "What is your favourite song?" }));
        cbSecurity.setSelectedIndex(-1);
        cbSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecurityActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Security:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("New Password:");

        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPasswordActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 107, 189));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 107, 189));
        jLabel6.setText("Forgot Password");

        lbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        lbSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSearchMouseEntered(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(cbSecurity, javax.swing.GroupLayout.Alignment.TRAILING, 0, 193, Short.MAX_VALUE)
                                    .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBack)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnSave))
                                    .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(lbSearch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(71, 71, 71))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnBack))
                .addGap(52, 52, 52))
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        boolean check = false;
        for (int i = 0; i < userList.size(); i++) {
            UserDAO user = userList.get(i);
            if (user.getEmail().equals(txtEmail.getText())) {
                String selectedSecurityQuestion = cbSecurity.getSelectedItem().toString();
                if (!user.getSecurityQuestion().equals(selectedSecurityQuestion)) {
                    JOptionPane.showMessageDialog(rootPane, "Câu hỏi không hợp lệ!", "Warning", 2);
                } else {
                    String answer = txtAnswer.getText();
                    if (!user.getSecurityQuestionAns().equals(answer)) {
                        JOptionPane.showMessageDialog(rootPane, "Câu trả lời sai", "Warning", 2);
                    } else {
                        String tmpNewPassword = txtNewPassword.getText();
                        user.setPassword(tmpNewPassword);  // Đây sẽ sửa trực tiếp đối tượng gốc
                        JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công");
                        check = true;
                        login.setUserListData(userList);
                        this.dispose();
                        login.setVisible(true);
                        break;
                    }
                }
            }
        }

        if (!check) {
            JOptionPane.showMessageDialog(rootPane, "Da xay ra loi! Vui long kiem ra lai!", "Warning", 2);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lbSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMouseClicked
        // TODO add your handling code here:
        boolean check = false;
        for (UserDAO user : userList) {
            if (user.getEmail().equals(txtEmail.getText())) {
                cbSecurity.setEnabled(true);
                txtAnswer.setEditable(true);
                txtNewPassword.setEditable(true);
                JOptionPane.showMessageDialog(rootPane, "Email hop le!");
                check = true;
                break;
            }
        }
        if (check == false) {
            JOptionPane.showMessageDialog(rootPane, "Email khong hop le!", "Warning", 2);
        }
    }//GEN-LAST:event_lbSearchMouseClicked

    private void cbSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecurityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSecurityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearchMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_lbSearchMouseEntered

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbSecurity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNewPassword;
    // End of variables declaration//GEN-END:variables
}
