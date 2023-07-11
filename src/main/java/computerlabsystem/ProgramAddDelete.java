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
public class ProgramAddDelete extends javax.swing.JDialog {

    /**
     * Creates new form Program
     */
    public ProgramAddDelete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         displayProgram();
    }

     private void displayProgram() {
        DefaultTableModel allProgram = (DefaultTableModel) programTable.getModel();
        allProgram.setRowCount(0);

        List<Data> acctList = ComLabMethods.programComboContent();

        for (Data acct : acctList) {
            Object[] programRow = {acct.getProgram()};
            allProgram.addRow(programRow);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient2 = new computerlabsystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();
        lblAddPRogram = new javax.swing.JLabel();
        txtAddProgram = new javax.swing.JTextField();
        btnAddProgram = new javax.swing.JButton();
        btnDeleteProgram = new javax.swing.JButton();
        btnClearProgram = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        panelGradient2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelGradient2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 200));

        lblAddPRogram.setText("PROGRAM");
        panelGradient2.add(lblAddPRogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        txtAddProgram.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddProgram.setText("Enter Program");
        panelGradient2.add(txtAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        btnAddProgram.setText("ADD");
        btnAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        btnDeleteProgram.setText("DELETE");
        btnDeleteProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnDeleteProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        btnClearProgram.setText("CLEAR");
        btnClearProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnClearProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProgramActionPerformed
        String addProgram = txtAddProgram.getText();
        ComLabMethods.programComboBox(addProgram);
        displayProgram();
        txtAddProgram.setText("");
    }//GEN-LAST:event_btnAddProgramActionPerformed

    private void btnDeleteProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProgramActionPerformed
        DefaultTableModel model = (DefaultTableModel) programTable.getModel();
        int selectedRow = programTable.getSelectedRow();
        if (selectedRow != 1) {
            String program = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteProgram(program);
            displayProgram();
        }
    }//GEN-LAST:event_btnDeleteProgramActionPerformed

    private void btnClearProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearProgramActionPerformed
         txtAddProgram.setText("");
    }//GEN-LAST:event_btnClearProgramActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProgramAddDelete dialog = new ProgramAddDelete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClearProgram;
    private javax.swing.JButton btnDeleteProgram;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddPRogram;
    private computerlabsystem.Design.PanelGradient panelGradient2;
    private javax.swing.JTable programTable;
    private javax.swing.JTextField txtAddProgram;
    // End of variables declaration//GEN-END:variables
}
