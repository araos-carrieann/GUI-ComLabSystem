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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelGradient1.setColorPrimary(new java.awt.Color(102, 102, 255));

        accountableCombobox.setBackground(new java.awt.Color(255, 255, 204));
        accountableCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        accountableCombobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelGradient1.add(accountableCombobox);
        accountableCombobox.setBounds(70, 120, 280, 30);

        btnSubmit.setBackground(new java.awt.Color(51, 51, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        panelGradient1.add(btnSubmit);
        btnSubmit.setBounds(80, 220, 250, 23);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Faculty that gives you permission");
        panelGradient1.add(jLabel1);
        jLabel1.setBounds(30, 60, 360, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}
