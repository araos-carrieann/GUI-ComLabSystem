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

        List<DTOaccount> acctList = ComLabMethods.programComboContent();

        for (DTOaccount acct : acctList) {
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
        txtAddProgram = new javax.swing.JTextField();
        btnAddProgram = new javax.swing.JButton();
        btnDeleteProgram = new javax.swing.JButton();
        btnClearProgram = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

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

        panelGradient2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 200));

        txtAddProgram.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddProgram.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "PROGRAM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM));
        panelGradient2.add(txtAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        btnAddProgram.setBackground(new java.awt.Color(255, 255, 204));
        btnAddProgram.setText("ADD");
        btnAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnAddProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 80, -1, -1));

        btnDeleteProgram.setBackground(new java.awt.Color(255, 255, 204));
        btnDeleteProgram.setText("DELETE");
        btnDeleteProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnDeleteProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 80, -1, -1));

        btnClearProgram.setBackground(new java.awt.Color(255, 255, 204));
        btnClearProgram.setText("CLEAR");
        btnClearProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearProgramActionPerformed(evt);
            }
        });
        panelGradient2.add(btnClearProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
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
    private javax.swing.JButton btnClearProgram;
    private javax.swing.JButton btnDeleteProgram;
    private javax.swing.JScrollPane jScrollPane1;
    private computerlabsystem.Design.PanelGradient panelGradient2;
    private javax.swing.JTable programTable;
    private javax.swing.JTextField txtAddProgram;
    // End of variables declaration//GEN-END:variables
}
