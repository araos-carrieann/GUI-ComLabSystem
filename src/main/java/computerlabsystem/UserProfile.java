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
        if (!program.equals("null")) {
            lblProgram.setVisible(true);
            lblUserProgram.setVisible(true);
            lblUserProgram.setText(program);
        }
        if (!yearLevel.equals("null")) {
            lblYearLevel.setVisible(true);
            lblUserYearLevel.setVisible(true);
            lblUserYearLevel.setText(yearLevel);
        }

        if (!department.equals("null")) {
            lblDepartment.setVisible(true);
            lblUserDepartment.setVisible(true);
            lblUserDepartment.setText(department);
        }

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
        lblID = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        lblUserFirstName = new javax.swing.JLabel();
        lblUserLastName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblProgram = new javax.swing.JLabel();
        lblYearLevel = new javax.swing.JLabel();
        lblUserProgram = new javax.swing.JLabel();
        lblUserYearLevel = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblUserDepartment = new javax.swing.JLabel();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel1.setBounds(420, 10, 50, 20);

        panelGradient1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cardPanel.setLayout(new java.awt.CardLayout());

        userInfoPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        userInfoPanel.setColorSecondary(new java.awt.Color(255, 255, 204));
        userInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblID.setText("ID:");
        userInfoPanel.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 37, -1));

        lblFirstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFirstname.setText("First Name:");
        userInfoPanel.add(lblFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 20));

        lblLastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLastname.setText("Last Name");
        userInfoPanel.add(lblLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        lblUserID.setText("jLabel6");
        userInfoPanel.add(lblUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        lblUserFirstName.setText("jLabel7");
        userInfoPanel.add(lblUserFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        lblUserLastName.setText("jLabel8");
        userInfoPanel.add(lblUserLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setText("Email:");
        userInfoPanel.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        lblUserEmail.setText("jLabel10");
        userInfoPanel.add(lblUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        lblProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProgram.setText("Program");
        userInfoPanel.add(lblProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        lblYearLevel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblYearLevel.setText("Year Level:");
        userInfoPanel.add(lblYearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        lblUserProgram.setText("jLabel2");
        userInfoPanel.add(lblUserProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        lblUserYearLevel.setText("jLabel2");
        userInfoPanel.add(lblUserYearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        lblDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDepartment.setText("Department");
        userInfoPanel.add(lblDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        lblUserDepartment.setText("jLabel3");
        userInfoPanel.add(lblUserDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        panelBorder1.setBackground(new java.awt.Color(109, 113, 249));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/userIcon.png"))); // NOI18N
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(20, 10, 70, 80);

        userInfoPanel.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 260));

        cardPanel.add(userInfoPanel, "card2");

        settingsPanel.setColorPrimary(new java.awt.Color(109, 113, 249));
        settingsPanel.setColorSecondary(new java.awt.Color(199, 188, 161));

        lblCurrentPassField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCurrentPassField.setText("Current Password");
        settingsPanel.add(lblCurrentPassField);
        lblCurrentPassField.setBounds(20, 50, 140, 20);

        btnSave.setBackground(new java.awt.Color(0, 102, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        settingsPanel.add(btnSave);
        btnSave.setBounds(175, 260, 90, 27);

        newPassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(newPassField);
        newPassField.setBounds(210, 110, 210, 35);

        reTypePassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(reTypePassField);
        reTypePassField.setBounds(210, 180, 210, 35);

        currentPassField.setBorder(new javax.swing.border.MatteBorder(null));
        settingsPanel.add(currentPassField);
        currentPassField.setBounds(210, 42, 210, 35);

        lblNewPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNewPass.setText("New Password");
        settingsPanel.add(lblNewPass);
        lblNewPass.setBounds(20, 120, 120, 20);

        lblReTypePass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReTypePass.setText("Re-Type New Password");
        settingsPanel.add(lblReTypePass);
        lblReTypePass.setBounds(20, 190, 180, 20);

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMsg.setText("jLabel2");
        settingsPanel.add(lblWarningMsg);
        lblWarningMsg.setBounds(90, 216, 310, 30);

        cardPanel.add(settingsPanel, "card3");

        panelGradient1.add(cardPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

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
    }//GEN-LAST:event_btnSettingsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String currentPass = String.valueOf(currentPassField.getPassword());
        String newPass = String.valueOf(newPassField.getPassword());
        String reTypePass = String.valueOf(reTypePassField.getPassword());

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
