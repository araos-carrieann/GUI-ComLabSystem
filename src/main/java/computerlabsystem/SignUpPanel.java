/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package computerlabsystem;

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
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        fieldConfirmPass = new javax.swing.JPasswordField();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        comboProgram = new javax.swing.JComboBox<>();
        comboYrLvl = new javax.swing.JComboBox<>();
        checkbxShowPass = new javax.swing.JCheckBox();
        chckbxShowConfirm = new javax.swing.JCheckBox();
        lblWarningMsg = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox<>();
        lblStudentFacultyID = new javax.swing.JLabel();
        txtStudentFacultyID = new javax.swing.JTextField();

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-email-48.png")); // NOI18N

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmPass.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-good-pincode-50.png")); // NOI18N

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSignIn.setText("SIGN IN");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        btnBackToLogin.setText("BACK TO LOGIN");

        txtFname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFname.setText("First Name");
        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });

        txtLname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLname.setText("Last Name");
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setText("EMAIL");

        fieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPassword.setText("jPasswordField1");
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });

        fieldConfirmPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldConfirmPass.setText("jPasswordField2");
        fieldConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConfirmPassActionPerformed(evt);
            }
        });

        btnGrp.add(rbtnStudent);
        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });

        btnGrp.add(rbtnFaculty);
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });

        comboProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramActionPerformed(evt);
            }
        });

        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });

        checkbxShowPass.setText("Show");
        checkbxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbxShowPassActionPerformed(evt);
            }
        });

        chckbxShowConfirm.setText("Show");
        chckbxShowConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxShowConfirmActionPerformed(evt);
            }
        });

        lblWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWarningMsg.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-error-24.png")); // NOI18N
        lblWarningMsg.setText("jLabel1");

        lblStudentFacultyID.setText("Student/Faculty ID");

        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setText("Student/Faculty ID");
        txtStudentFacultyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentFacultyIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblConfirmPass)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbxShowPass)
                    .addComponent(chckbxShowConfirm)))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(rbtnStudent)
                .addGap(98, 98, 98)
                .addComponent(rbtnFaculty))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(comboProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(comboYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblWarningMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentFacultyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(fieldConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(checkbxShowPass)
                        .addGap(30, 30, 30)
                        .addComponent(chckbxShowConfirm)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnStudent)
                    .addComponent(rbtnFaculty))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSignIn)
                .addGap(7, 7, 7)
                .addComponent(btnClear)
                .addGap(7, 7, 7)
                .addComponent(btnBackToLogin)
                .addGap(7, 7, 7)
                .addComponent(lblWarningMsg))
        );
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
        } else if (!firstName.matches("[A-Za-z0-9\\-.]+") || !lastName.matches("[A-Za-z0-9\\-.]+")) {
            lblWarningMsg.setText("Name should only consist of letters, numbers, dashes, or dots.");
        } else if (!email.matches("[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
            lblWarningMsg.setText("Invalid email address format.");
        } else if (program.equals("DEFAULT") || yearLevel.equals("DEFAULT")) {
            lblWarningMsg.setText("Please specify your program/year level.");
        } else if (department.equals("DEFAULT")) {
            lblWarningMsg.setText("Please specify your Department.");
        } else {
            if (rbtnStudent.isSelected()) {
                role = rbtnStudent.getText();
                department = null;
            } else {
                role = rbtnFaculty.getText();
                program = null;
                yearLevel = null;
            }
            status = "ACTIVE";
            String hashedPassword = ComLabMethods.hashPassword(pass);
            String msg = ComLabMethods.registerUser(status, role, studentFacultyID, firstName, lastName, email, hashedPassword, program, yearLevel, department);
            lblWarningMsg.setText(msg);
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
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblStudentFacultyID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
