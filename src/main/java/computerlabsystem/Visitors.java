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
        lblWarningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient1.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient1.setColorSecondary(new java.awt.Color(199, 188, 161));

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtName);
        txtName.setBounds(75, 30, 250, 40);

        comboBoxPurpose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "OTHERS" }));
        comboBoxPurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPurposeActionPerformed(evt);
            }
        });
        panelGradient1.add(comboBoxPurpose);
        comboBoxPurpose.setBounds(75, 230, 250, 22);

        txtOtherPurpose.setText("jTextField1");
        panelGradient1.add(txtOtherPurpose);
        txtOtherPurpose.setBounds(75, 260, 250, 22);

        comboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEFAULT", "MALE", "FEMALE", "I PREFER NOT TO SAY", " " }));
        panelGradient1.add(comboBoxGender);
        comboBoxGender.setBounds(130, 190, 140, 22);

        txtMobileNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMobileNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "MOBILE NUMBER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtMobileNumber);
        txtMobileNumber.setBounds(75, 80, 250, 41);

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtEmail);
        txtEmail.setBounds(75, 130, 250, 41);

        btnLogs.setBackground(new java.awt.Color(0, 0, 0));
        btnLogs.setForeground(new java.awt.Color(255, 255, 255));
        btnLogs.setText("LOGS");
        btnLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogsActionPerformed(evt);
            }
        });
        panelGradient1.add(btnLogs);
        btnLogs.setBounds(232, 330, 90, 23);

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelGradient1.add(btnClear);
        btnClear.setBounds(155, 330, 72, 23);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        panelGradient1.add(btnBack);
        btnBack.setBounds(75, 330, 72, 23);

        lblWarningMsg.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-error-24.png")); // NOI18N
        lblWarningMsg.setText("jLabel1");
        panelGradient1.add(lblWarningMsg);
        lblWarningMsg.setBounds(165, 370, 70, 24);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxPurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPurposeActionPerformed
        purpose = String.valueOf(comboBoxPurpose.getSelectedItem());

        if (purpose.equals("OTHERS")) {
            txtOtherPurpose.setVisible(true);
        }
    }//GEN-LAST:event_comboBoxPurposeActionPerformed

    private void btnLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogsActionPerformed
        role = "VISITORS";
        fullname = txtName.getText();
        mobileNumber = txtMobileNumber.getText();
        email = txtEmail.getText();
        gender = String.valueOf(comboBoxGender.getSelectedItem());
        purpose = String.valueOf(comboBoxPurpose.getSelectedItem());

        if (fullname.isEmpty() && mobileNumber.isEmpty() && email.isEmpty() && gender.equals("DEFAULT") && purpose.equals("DEFAULT")) {
            lblWarningMsg.setText("Please provide the required information before hitting Logs");
        } else if (fullname.isEmpty()) {
            lblWarningMsg.setText("Please specify your name");
        } else if (fullname.contains("  ")) {
            lblWarningMsg.setText("Your name contains too many spaces");
        } else if (mobileNumber.isEmpty()) {
            lblWarningMsg.setText("Please specify your Mobile Number");
        } else if (email.isEmpty()) {
            lblWarningMsg.setText("Please specify your Email");
        } else if (gender.equals("DEFAULT")) {
            lblWarningMsg.setText("Please select your Gender");
        } else if (purpose.equals("DEFAULT")) {
            lblWarningMsg.setText("Please select the Purpose");
        } else if(!fullname.matches("[A-Za-z0-9\\-.]+")){
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, or dots.");
        }else if(!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")){
        lblWarningMsg.setText("Invalid email address format.");
        }
        else {
            String identity = ForgetPasswordMethods.generateCode();
            // All information provided, proceed with logging
            String msg = visitorsMethods.insertVisitorData(identity, role, fullname, mobileNumber, email, gender, purpose);
            int id = ComLabMethods.getVisitorID(identity);
            visitorsMethods.VisitorInsertLog(id, fullname);
            lblWarningMsg.setText(msg);
        }

    }//GEN-LAST:event_btnLogsActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtMobileNumber.setText("");
        txtEmail.setText("");
        comboBoxGender.setSelectedIndex(0);
        comboBoxPurpose.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

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
    private String role, fullname, mobileNumber, email, gender, purpose;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogs;
    private javax.swing.JComboBox<String> comboBoxGender;
    private javax.swing.JComboBox<String> comboBoxPurpose;
    private javax.swing.JLabel lblWarningMsg;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOtherPurpose;
    // End of variables declaration//GEN-END:variables
}
