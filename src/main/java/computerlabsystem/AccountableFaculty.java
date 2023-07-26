/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author araos
 */
public class AccountableFaculty extends javax.swing.JDialog {

    private String SfID;
    private String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSfID() {
        return SfID;
    }

    public void setSfID(String SfID) {
        this.SfID = SfID;
    }

    public AccountableFaculty(java.awt.Frame parent, boolean modal, String fname, String SfID) {
        super(parent, modal);
        this.fname = fname;
        this.SfID = SfID;
        initComponents();
        insertContentProfessor();
    }

    private void insertContentProfessor() {
        List<DTOaccount> accountableNameList = ComLabMethods.professorComboContent();
        accountableCombobox.removeAllItems(); // Clear existing items

        for (DTOaccount data : accountableNameList) {
            accountableCombobox.addItem(data.getAccountablename());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        accountableCombobox = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        accountableCombobox.setBackground(new java.awt.Color(51, 64, 225));
        accountableCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        accountableCombobox.setBorder(null);
        panelGradient1.add(accountableCombobox);
        accountableCombobox.setBounds(60, 140, 320, 30);

        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        panelGradient1.add(btnSubmit);
        btnSubmit.setBounds(100, 240, 190, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        accountableName = (String) accountableCombobox.getSelectedItem();
        new ComLabMethods().updateLogsFacultyAccountable(accountableName, getSfID());
        String userTimeLogin = new ComLabMethods().getTimeLogin(getSfID());
        System.out.println(accountableName);
        String[] parts = accountableName.split("[,\\s]+");
        lastname = parts[0];
        firstname = parts[1];
        String accountableEmail = ComLabMethods.getAccountableEmail(lastname, firstname);
        System.out.println(accountableEmail);
        try {
            new ForgetPasswordMethods().sendMailToAccountableFaculty(accountableEmail, lastname, getFname(), userTimeLogin);
        } catch (Exception ex) {
            Logger.getLogger(AccountableFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsersDashboard userDashboard = new UsersDashboard(fname, getSfID());
        userDashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    String accountableName, lastname, firstname;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountableCombobox;
    private javax.swing.JButton btnSubmit;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}
