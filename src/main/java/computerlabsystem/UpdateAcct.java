/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.util.List;
import javax.swing.JRadioButton;

/**
 *
 * @author araos
 */
public class UpdateAcct extends javax.swing.JDialog {

    /**
     * Creates new form UpdateStudent
     */
    public UpdateAcct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        comboDepartment.setVisible(false);
        insertContentComboProgram();
        insertContentComboYearLvl();
        insertContentComboDepartment();

    }

    public void setStudentData(int id, String stuFaculID, String email, String firstName, String lastName, String program, String yearLevel) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.yearLevel = yearLevel;

        // Set the values to the corresponding text fields or combo boxes
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
        rbtnStudent.setSelected(true);
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboProgram.setSelectedItem(program);
        comboYrLvl.setSelectedItem(yearLevel);
    }

    public void setFacultyData(int id, String stuFaculID, String department, String email, String firstName, String lastName) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.department = department;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        // Set the values to the corresponding text fields or combo boxes
        rbtnFaculty.setSelected(true);
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
        comboDepartment.setVisible(true);
        comboDepartment.setSelectedItem(department);
    }

    public void setAdminData(int id, String stuFaculID, String email, String firstName, String lastName) {
        this.id = id;
        this.stuFaculID = stuFaculID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        // Set the values to the corresponding text fields or combo boxes
        rbtnAdmin.setSelected(true);
        txtStudentFacultyID.setText(stuFaculID);
        txtEmail.setText(email);
        txtFirstName.setText(this.firstName);
        txtLastName.setText(this.lastName);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        lblStudentFacultyID = new javax.swing.JLabel();
        txtStudentFacultyID = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        comboProgram = new javax.swing.JComboBox<>();
        comboDepartment = new javax.swing.JComboBox<>();
        rbtnStudent = new javax.swing.JRadioButton();
        rbtnFaculty = new javax.swing.JRadioButton();
        rbtnAdmin = new javax.swing.JRadioButton();
        comboYrLvl = new javax.swing.JComboBox<>();
        saveChanges = new javax.swing.JButton();
        lblWarningMsg = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGradient1.add(lblStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtStudentFacultyID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStudentFacultyID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "STUDENT / FACULTY ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtStudentFacultyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 310, -1));

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelGradient1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "FIRST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, -1));

        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        panelGradient1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 150, 40));

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelGradient1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 310, -1));

        panelGradient1.add(comboProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 130, -1));

        panelGradient1.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 170, -1));

        buttonGroup1.add(rbtnStudent);
        rbtnStudent.setText("STUDENT");
        rbtnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStudentActionPerformed(evt);
            }
        });
        panelGradient1.add(rbtnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        buttonGroup1.add(rbtnFaculty);
        rbtnFaculty.setText("FACULTY");
        rbtnFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacultyActionPerformed(evt);
            }
        });
        panelGradient1.add(rbtnFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        buttonGroup1.add(rbtnAdmin);
        rbtnAdmin.setText("ADMIN");
        rbtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAdminActionPerformed(evt);
            }
        });
        panelGradient1.add(rbtnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        comboYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYrLvlActionPerformed(evt);
            }
        });
        panelGradient1.add(comboYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, -1));

        saveChanges.setBackground(new java.awt.Color(0, 102, 255));
        saveChanges.setText("SAVE");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });
        panelGradient1.add(saveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 110, -1));

        lblWarningMsg.setText("jLabel1");
        panelGradient1.add(lblWarningMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        btnBack.setBackground(new java.awt.Color(0, 102, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 110, -1));

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void comboYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYrLvlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYrLvlActionPerformed

    private void rbtnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStudentActionPerformed
        comboProgram.setVisible(true);
        comboYrLvl.setVisible(true);
        comboDepartment.setVisible(false);
    }//GEN-LAST:event_rbtnStudentActionPerformed

    private void rbtnFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacultyActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        comboDepartment.setVisible(true);
    }//GEN-LAST:event_rbtnFacultyActionPerformed

    private void rbtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAdminActionPerformed
        comboProgram.setVisible(false);
        comboYrLvl.setVisible(false);
        comboDepartment.setVisible(false);
    }//GEN-LAST:event_rbtnAdminActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        role = null;
        stuFaculID = txtStudentFacultyID.getText();
        firstName = txtFirstName.getText();
        lastName = txtLastName.getText();
        email = txtEmail.getText();
        program = (String) comboProgram.getSelectedItem();
        yearLevel = (String) comboYrLvl.getSelectedItem();
        department = (String) comboDepartment.getSelectedItem();

        lblWarningMsg.setVisible(true);
        if (stuFaculID.isEmpty() && firstName.isEmpty() && lastName.isEmpty() && email.isEmpty() && !rbtnStudent.isSelected() && !rbtnFaculty.isSelected()) {
            lblWarningMsg.setText("Please input all required fields.");
        } else if (stuFaculID.isEmpty()) {
            lblWarningMsg.setText("Please Specify your ID");
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            lblWarningMsg.setText("Please specify your name.");
        } else if (email.isEmpty()) {
            lblWarningMsg.setText("Please input your email.");
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
            } else if (rbtnFaculty.isSelected()) {
                role = rbtnFaculty.getText();
                department = (String) comboDepartment.getSelectedItem();
                if (department.equals("DEFAULT")) {
                    lblWarningMsg.setText("Please specify your Department.");
                }
                program = null;
                yearLevel = null;
            } else {
                role = rbtnAdmin.getText();
                department = null;
                program = null;
                yearLevel = null;
            }
            String msg = ComLabMethods.updateAccount(id, role, stuFaculID, firstName, lastName, email, program, yearLevel, department);
            lblWarningMsg.setText(msg);
            System.out.println("pogiiiii");
        }
    }//GEN-LAST:event_saveChangesActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAcct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateAcct dialog = new UpdateAcct(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboDepartment;
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JComboBox<String> comboYrLvl;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblStudentFacultyID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWarningMsg;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JRadioButton rbtnAdmin;
    private javax.swing.JRadioButton rbtnFaculty;
    private javax.swing.JRadioButton rbtnStudent;
    private javax.swing.JButton saveChanges;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtStudentFacultyID;
    // End of variables declaration//GEN-END:variables
}
