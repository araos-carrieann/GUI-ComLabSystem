/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author araos
 */
public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpPanel
     */
    public SignUpPanel() {
        initComponents();
        lblWarningMsg.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        comboDepartment.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();
        insertContentComboDepartment();
    }

    public void addEventBackLogin(ActionListener event) {
        btnBackToLogin.addActionListener(event);
    }

    private void insertContentComboProgram() {
        List<AccountDTO> programList = ComLabMethods.programComboContent();
        comboProgram.removeAllItems(); // Clear existing items

        for (AccountDTO data : programList) {
            comboProgram.addItem(data.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        List<AccountDTO> yrLvlList = ComLabMethods.yearlvlComboContent();
        comboYrLvl.removeAllItems(); // Clear existing items

        for (AccountDTO data : yrLvlList) {
            comboYrLvl.addItem(data.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        List<AccountDTO> departmentList = ComLabMethods.departmentComboContent();
        comboDepartment.removeAllItems(); // Clear existing items

        for (AccountDTO data : departmentList) {
            comboDepartment.addItem(data.getDepartment());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        signUpPanel = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        checkboxShowPass = new javax.swing.JCheckBox();
        checkboxShowConfirm = new javax.swing.JCheckBox();
        txtEmail = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        fieldConfirmPassword = new javax.swing.JPasswordField();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        lblWarningMsg = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox<>();
        txtStudentFacultyID = new javax.swing.JTextField();
        lblUserID = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblCreatePassword = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signUpPanel.setBackground((new Color(0, 0, 0, 0)));
        signUpPanel.setOpaque(false);
        signUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setBackground((new Color(0, 0, 0, 0)));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-30.png"))); // NOI18N
        lblUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signUpPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 50, 30));

        btnClear.setBackground(new java.awt.Color(51, 51, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        signUpPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 80, -1));

        btnSignIn.setBackground(new java.awt.Color(51, 51, 255));
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignIn.setText("SIGN IN");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        signUpPanel.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 190, -1));

        btnBackToLogin.setBackground(new java.awt.Color(51, 51, 255));
        btnBackToLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBackToLogin.setText("BACK TO LOGIN");
        signUpPanel.add(btnBackToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 279, -1));

        txtFirstName.setBackground((new Color(0, 0, 0, 0)));
        txtFirstName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtFirstName.setPreferredSize(new java.awt.Dimension(90, 22));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        signUpPanel.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 40));

        txtLastName.setBackground((new Color(0, 0, 0, 0)));
        txtLastName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtLastName.setPreferredSize(new java.awt.Dimension(90, 22));
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        signUpPanel.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 112, 130, 40));

        checkboxShowPass.setBackground((new Color(0, 0, 0, 0)));
        checkboxShowPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkboxShowPass.setBorderPainted(true);
        checkboxShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png"))); // NOI18N
        checkboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowPassActionPerformed(evt);
            }
        });
        signUpPanel.add(checkboxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 214, -1, 30));

        checkboxShowConfirm.setBackground((new Color(0, 0, 0, 0)));
        checkboxShowConfirm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkboxShowConfirm.setBorderPainted(true);
        checkboxShowConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hide-20.png"))); // NOI18N
        checkboxShowConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxShowConfirmActionPerformed(evt);
            }
        });
        signUpPanel.add(checkboxShowConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, 30));

        txtEmail.setBackground((new Color(0, 0, 0, 0)));
        txtEmail.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtEmail.setPreferredSize(new java.awt.Dimension(90, 22));
        signUpPanel.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 290, 40));

        fieldPassword.setBackground((new Color(0, 0, 0, 0)));
        fieldPassword.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        fieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        fieldPassword.setPreferredSize(new java.awt.Dimension(90, 22));
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });
        signUpPanel.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 290, 40));

        fieldConfirmPassword.setBackground((new Color(0, 0, 0, 0)));
        fieldConfirmPassword.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        fieldConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldConfirmPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        fieldConfirmPassword.setPreferredSize(new java.awt.Dimension(90, 22));
        fieldConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConfirmPasswordActionPerformed(evt);
            }
        });
        signUpPanel.add(fieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 290, 40));

        rbtnStudent.setBackground((new Color(0, 0, 0, 0)));
        btnGrp.add(rbtnStudent);
        rbtnStudent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });
        signUpPanel.add(rbtnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        rbtnFaculty.setBackground((new Color(0, 0, 0, 0)));
        btnGrp.add(rbtnFaculty);
        rbtnFaculty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });
        signUpPanel.add(rbtnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        comboProgram.setBackground(new java.awt.Color(255, 255, 204));
        comboProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramActionPerformed(evt);
            }
        });
        signUpPanel.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, -1));

        comboYrLvl.setBackground(new java.awt.Color(255, 255, 204));
        comboYrLvl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        signUpPanel.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 120, -1));

        lblWarningMsg.setBackground((new Color(0, 0, 0, 0)));
        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMsg.setText("jLabel1");
        signUpPanel.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 510, 450, -1));

        comboDepartment.setBackground(new java.awt.Color(255, 255, 204));
        signUpPanel.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 190, -1));

        txtStudentFacultyID.setBackground((new Color(0, 0, 0, 0)));
        txtStudentFacultyID.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtStudentFacultyID.setPreferredSize(new java.awt.Dimension(90, 22));
        txtStudentFacultyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentFacultyIDActionPerformed(evt);
            }
        });
        signUpPanel.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 290, 40));

        lblUserID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-30.png"))); // NOI18N
        signUpPanel.add(lblUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-30.png"))); // NOI18N
        signUpPanel.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-check-lock-30.png"))); // NOI18N
        signUpPanel.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-password-30.png"))); // NOI18N
        signUpPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        lblCreatePassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCreatePassword.setText("Create an account");
        signUpPanel.add(lblCreatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 160, 40));

        add(signUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboDepartment.setVisible(false);

    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentFacultyID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        fieldPassword.setText("");
        fieldConfirmPassword.setText("");
        btnGrp.clearSelection();
        comboDepartment.setVisible(false);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_btnClearActionPerformed

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

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        status = "ACTIVE";
        role = null;
        code = null;
        studentFacultyID = txtStudentFacultyID.getText();
        firstName = txtFirstName.getText();
        lastName = txtLastName.getText();
        email = txtEmail.getText();
        pass = String.valueOf(fieldPassword.getPassword());
        confirmPass = String.valueOf(fieldPassword.getPassword());
        program = (String) comboProgram.getSelectedItem();
        yearLevel = (String) comboYrLvl.getSelectedItem();
        department = (String) comboDepartment.getSelectedItem();

        lblWarningMsg.setVisible(true);
        if (studentFacultyID.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && email.isEmpty() && pass.isEmpty() && confirmPass.isEmpty() && !rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Please input all required fields.");
        } else if (studentFacultyID.isEmpty()) {
            lblWarningMsg.setText("Please Specify your ID");
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
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
        } else if (!firstName.matches("[A-Za-z0-9\\-. ]+") || !lastName.matches("[A-Za-z0-9\\-. ]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, dots, or spaces.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else {
            String hashedPassword = ComLabMethods.hashPassword(pass);
            if (rbtnStudent.isSelected()) {
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                } else {
                    role = rbtnStudent.getText();
                    department = null;
                    String msg = ComLabMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, hashedPassword, program, yearLevel, department, code);
                    lblWarningMsg.setText(msg);
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                    btnSignIn.setEnabled(false);
                    btnClear.setEnabled(false);
                    System.out.println("pogiiiii");
                }
            } else if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                if (department.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your Department.");
                } else {
                    program = null;
                    yearLevel = null;
                    String msg = ComLabMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, hashedPassword, program, yearLevel, department, code);
                    lblWarningMsg.setText(msg);
                    lblWarningMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-verified-24.png")));
                    btnSignIn.setEnabled(false);
                    btnClear.setEnabled(false);
                    System.out.println("pogiiiii");
                }
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboDepartment.setVisible(true);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

    private void txtStudentFacultyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentFacultyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentFacultyIDActionPerformed

    private void fieldConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldConfirmPasswordActionPerformed

    private void comboProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramActionPerformed

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private String studentFacultyID, status, firstName, lastName, role, email, pass, confirmPass, program, yearLevel, department, code;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JCheckBox checkboxShowConfirm;
    private javax.swing.JCheckBox checkboxShowPass;
    private javax.swing.JComboBox<String> comboDepartment;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JPasswordField fieldConfirmPassword;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCreatePassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
