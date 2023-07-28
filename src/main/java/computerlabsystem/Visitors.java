/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
public class Visitors extends javax.swing.JDialog {

    private VisitorsMethods visitorsMethods;

    /**
     * Creates new form Visitors
     */
    public Visitors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        visitorsMethods = new VisitorsMethods(); // Initialize visitorsMethods
        lblWarningMessage.setVisible(false);
        txtOtherPurpose.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        txtName = new javax.swing.JTextField();
        comboBoxPurpose = new javax.swing.JComboBox<>();
        txtOtherPurpose = new javax.swing.JTextField();
        comboBoxGender = new javax.swing.JComboBox<>();
        txtMobileNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnLogs = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelGradient1.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient1.setColorSecondary(new java.awt.Color(199, 188, 161));

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelGradient1.add(txtName);
        txtName.setBounds(70, 80, 290, 30);

        comboBoxPurpose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thesis defense panelist", "Learning Workshop", "Technical Support", "OTHERS" }));
        comboBoxPurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPurposeActionPerformed(evt);
            }
        });
        panelGradient1.add(comboBoxPurpose);
        comboBoxPurpose.setBounds(70, 270, 280, 22);
        panelGradient1.add(txtOtherPurpose);
        txtOtherPurpose.setBounds(70, 300, 280, 30);

        comboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEFAULT", "MALE", "FEMALE", "OTHER" }));
        panelGradient1.add(comboBoxGender);
        comboBoxGender.setBounds(130, 240, 160, 22);

        txtMobileNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMobileNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelGradient1.add(txtMobileNumber);
        txtMobileNumber.setBounds(70, 140, 290, 30);

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelGradient1.add(txtEmail);
        txtEmail.setBounds(70, 190, 290, 30);

        btnLogs.setBackground(new java.awt.Color(0, 0, 0));
        btnLogs.setForeground(new java.awt.Color(255, 255, 255));
        btnLogs.setText("LOGS");
        btnLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogsActionPerformed(evt);
            }
        });
        panelGradient1.add(btnLogs);
        btnLogs.setBounds(270, 350, 80, 23);

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelGradient1.add(btnClear);
        btnClear.setBounds(182, 350, 70, 23);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient1.add(btnBack);
        btnBack.setBounds(70, 350, 80, 23);

        lblWarningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        panelGradient1.add(lblWarningMessage);
        lblWarningMessage.setBounds(80, 386, 240, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-30.png"))); // NOI18N
        panelGradient1.add(jLabel1);
        jLabel1.setBounds(30, 80, 71, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-number-pad-30.png"))); // NOI18N
        panelGradient1.add(jLabel2);
        jLabel2.setBounds(30, 140, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-30.png"))); // NOI18N
        panelGradient1.add(jLabel3);
        jLabel3.setBounds(30, 190, 30, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VISITOR");
        panelGradient1.add(jLabel4);
        jLabel4.setBounds(107, 40, 180, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxPurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPurposeActionPerformed
        purpose = String.valueOf(comboBoxPurpose.getSelectedItem());
        if (purpose.equals("OTHERS")) {
            txtOtherPurpose.setVisible(true);
            purpose = txtOtherPurpose.getText();
        } else {
            txtOtherPurpose.setVisible(false);
        }
    }//GEN-LAST:event_comboBoxPurposeActionPerformed

    private void btnLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogsActionPerformed
        fullname = txtName.getText();
        mobileNumber = txtMobileNumber.getText();
        email = txtEmail.getText();
        gender = String.valueOf(comboBoxGender.getSelectedItem());
        purpose = (String) comboBoxPurpose.getSelectedItem();

        lblWarningMessage.setVisible(true);
        if (fullname.isEmpty() && mobileNumber.isEmpty() && email.isEmpty() && gender.equals("DEFAULT") && purpose.equals("DEFAULT")) {
            lblWarningMessage.setText("Please provide the required information before hitting Logs");
        } else if (fullname.isEmpty()) {
            lblWarningMessage.setText("Please specify your name");
        } else if (fullname.contains("  ")) {
            lblWarningMessage.setText("Your name contains too many spaces");
        } else if (mobileNumber.isEmpty()) {
            lblWarningMessage.setText("Please specify your Mobile Number");
        } else if (email.isEmpty()) {
            lblWarningMessage.setText("Please specify your Email");
        } else if (gender.equals("DEFAULT")) {
            lblWarningMessage.setText("Please select your Gender");
        } else if (purpose.equals("DEFAULT")) {
            lblWarningMessage.setText("Please select the Purpose");
        } else if (!fullname.matches("[A-Za-z0-9\\-. ]+")) {
            lblWarningMessage.setText("Name should only consist of letters, numbers, dashes, or dots.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMessage.setText("Invalid email address format.");
        } else {
            String identity = ForgetPasswordMethods.generateCode();
            if (!purpose.equals("OTHERS")) {
                purpose = (String) comboBoxPurpose.getSelectedItem();
            } else {
                purpose = txtOtherPurpose.getText();
            }
            VisitorsMethods.createVisitorsTable();
            ComLabMethods.createLogs();
            // All information provided, proceed with logging
            String msg = visitorsMethods.insertVisitorData(identity, fullname, mobileNumber, email, gender, purpose);
            int id = ComLabMethods.getVisitorID(identity);
            visitorsMethods.VisitorInsertLog(id, fullname);
            lblWarningMessage.setText(msg);
        }

    }//GEN-LAST:event_btnLogsActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtMobileNumber.setText("");
        txtEmail.setText("");
        comboBoxGender.setSelectedIndex(0);
        comboBoxPurpose.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentYearLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Visitors dialog = new Visitors(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private String fullname, mobileNumber, email, gender, purpose;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogs;
    private javax.swing.JComboBox<String> comboBoxGender;
    private javax.swing.JComboBox<String> comboBoxPurpose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblWarningMessage;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOtherPurpose;
    // End of variables declaration//GEN-END:variables
}
