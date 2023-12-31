/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;

/**
 *
 * @author araos
 */
public class ForgetPasswordVerification extends javax.swing.JDialog {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ForgetPasswordVerification(java.awt.Frame parent, boolean modal, String email) {
        super(parent, modal);
        this.email = email;
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

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        lblOTPverification = new javax.swing.JLabel();
        btnConfirmCode = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        txtCode = new javax.swing.JTextField();
        lblWarningMessage = new javax.swing.JLabel();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setColorSecondary(new java.awt.Color(109, 113, 249));

        lblOTPverification.setFont(new java.awt.Font("Segoe UI Semibold", 1, 30)); // NOI18N
        lblOTPverification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOTPverification.setText("OTP Verification");
        panelGradient1.add(lblOTPverification);
        lblOTPverification.setBounds(110, 0, 223, 41);

        btnConfirmCode.setBackground(new java.awt.Color(0, 0, 51));
        btnConfirmCode.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmCode.setText("SUBMIT");
        btnConfirmCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmCodeActionPerformed(evt);
            }
        });
        panelGradient1.add(btnConfirmCode);
        btnConfirmCode.setBounds(80, 330, 290, 40);

        btnBackToLogin.setBackground(new java.awt.Color(0, 51, 102));
        btnBackToLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToLogin.setText("BACK");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });
        panelGradient1.add(btnBackToLogin);
        btnBackToLogin.setBounds(130, 380, 190, 23);

        txtCode.setForeground(new java.awt.Color(102, 102, 102));
        txtCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCode.setText("Enter verification code");
        txtCode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        panelGradient1.add(txtCode);
        txtCode.setBounds(60, 270, 330, 50);

        lblWarningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        panelGradient1.add(lblWarningMessage);
        lblWarningMessage.setBounds(45, 410, 360, 24);

        panelBorder1.setBackground((new Color(0, 128, 0, 128)));

        jLabel1.setBackground((new Color(0, 0, 0, 0)));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" We've sent a One-Time Password (OTP)");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(0, 10, 330, 60);

        jLabel2.setBackground((new Color(0, 0, 0, 0)));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("  to your registered email for verification. ");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(0, 50, 330, 40);

        panelGradient1.add(panelBorder1);
        panelBorder1.setBounds(60, 130, 330, 120);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/emailsent.gif"))); // NOI18N
        panelGradient1.add(jLabel3);
        jLabel3.setBounds(150, 50, 160, 100);

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed

    }//GEN-LAST:event_txtCodeActionPerformed

    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackToLoginActionPerformed

    private void btnConfirmCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmCodeActionPerformed
        ComLabMethods clm = new ComLabMethods();
        String verificationCode = clm.getUpdatedCode(email);
        String inputCode = txtCode.getText();
        lblWarningMessage.setVisible(true);
        if (inputCode.isEmpty()) {
            lblWarningMessage.setText("Please Enter the code before you hit the reset Password");
        } else if (inputCode.equals(verificationCode)) {
            ForgotResetPassword dialog = new ForgotResetPassword(new javax.swing.JFrame(), true, verificationCode);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dispose();
            dialog.setVisible(true);
        }
        
    }//GEN-LAST:event_btnConfirmCodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnConfirmCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblOTPverification;
    private javax.swing.JLabel lblWarningMessage;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
