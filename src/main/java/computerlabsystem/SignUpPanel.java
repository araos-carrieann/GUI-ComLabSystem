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
        lblUserAddedSuccessfully.setVisible(false);
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
        List<Data> programList = ComLabMethods.programComboContent();
        comboProgram.removeAllItems(); // Clear existing items

        for (Data data : programList) {
            comboProgram.addItem(data.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        List<Data> yrLvlList = ComLabMethods.yearlvlComboContent();
        comboYrLvl.removeAllItems(); // Clear existing items

        for (Data data : yrLvlList) {
            comboYrLvl.addItem(data.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        List<Data> departmentList = ComLabMethods.departmentComboContent();
        comboDepartment.removeAllItems(); // Clear existing items

        for (Data data : departmentList) {
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
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        checkbxShowPass = new javax.swing.JCheckBox();
        chckbxShowConfirm = new javax.swing.JCheckBox();
        txtEmail = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        fieldConfirmPass = new javax.swing.JPasswordField();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        lblWarningMsg = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox<>();
        txtStudentFacultyID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUserAddedSuccessfully = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signUpPanel.setBackground((new Color(0, 0, 0, 0)));
        signUpPanel.setOpaque(false);
        signUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setBackground((new Color(0, 0, 0, 0)));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-user-30.png")); // NOI18N
        lblUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signUpPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 50, 30));

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        signUpPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 80, -1));

        btnSignIn.setBackground(new java.awt.Color(51, 102, 255));
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignIn.setText("SIGN IN");
        btnSignIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        signUpPanel.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 190, -1));

        btnBackToLogin.setBackground(new java.awt.Color(51, 102, 255));
        btnBackToLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBackToLogin.setText("BACK TO LOGIN");
        btnBackToLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signUpPanel.add(btnBackToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 279, -1));

        txtFname.setBackground((new Color(0, 0, 0, 0)));
        txtFname.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtFname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtFname.setPreferredSize(new java.awt.Dimension(90, 22));
        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });
        signUpPanel.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 40));

        txtLname.setBackground((new Color(0, 0, 0, 0)));
        txtLname.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtLname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtLname.setPreferredSize(new java.awt.Dimension(90, 22));
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        signUpPanel.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 112, 130, 40));

        checkbxShowPass.setBackground((new Color(0, 0, 0, 0)));
        checkbxShowPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkbxShowPass.setBorderPainted(true);
        checkbxShowPass.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-eye-20.png")); // NOI18N
        checkbxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbxShowPassActionPerformed(evt);
            }
        });
        signUpPanel.add(checkbxShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 214, -1, 30));

        chckbxShowConfirm.setBackground((new Color(0, 0, 0, 0)));
        chckbxShowConfirm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chckbxShowConfirm.setBorderPainted(true);
        chckbxShowConfirm.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-eye-20.png")); // NOI18N
        chckbxShowConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxShowConfirmActionPerformed(evt);
            }
        });
        signUpPanel.add(chckbxShowConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, 30));

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

        fieldConfirmPass.setBackground((new Color(0, 0, 0, 0)));
        fieldConfirmPass.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        fieldConfirmPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldConfirmPass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        fieldConfirmPass.setPreferredSize(new java.awt.Dimension(90, 22));
        fieldConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConfirmPassActionPerformed(evt);
            }
        });
        signUpPanel.add(fieldConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 290, 40));

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

        comboProgram.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        comboProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramActionPerformed(evt);
            }
        });
        signUpPanel.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, -1));

        comboYrLvl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        signUpPanel.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 120, -1));

        lblWarningMsg.setBackground((new Color(0, 0, 0, 0)));
        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-error-24.png")); // NOI18N
        lblWarningMsg.setText("jLabel1");
        signUpPanel.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 366, -1));

        comboDepartment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-id-30.png")); // NOI18N
        signUpPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-email-30.png")); // NOI18N
        signUpPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-check-lock-30.png")); // NOI18N
        signUpPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-password-30.png")); // NOI18N
        signUpPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        lblUserAddedSuccessfully.setBackground((new Color(0, 0, 0, 0)));
        lblUserAddedSuccessfully.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserAddedSuccessfully.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-verified-24.png")); // NOI18N
        lblUserAddedSuccessfully.setText("jLabel1");
        signUpPanel.add(lblUserAddedSuccessfully, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 366, -1));

        add(signUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboDepartment.setVisible(false);
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentFacultyID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtEmail.setText("");
        fieldPassword.setText("");
        fieldConfirmPass.setText("");
        btnGrp.clearSelection();
        //combo box set the selected in index zero
    }//GEN-LAST:event_btnClearActionPerformed

    private void checkbxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbxShowPassActionPerformed
        if (checkbxShowPass.isSelected()) {
            fieldPassword.setEchoChar((char) 0);
        } else {
            fieldPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbxShowPassActionPerformed

    private void chckbxShowConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxShowConfirmActionPerformed
        if (chckbxShowConfirm.isSelected()) {
            fieldConfirmPass.setEchoChar((char) 0);
        } else {
            fieldConfirmPass.setEchoChar('*');
        }
    }//GEN-LAST:event_chckbxShowConfirmActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        role = null;
        studentFacultyID = txtStudentFacultyID.getText();
        firstName = txtFname.getText();
        lastName = txtLname.getText();
        email = txtEmail.getText();
        pass = String.valueOf(fieldPassword.getPassword());
        confirmPass = String.valueOf(fieldPassword.getPassword());

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
        } else if (!firstName.matches("[A-Za-z0-9\\-.]+") || !lastName.matches("[A-Za-z0-9\\-.]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, or dots.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else {
            if (rbtnStudent.isSelected()) {
                program = (String) comboProgram.getSelectedItem();
                yearLevel = (String) comboYrLvl.getSelectedItem();
                if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your program/year level.");
                }
                role = rbtnStudent.getText();
                department = null;
            } else {
                role = rbtnFaculty.getText();
                department = (String) comboDepartment.getSelectedItem();
                if (department.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your Department.");
                }
                program = null;
                yearLevel = null;
            }
            status = "ACTIVE";
            String hashedPassword = ComLabMethods.hashPassword(pass);
            String msg = ComLabMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, hashedPassword, program, yearLevel, department);
            btnSignIn.setEnabled(false);
            btnClear.setEnabled(false);
            lblWarningMsg.setVisible(false);
            lblUserAddedSuccessfully.setVisible(true);
            lblUserAddedSuccessfully.setText(msg);
            System.out.println("pogiiiii");
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboDepartment.setVisible(true);
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

    private void txtStudentFacultyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentFacultyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentFacultyIDActionPerformed

    private void fieldConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldConfirmPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldConfirmPassActionPerformed

    private void comboProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramActionPerformed

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private String studentFacultyID, status, firstName, lastName, role, email, pass, confirmPass, program, yearLevel, department;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JCheckBox chckbxShowConfirm;
    private javax.swing.JCheckBox checkbxShowPass;
    private javax.swing.JComboBox<String> comboDepartment;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JPasswordField fieldConfirmPass;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblUserAddedSuccessfully;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
