/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author araos
 */
public class ForgotPass extends javax.swing.JDialog {

    /**
     * Creates new form ForgotPass
     */
    public ForgotPass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblWarningMessage.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new computerlabsystem.Design.PanelGradient();
        txtEmail = new javax.swing.JTextField();
        lblForgotPassword = new javax.swing.JLabel();
        lblEnterEmail = new javax.swing.JLabel();
        btnRequestCode = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel.setColorPrimary(new java.awt.Color(109, 113, 249));
        Panel.setColorSecondary(new java.awt.Color(199, 188, 161));

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        Panel.add(txtEmail);
        txtEmail.setBounds(50, 150, 340, 40);

        lblForgotPassword.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 28)); // NOI18N
        lblForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgotPassword.setText("FORGOT PASSWORD?");
        Panel.add(lblForgotPassword);
        lblForgotPassword.setBounds(60, 50, 310, 30);

        lblEnterEmail.setBackground(new java.awt.Color(255, 255, 255));
        lblEnterEmail.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lblEnterEmail.setText("Don't worry! Please enter the email you use to sign in.");
        Panel.add(lblEnterEmail);
        lblEnterEmail.setBounds(50, 80, 360, 40);

        btnRequestCode.setBackground(new java.awt.Color(0, 0, 51));
        btnRequestCode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRequestCode.setForeground(new java.awt.Color(255, 255, 255));
        btnRequestCode.setText("REQUEST CODE FOR PASSWORD RESET");
        btnRequestCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestCodeActionPerformed(evt);
            }
        });
        Panel.add(btnRequestCode);
        btnRequestCode.setBounds(80, 220, 290, 40);

        btnBackToLogin.setBackground(new java.awt.Color(0, 0, 51));
        btnBackToLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackToLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToLogin.setText("BACK TO LOGIN");
        Panel.add(btnBackToLogin);
        btnBackToLogin.setBounds(140, 270, 160, 23);

        lblWarningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        Panel.add(lblWarningMessage);
        lblWarningMessage.setBounds(50, 300, 350, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestCodeActionPerformed
        String email = txtEmail.getText();
        if (email.isEmpty()) {
            lblWarningMessage.setText("Enter your email before you hit the request button");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMessage.setText("Invalid email address.");
        } else {
            try {
                ComLabMethods comLabMethods = new ComLabMethods();
                String studentFacultyID = comLabMethods.getStudentFacultyID(email);
                ForgetPasswordMethods forgetPasswordMethods = new ForgetPasswordMethods();
                String name = forgetPasswordMethods.getName(email);
                forgetPasswordMethods.sendMail(email, name, studentFacultyID);
                ForgetPasswordVerification dialog = new ForgetPasswordVerification(new javax.swing.JFrame(), true, email);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dispose();
                dialog.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnRequestCodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private computerlabsystem.Design.PanelGradient Panel;
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnRequestCode;
    private javax.swing.JLabel lblEnterEmail;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblWarningMessage;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
