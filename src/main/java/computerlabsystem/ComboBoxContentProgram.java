/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author araos
 */
public class ComboBoxContentProgram extends javax.swing.JDialog {

    /**
     * Creates new form Program
     */
    public ComboBoxContentProgram(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayProgram();
    }

    private void displayProgram() {
        DefaultTableModel allProgram = (DefaultTableModel) programTable.getModel();
        allProgram.setRowCount(0);

        List<DTOaccount> programList = ComLabMethods.programComboContent();

        for (DTOaccount program : programList) {
            Object[] programRow = {program.getProgram()};
            allProgram.addRow(programRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient2 = new computerlabsystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();
        txtAddProgram = new javax.swing.JTextField();
        btnAddProgram = new javax.swing.JButton();
        btnDeleteProgram = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblWarningMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        panelGradient2.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient2.setColorSecondary(new java.awt.Color(199, 188, 161));
        panelGradient2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));

        programTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "PROGRAM"
            }
        ));
        jScrollPane1.setViewportView(programTable);

        panelGradient2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 200));

        txtAddProgram.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddProgram.setBorder(null);
        txtAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(txtAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 240, 30));

        btnAddProgram.setBackground(new java.awt.Color(255, 255, 204));
        btnAddProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-20.png"))); // NOI18N
        btnAddProgram.setText("ADD");
        btnAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 20));

        btnDeleteProgram.setBackground(new java.awt.Color(255, 255, 204));
        btnDeleteProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-20.png"))); // NOI18N
        btnDeleteProgram.setText("DELETE");
        btnDeleteProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnDeleteProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, 20));

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        lblWarningMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-error-24.png"))); // NOI18N
        lblWarningMessage.setText("jLabel1");
        panelGradient2.add(lblWarningMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 190, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PROGRAM");
        panelGradient2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProgramActionPerformed
        String addProgram = txtAddProgram.getText();
        if (addProgram.isEmpty()) {

        } else {
            ComLabMethods.programComboBox(addProgram);
            displayProgram();
            txtAddProgram.setText("");
            lblWarningMessage.setVisible(false);
        }
    }//GEN-LAST:event_btnAddProgramActionPerformed

    private void btnDeleteProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProgramActionPerformed
        DefaultTableModel model = (DefaultTableModel) programTable.getModel();
        int selectedRow = programTable.getSelectedRow();
        if (selectedRow != 1) {
            String program = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteProgram(program);
            displayProgram();
            lblWarningMessage.setVisible(false);
        }
    }//GEN-LAST:event_btnDeleteProgramActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddProgramActionPerformed

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
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComboBoxContentProgram dialog = new ComboBoxContentProgram(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProgram;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteProgram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWarningMessage;
    private computerlabsystem.Design.PanelGradient panelGradient2;
    private javax.swing.JTable programTable;
    private javax.swing.JTextField txtAddProgram;
    // End of variables declaration//GEN-END:variables
}
