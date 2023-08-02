/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
public class UserProfile extends javax.swing.JDialog {

    /**
     * Creates new form UserProfile
     */
    public UserProfile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setStudentInfo(int id, String stuFaculID, String email, String firstName, String lastName, String program, String yearLevel) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.yearLevel = yearLevel;

        // Set the values to the corresponding text fields or combo boxes
        lblUserID.setText(stuFaculID);
        lblUserEmail.setText(email);
        lblUserFirstName.setText(firstName);
        lblUserLastName.setText(lastName);
        lblYearLevel.setVisible(true);
        lblProgram.setVisible(true);
        lblUserYearLevel.setVisible(true);
        lblUserProgram.setVisible(true);
        lblDepartment.setVisible(false);
        lblUserDepartment.setVisible(false);
        lblUserYearLevel.setText(yearLevel);
        lblUserProgram.setText(program);
    }

    public void setFacultyInfo(int id, String stuFaculID, String department, String email, String firstName, String lastName) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.department = department;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        lblUserID.setText(stuFaculID);
        lblUserEmail.setText(email);
        lblUserFirstName.setText(firstName);
        lblUserLastName.setText(lastName);
        lblYearLevel.setVisible(false);
        lblProgram.setVisible(false);
        lblUserYearLevel.setVisible(false);
        lblUserProgram.setVisible(false);
        lblDepartment.setVisible(true);
        lblUserDepartment.setVisible(true);
        lblUserDepartment.setText(department);

    }

    public void setAdminInfo(int id, String stuFaculID, String firstName, String lastName, String email, String program, String yearLevel, String department) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
        this.department = department;

        lblUserID.setText(stuFaculID);
        lblUserFirstName.setText(firstName);
        lblUserLastName.setText(lastName);
        lblUserEmail.setText(email);
        lblYearLevel.setVisible(false);
        lblProgram.setVisible(false);
        lblUserYearLevel.setVisible(false);
        lblUserProgram.setVisible(false);
        lblDepartment.setVisible(false);
        lblUserDepartment.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        headerPanel = new computerlabsystem.Design.PanelGradient();
        btnUserInfo = new javax.swing.JLabel();
        btnSettings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cardPanel = new computerlabsystem.Design.PanelGradient();
        userInfoPanel = new computerlabsystem.Design.PanelGradient();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblProgram = new javax.swing.JLabel();
        lblYearLevel = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblUserDepartment = new javax.swing.JLabel();
        lblUserYearLevel = new javax.swing.JLabel();
        lblUserProgram = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblUserLastName = new javax.swing.JLabel();
        lblUserFirstName = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        settingsPanel = new computerlabsystem.Design.PanelGradient();
        lblCurrentPassField = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        newPassField = new javax.swing.JPasswordField();
        reTypePassField = new javax.swing.JPasswordField();
        currentPassField = new javax.swing.JPasswordField();
        lblNewPass = new javax.swing.JLabel();
        lblReTypePass = new javax.swing.JLabel();
        lblWarningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setColorSecondary(new java.awt.Color(255, 204, 0));
        panelGradient1.setLayout(new java.awt.BorderLayout());

        headerPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        headerPanel.setColorSecondary(new java.awt.Color(255, 255, 204));
        headerPanel.setPreferredSize(new java.awt.Dimension(100, 70));

        btnUserInfo.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnUserInfo.setText("User's Information");
        btnUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserInfoMouseClicked(evt);
            }
        });
        headerPanel.add(btnUserInfo);
        btnUserInfo.setBounds(30, 20, 140, 20);

        btnSettings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSettings.setText("Change password");
        btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSettingsMouseClicked(evt);
            }
        });
        headerPanel.add(btnSettings);
        btnSettings.setBounds(210, 20, 150, 20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        headerPanel.add(jLabel1);
        jLabel1.setBounds(370, 0, 60, 20);

        panelGradient1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cardPanel.setLayout(new java.awt.CardLayout());

        userInfoPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        userInfoPanel.setColorSecondary(new java.awt.Color(255, 255, 204));
        userInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(109, 113, 249));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/userIcon.png"))); // NOI18N
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(20, 10, 70, 80);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setText("Email:");
        panelBorder1.add(lblEmail);
        lblEmail.setBounds(80, 170, 32, 16);

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblID.setText("ID:");
        panelBorder1.add(lblID);
        lblID.setBounds(80, 80, 37, 16);

        lblFirstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFirstname.setText("First Name:");
        panelBorder1.add(lblFirstname);
        lblFirstname.setBounds(80, 110, 63, 20);

        lblLastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLastname.setText("Last Name");
        panelBorder1.add(lblLastname);
        lblLastname.setBounds(80, 140, 58, 16);

        lblProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProgram.setText("Program");
        panelBorder1.add(lblProgram);
        lblProgram.setBounds(80, 200, 48, 16);

        lblYearLevel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblYearLevel.setText("Year Level:");
        panelBorder1.add(lblYearLevel);
        lblYearLevel.setBounds(80, 230, 61, 16);

        lblDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDepartment.setText("Department");
        panelBorder1.add(lblDepartment);
        lblDepartment.setBounds(80, 260, 69, 16);

        lblUserDepartment.setText("jLabel3");
        panelBorder1.add(lblUserDepartment);
        lblUserDepartment.setBounds(210, 260, 160, 16);

        lblUserYearLevel.setText("jLabel2");
        panelBorder1.add(lblUserYearLevel);
        lblUserYearLevel.setBounds(210, 230, 160, 16);

        lblUserProgram.setText("jLabel2");
        panelBorder1.add(lblUserProgram);
        lblUserProgram.setBounds(210, 200, 160, 16);

        lblUserEmail.setText("jLabel10");
        panelBorder1.add(lblUserEmail);
        lblUserEmail.setBounds(210, 170, 160, 16);

        lblUserLastName.setText("jLabel8");
        panelBorder1.add(lblUserLastName);
        lblUserLastName.setBounds(210, 140, 160, 16);

        lblUserFirstName.setText("jLabel7");
        panelBorder1.add(lblUserFirstName);
        lblUserFirstName.setBounds(210, 110, 160, 16);

        lblUserID.setText("jLabel6");
        panelBorder1.add(lblUserID);
        lblUserID.setBounds(210, 80, 160, 16);

        userInfoPanel.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 290));

        cardPanel.add(userInfoPanel, "card2");

        settingsPanel.setColorPrimary(new java.awt.Color(109, 113, 249));
        settingsPanel.setColorSecondary(new java.awt.Color(199, 188, 161));

        lblCurrentPassField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCurrentPassField.setText("Current Password");
        settingsPanel.add(lblCurrentPassField);
        lblCurrentPassField.setBounds(10, 50, 120, 20);

        btnSave.setBackground(new java.awt.Color(0, 102, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        settingsPanel.add(btnSave);
        btnSave.setBounds(150, 270, 90, 27);

        newPassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(newPassField);
        newPassField.setBounds(200, 110, 210, 35);

        reTypePassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(reTypePassField);
        reTypePassField.setBounds(200, 180, 210, 35);

        currentPassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(currentPassField);
        currentPassField.setBounds(200, 40, 210, 35);

        lblNewPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNewPass.setText("New Password");
        settingsPanel.add(lblNewPass);
        lblNewPass.setBounds(10, 120, 100, 20);

        lblReTypePass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReTypePass.setText("Re-Type New Password");
        settingsPanel.add(lblReTypePass);
        lblReTypePass.setBounds(10, 190, 160, 20);

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMsg.setText("jLabel2");
        settingsPanel.add(lblWarningMsg);
        lblWarningMsg.setBounds(50, 230, 310, 30);

        cardPanel.add(settingsPanel, "card3");

        panelGradient1.add(cardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 439, 418));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserInfoMouseClicked
        cardPanel.removeAll();
        cardPanel.add(userInfoPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_btnUserInfoMouseClicked

    private void btnSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(settingsPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
        lblWarningMsg.setVisible(false);
    }//GEN-LAST:event_btnSettingsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String currentPass = String.valueOf(currentPassField.getPassword());
        String newPass = String.valueOf(newPassField.getPassword());
        String reTypePass = String.valueOf(reTypePassField.getPassword());

        lblWarningMsg.setVisible(true);
        if (currentPass.isEmpty() && newPass.isEmpty() && reTypePass.isEmpty()) {
            lblWarningMsg.setText("Enter something");
        } else if (currentPass.isEmpty()) {
            lblWarningMsg.setText("Please Input Current Password");
        } else if (newPass.isEmpty()) {
            lblWarningMsg.setText("Please Input the New Password");
        } else if (reTypePass.isEmpty()) {
            lblWarningMsg.setText("Please Input in the Re-type Password");
        } else if (!newPass.equals(reTypePass)) {
            lblWarningMsg.setText("New Password and Re-Type Password doesn't match");
        } else if (newPass.length() < 8) {
            lblWarningMsg.setText("Password should be at least 8 characters long.");
        } else {
            String msg = ComLabMethods.userChangePass(stuFaculID, currentPass, newPass);
            if (msg.equals("Password Changed Successfully")) {
                lblWarningMsg.setText(msg);
            } else {
                lblWarningMsg.setText(msg);
            }
        }

        //userChangePass
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserProfile dialog = new UserProfile(new javax.swing.JFrame(), true);
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

    int id;
    private String stuFaculID, firstName, lastName, role, email, program, yearLevel, department;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel btnSettings;
    private javax.swing.JLabel btnUserInfo;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private javax.swing.JPasswordField currentPassField;
    private computerlabsystem.Design.PanelGradient headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCurrentPassField;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblProgram;
    private javax.swing.JLabel lblReTypePass;
    private javax.swing.JLabel lblUserDepartment;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserFirstName;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUserLastName;
    private javax.swing.JLabel lblUserProgram;
    private javax.swing.JLabel lblUserYearLevel;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JLabel lblYearLevel;
    private javax.swing.JPasswordField newPassField;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JPasswordField reTypePassField;
    private computerlabsystem.Design.PanelGradient settingsPanel;
    private computerlabsystem.Design.PanelGradient userInfoPanel;
    // End of variables declaration//GEN-END:variables
}
