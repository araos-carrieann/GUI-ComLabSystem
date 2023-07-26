/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.util.List;

/**
 *
 * @author araos
 */
public class AddAccount extends javax.swing.JDialog {

    /**
     * Creates new form Add
     */
    public AddAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblWarningMsg.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        comboDepartment.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();
        insertContentComboDepartment();

    }

    private void insertContentComboProgram() {
        List<DTOaccount> programList = ComLabMethods.programComboContent();
        comboProgram.removeAllItems(); // Clear existing items

        for (DTOaccount data : programList) {
            comboProgram.addItem(data.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        List<DTOaccount> yrLvlList = ComLabMethods.yearlvlComboContent();
        comboYrLvl.removeAllItems(); // Clear existing items

        for (DTOaccount data : yrLvlList) {
            comboYrLvl.addItem(data.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        List<DTOaccount> departmentList = ComLabMethods.departmentComboContent();
        comboDepartment.removeAllItems(); // Clear existing items

        for (DTOaccount data : departmentList) {
            comboDepartment.addItem(data.getDepartment());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        panelGradient2 = new computerlabsystem.Design.PanelGradient();
        lblStudentFacultyID = new javax.swing.JLabel();
        txtStudentFacultyID = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        checkboxShowPass = new javax.swing.JCheckBox();
        fieldPassword = new javax.swing.JPasswordField();
        lblConfirmPass = new javax.swing.JLabel();
        checkboxShowConfirm = new javax.swing.JCheckBox();
        fieldConfirmPassword = new javax.swing.JPasswordField();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        comboDepartment = new javax.swing.JComboBox<>();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        panelGradient2.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStudentFacultyID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-30.png"))); // NOI18N
        panelGradient2.add(lblStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtStudentFacultyID.setMinimumSize(new java.awt.Dimension(65, 40));
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(65, 40));
        panelGradient2.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 290, 40));

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-30.png"))); // NOI18N
        panelGradient2.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        txtFname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient2.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 130, 40));

        txtLname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        panelGradient2.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 140, 40));

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-30.png"))); // NOI18N
        panelGradient2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtEmail.setMinimumSize(new java.awt.Dimension(65, 40));
        txtEmail.setPreferredSize(new java.awt.Dimension(65, 40));
        panelGradient2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 290, 40));

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-password-30.png"))); // NOI18N
        panelGradient2.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png"))); // NOI18N
        checkboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPassActionPerformed(evt);
            }
        });
        panelGradient2.add(checkboxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 30, 30));

        fieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        fieldPassword.setMinimumSize(new java.awt.Dimension(65, 40));
        fieldPassword.setPreferredSize(new java.awt.Dimension(65, 40));
        panelGradient2.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 290, 40));

        lblConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-check-lock-30.png"))); // NOI18N
        panelGradient2.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        checkboxShowConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png"))); // NOI18N
        checkboxShowConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowConfirmActionPerformed(evt);
            }
        });
        panelGradient2.add(checkboxShowConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 30, 40));

        fieldConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldConfirmPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        fieldConfirmPassword.setMinimumSize(new java.awt.Dimension(65, 40));
        fieldConfirmPassword.setPreferredSize(new java.awt.Dimension(65, 40));
        panelGradient2.add(fieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 290, 40));

        panelGradient2.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 140, 30));

        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        panelGradient2.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 150, 30));

        panelGradient2.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 180, 30));

        btnGrp.add(rbtnStudent);
        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });
        panelGradient2.add(rbtnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, 30));

        btnGrp.add(rbtnFaculty);
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });
        panelGradient2.add(rbtnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, 30));

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelGradient2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 180, 30));

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelGradient2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 280, 30));

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 90, -1));

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMsg.setText("jLabel1");
        panelGradient2.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 290, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboDepartment.setVisible(false);
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboDepartment.setVisible(true);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentFacultyID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtEmail.setText("");
        fieldPassword.setText("");
        fieldConfirmPassword.setText("");
        rbtnStudent.setSelected(false);
        rbtnFaculty.setSelected(false);
        //combo box set the selected in index zero
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        status = "ACTIVE";
        role = null;
        code = null;
        stuFaculID = txtStudentFacultyID.getText();
        fname = txtFname.getText();
        lname = txtLname.getText();
        email = txtEmail.getText();
        pass = String.valueOf(fieldPassword.getPassword());
        confirmPass = String.valueOf(fieldPassword.getPassword());
        program = (String) comboProgram.getSelectedItem();
        yearLevel = (String) comboYrLvl.getSelectedItem();
        department = (String) comboDepartment.getSelectedItem();

        lblWarningMsg.setVisible(true);
        if (stuFaculID.isEmpty() && fname.isEmpty() && lname.isEmpty() && email.isEmpty() && pass.isEmpty() && confirmPass.isEmpty() && !rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Please input all required fields.");
        } else if (stuFaculID.isEmpty()) {
            lblWarningMsg.setText("Please Specify your ID");
        } else if (fname.isEmpty() || lname.isEmpty()) {
            lblWarningMsg.setText("Please specify your name.");
        } else if (email.isEmpty()) {
            lblWarningMsg.setText("Please input your email.");
        } else if (pass.isEmpty()) {
            lblWarningMsg.setText("Please input your password.");
        } else if (confirmPass.isEmpty()) {
            lblWarningMsg.setText("Please input the confirmation password.");
        } else if (!pass.equals(confirmPass)) {
            lblWarningMsg.setText("Your password and confirmation password don't match.");
        } else if (pass.length() < 8) {
            lblWarningMsg.setText("Password should be at least 8 characters long.");
        } else if (!fname.matches("[A-Za-z0-9\\-.]+") || !lname.matches("[A-Za-z0-9\\-.]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, or dots.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else {
            String hashedPassword = ComLabMethods.hashPassword(pass);
            if (rbtnStudent.isSelected()) {
                role = rbtnStudent.getText();
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                } else {
                    department = null;
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                    String msg = ComLabMethods.registerUser(status, role, stuFaculID, fname, lname, email, hashedPassword, program, yearLevel, department, code);
                    lblWarningMsg.setText(msg);
                }
            }
            if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                if (department.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your Department.");
                } else {
                    program = null;
                    yearLevel = null;
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                    String msg = ComLabMethods.registerUser(status, role, stuFaculID, fname, lname, email, hashedPassword, program, yearLevel, department, code);
                    lblWarningMsg.setText(msg);
                }
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void checkboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowPassActionPerformed
        if (checkboxShowPass.isSelected()) {
            checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-eye-20.png")));
            fieldPassword.setEchoChar((char) 0);
        } else {
            checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png")));
            fieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkboxShowPassActionPerformed

    private void checkboxShowConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxShowConfirmActionPerformed
        if (checkboxShowConfirm.isSelected()) {
            checkboxShowConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-eye-20.png")));
            fieldConfirmPassword.setEchoChar((char) 0);
        } else {
            checkboxShowConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png")));
            fieldConfirmPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkboxShowConfirmActionPerformed

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private String stuFaculID, status, fname, lname, role, email, pass, confirmPass, program, yearLevel, department, code;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox checkboxShowConfirm;
    private javax.swing.JCheckBox checkboxShowPass;
    private javax.swing.JComboBox<String> comboDepartment;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JPasswordField fieldConfirmPassword;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblStudentFacultyID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private computerlabsystem.Design.PanelGradient panelGradient2;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
