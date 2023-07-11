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
        this.fname = firstName;
        this.lname = lastName;
        this.program = program;
        this.yearLevel = yearLevel;

        // Set the values to the corresponding text fields or combo boxes
        lblUserID.setText(stuFaculID);
        lblUserEmail.setText(email);
        lblUserFirstName.setText(fname);
        lblUserLastName.setText(lname);
        lblYearLevel.setVisible(true);
        lblProgram.setVisible(true);
        lblUserYearLevel.setVisible(true);
        lblUserProgram.setVisible(true);
        lblDepartment.setVisible(false);
        lblUserDepartment.setVisible(false);
        lblUserYearLevel.setText(program);
        lblUserProgram.setText(yearLevel);
    }

    public void setFacultyInfo(int id, String stuFaculID, String department, String email, String firstName, String lastName) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.department = department;
        this.email = email;
        this.fname = firstName;
        this.lname = lastName;

        lblUserID.setText(stuFaculID);
        lblUserEmail.setText(email);
        lblUserFirstName.setText(fname);
        lblUserLastName.setText(lname);
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
        this.department = department;
        this.email = email;
        this.fname = firstName;
        this.lname = lastName;
        this.program = program;
        this.yearLevel = yearLevel;

        lblUserID.setText(stuFaculID);
        lblUserEmail.setText(email);
        lblUserFirstName.setText(fname);
        lblUserLastName.setText(lname);
        lblYearLevel.setVisible(true);
        lblProgram.setVisible(true);
        lblUserYearLevel.setVisible(true);
        lblUserProgram.setVisible(true);
        lblDepartment.setVisible(true);
        lblUserDepartment.setVisible(true);
        lblUserDepartment.setText(department);

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

        headerPanel.setColorPrimary(new java.awt.Color(0, 255, 204));
        headerPanel.setPreferredSize(new java.awt.Dimension(100, 50));

        btnUserInfo.setText("User Info");
        btnUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserInfoMouseClicked(evt);
            }
        });
        headerPanel.add(btnUserInfo);
        btnUserInfo.setBounds(50, 10, 80, 16);

        btnSettings.setText("Change Pass");
        btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSettingsMouseClicked(evt);
            }
        });
        headerPanel.add(btnSettings);
        btnSettings.setBounds(130, 10, 90, 16);

        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        headerPanel.add(jLabel1);
        jLabel1.setBounds(320, 20, 25, 16);

        panelGradient1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cardPanel.setLayout(new java.awt.CardLayout());

        userInfoPanel.setColorSecondary(new java.awt.Color(0, 102, 102));

        lblID.setText("ID:");

        lblFirstname.setText("FIRST NAME:");

        lblLastname.setText("LAST NAME");

        lblUserID.setText("jLabel6");

        lblUserFirstName.setText("jLabel7");

        lblUserLastName.setText("jLabel8");

        lblEmail.setText("EMAIL:");

        lblUserEmail.setText("jLabel10");

        lblProgram.setText("PROGRAM:");

        lblYearLevel.setText("YEAR LEVEL:");

        lblUserProgram.setText("jLabel2");

        lblUserYearLevel.setText("jLabel2");

        lblDepartment.setText("DEPARTMENT");

        lblUserDepartment.setText("jLabel3");

        userInfoPanel.setLayer(lblID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblFirstname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblLastname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserLastName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblProgram, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblYearLevel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserProgram, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserYearLevel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblDepartment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        userInfoPanel.setLayer(lblUserDepartment, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserID)
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFirstname)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblYearLevel)
                                        .addComponent(lblLastname)))
                                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblUserFirstName)
                                            .addComponent(lblUserLastName)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInfoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblUserYearLevel))))))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUserEmail))
                            .addGroup(userInfoPanelLayout.createSequentialGroup()
                                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProgram)
                                    .addComponent(lblDepartment))
                                .addGap(77, 77, 77)
                                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUserDepartment)
                                    .addComponent(lblUserProgram))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblUserID))
                .addGap(29, 29, 29)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(lblUserFirstName))
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblLastname))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblUserLastName)))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(lblUserEmail))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgram)
                    .addComponent(lblUserProgram))
                .addGap(18, 18, 18)
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYearLevel)
                    .addComponent(lblUserYearLevel))
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDepartment))
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblUserDepartment)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cardPanel.add(userInfoPanel, "card2");

        settingsPanel.setColorPrimary(new java.awt.Color(255, 51, 102));

        lblCurrentPassField.setText("CURRENT PASSWORD");
        settingsPanel.add(lblCurrentPassField);
        lblCurrentPassField.setBounds(60, 60, 116, 16);

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        settingsPanel.add(btnSave);
        btnSave.setBounds(130, 260, 72, 23);
        settingsPanel.add(newPassField);
        newPassField.setBounds(200, 120, 120, 22);
        settingsPanel.add(reTypePassField);
        reTypePassField.setBounds(200, 180, 120, 22);
        settingsPanel.add(currentPassField);
        currentPassField.setBounds(200, 60, 120, 22);

        lblNewPass.setText("NEW PASSWORD");
        settingsPanel.add(lblNewPass);
        lblNewPass.setBounds(60, 120, 91, 16);

        lblReTypePass.setText("RE-TYPE NEW PASSWORD");
        settingsPanel.add(lblReTypePass);
        lblReTypePass.setBounds(50, 180, 140, 16);

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setText("jLabel2");
        settingsPanel.add(lblWarningMsg);
        lblWarningMsg.setBounds(20, 220, 360, 16);

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
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private String stuFaculID, fname, lname, role, email, program, yearLevel, department;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel btnSettings;
    private javax.swing.JLabel btnUserInfo;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private javax.swing.JPasswordField currentPassField;
    private computerlabsystem.Design.PanelGradient headerPanel;
    private javax.swing.JLabel jLabel1;
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
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JPasswordField reTypePassField;
    private computerlabsystem.Design.PanelGradient settingsPanel;
    private computerlabsystem.Design.PanelGradient userInfoPanel;
    // End of variables declaration//GEN-END:variables
}
