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
        initComponents();
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
        lblID = new javax.swing.JLabel();
        checkboxShowPass = new javax.swing.JCheckBox();
        lblPassword = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        txtStudentFacultyID = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnGoToSignUp = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();
        lblAttemptsLeft = new javax.swing.JLabel();
        btnForgotPass = new javax.swing.JLabel();
        btnVisitor = new javax.swing.JButton();
        lblDoYouHaveanAccount = new javax.swing.JLabel();
        lblWaveGIF = new javax.swing.JLabel();

        setOpaque(false);

        loginPanel.setBackground((new Color(0, 0, 0, 0)));
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-23.png"))); // NOI18N
        loginPanel.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        checkboxShowPass.setFont(new java.awt.Font("Rockwell", 3, 12)); // NOI18N
        checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png"))); // NOI18N
        checkboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPassActionPerformed(evt);
            }
        });
        loginPanel.add(checkboxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, 60));

        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-password-23.png"))); // NOI18N
        loginPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        fieldPassword.setBackground((new Color(0, 0, 0, 0)));
        fieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        fieldPassword.setPreferredSize(new java.awt.Dimension(65, 20));
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });
        loginPanel.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 320, 50));

        txtStudentFacultyID.setBackground((new Color(0, 0, 0, 0)));
        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(65, 20));
        loginPanel.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 320, 50));

        btnLogin.setBackground(new java.awt.Color(51, 51, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        loginPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 300, -1));

        btnGoToSignUp.setBackground((new Color(0, 0, 0, 0)));
        btnGoToSignUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGoToSignUp.setText(" SIGN UP");
        btnGoToSignUp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        btnGoToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToSignUpActionPerformed(evt);
            }
        });
        loginPanel.add(btnGoToSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 60, 20));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMsg.setText("jLabel3");
        loginPanel.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 350, -1));

        lblAttemptsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAttemptsLeft.setText("jLabel1");
        loginPanel.add(lblAttemptsLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 210, -1));

        btnForgotPass.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnForgotPass.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnForgotPass.setText("Forgot Password?");
        btnForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForgotPassMouseClicked(evt);
            }
        });
        loginPanel.add(btnForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 120, 20));

        btnVisitor.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnVisitor.setText("VISITORS");
        btnVisitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitorActionPerformed(evt);
            }
        });
        loginPanel.add(btnVisitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, -1));

        lblDoYouHaveanAccount.setText("Don't have an account?");
        loginPanel.add(lblDoYouHaveanAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, 20));

        lblWaveGIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/output-onlinegiftools.gif"))); // NOI18N
        loginPanel.add(lblWaveGIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 230, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowPassActionPerformed
        if (checkboxShowPass.isSelected()) {
            checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-eye-20.png")));
            fieldPassword.setEchoChar((char) 0);

        } else {
            checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png")));
            fieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkboxShowPassActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        stuFaculID = txtStudentFacultyID.getText();
        pass = String.valueOf(fieldPassword.getPassword());

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
                VisitorsMethods.createVisitorsTable();
                ComLabMethods.createLogs() ;
//                ComLabMethods.createLogs();
                //  String hashedPassword = ComLabMethods.hashPassword(pass);
                if (userRole.equals("ADMIN")) {
                    ComLabMethods.logUserLogin(sfID, fullName, pass);
                    AdminDashboard admn = new AdminDashboard(fname, sfID);
                    admn.setVisible(true);
                    SwingUtilities.getWindowAncestor((Component) evt.getSource()).dispose();
                } else if (userRole.equals("STUDENT") || userRole.equals("FACULTY")) {
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

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

    private void btnGoToSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoToSignUpActionPerformed

    private void btnVisitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitorActionPerformed
        Visitors dialog = new Visitors(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnVisitorActionPerformed

    private void btnForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgotPassMouseClicked
        ForgotPass dialog = new ForgotPass(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnForgotPassMouseClicked

    private static int attempt = 3;
    private String stuFaculID, pass;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnForgotPass;
    private javax.swing.JButton btnGoToSignUp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnVisitor;
    private javax.swing.JCheckBox checkboxShowPass;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel lblAttemptsLeft;
    private javax.swing.JLabel lblDoYouHaveanAccount;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JLabel lblWaveGIF;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
