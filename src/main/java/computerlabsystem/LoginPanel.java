/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author araos
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();;
        lblWarningMsg.setVisible(false);
        lblAttemptsLeft.setVisible(false);
    }

    public void addEventRegister(ActionListener event) {
        btnGoToSignUp.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chckbxShowPass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        fieldPass = new javax.swing.JPasswordField();
        txtStudentFacultyID = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnGoToSignUp = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();
        lblAttemptsLeft = new javax.swing.JLabel();
        btnForgotPass = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        loginPanel.setBackground((new Color(0, 0, 0, 0)));
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-id-23.png")); // NOI18N
        loginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        chckbxShowPass.setFont(new java.awt.Font("Rockwell", 3, 12)); // NOI18N
        chckbxShowPass.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-eye-20.png")); // NOI18N
        chckbxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxShowPassActionPerformed(evt);
            }
        });
        loginPanel.add(chckbxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-password-23.png")); // NOI18N
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        fieldPass.setBackground((new Color(0, 0, 0, 0)));
        fieldPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        fieldPass.setPreferredSize(new java.awt.Dimension(65, 20));
        fieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPassActionPerformed(evt);
            }
        });
        loginPanel.add(fieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 320, 50));

        txtStudentFacultyID.setBackground((new Color(0, 0, 0, 0)));
        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(65, 20));
        loginPanel.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 320, 50));

        btnLogin.setBackground(new java.awt.Color(51, 51, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        loginPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 270, -1));

        btnGoToSignUp.setBackground((new Color(0, 0, 0, 0)));
        btnGoToSignUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGoToSignUp.setText(" SIGN UP");
        btnGoToSignUp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnGoToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToSignUpActionPerformed(evt);
            }
        });
        loginPanel.add(btnGoToSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 60, 20));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-error-24.png")); // NOI18N
        lblWarningMsg.setText("jLabel3");
        loginPanel.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 235, -1));

        lblAttemptsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAttemptsLeft.setText("jLabel1");
        loginPanel.add(lblAttemptsLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 210, -1));

        btnForgotPass.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnForgotPass.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnForgotPass.setText("Forgot Password?");
        loginPanel.add(btnForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 120, 20));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("VISITORS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        loginPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        jLabel2.setText("Don't have an account?");
        loginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\output-onlinegiftools.gif")); // NOI18N
        loginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 230, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chckbxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxShowPassActionPerformed
        if (chckbxShowPass.isSelected()) {
            fieldPass.setEchoChar((char) 0);
        } else {
            fieldPass.setEchoChar('*');
        }
    }//GEN-LAST:event_chckbxShowPassActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        stuFaculID = txtStudentFacultyID.getText();
        pass = String.valueOf(fieldPass.getPassword());

        lblWarningMsg.setVisible(true);
        if (stuFaculID.isEmpty() && pass.isEmpty()) {
            lblWarningMsg.setText("Please input in the space provided");
        } else if (stuFaculID.isEmpty()) {
            lblWarningMsg.setText("Please input your ID");
        } else if (pass.isEmpty()) {
            lblWarningMsg.setText("Please input your password");
        } else {
            String userDetails = ComLabMethods.getUserDetails(stuFaculID, pass);
            if (!userDetails.equals("false")) {
                lblWarningMsg.setIcon(null);
                String[] parts = userDetails.split(",");
                String userRole = parts[0];
                String sfID = parts[1];
                String fname = parts[2];
                String lname = parts[3];

                String fullName = fname + " " + lname;
                //  String hashedPassword = ComLabMethods.hashPassword(pass);
                if (userRole.equals("ADMIN")) {
                    AdminDashboard admn = new AdminDashboard(fname, sfID);
                    admn.setVisible(true);
                    SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                } else if (userRole.equals("STUDENT") || userRole.equals("FACULTY")) {
                    ComLabMethods.createLogs();
                    ComLabMethods.logUserLogin(sfID, fullName, pass);
                    System.out.println("anooonnaaaaa");
                    UsersDashboard userDashboard = new UsersDashboard(fname, sfID);
                    userDashboard.setVisible(true);
                    SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                }
            } else {
                lblAttemptsLeft.setVisible(true);
                attempt--;
                lblWarningMsg.setText("Invalid Credentials");
                lblAttemptsLeft.setText("Attempts Left: " + String.valueOf(attempt));
                if (attempt <= 0) {
                    SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                    InvalidInput dialog = new InvalidInput(new javax.swing.JFrame(), true);
                    dialog.setVisible(true); // Show the dialog
                    attempt = 3;
                    new MainFrame().setVisible(true);
                }

            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void fieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPassActionPerformed

    private void btnGoToSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoToSignUpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Visitors dialog = new Visitors(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private static int attempt = 3;
    private String stuFaculID, pass;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnForgotPass;
    private javax.swing.JButton btnGoToSignUp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chckbxShowPass;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAttemptsLeft;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
