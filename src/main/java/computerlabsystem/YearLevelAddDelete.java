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
public class YearLevelAddDelete extends javax.swing.JDialog {

    /**
     * Creates new form YearLevelDialog
     */
    public YearLevelAddDelete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayYearLvl() ;
    }

        private void displayYearLvl() {
        DefaultTableModel allYrLvl = (DefaultTableModel) yrLvlTable.getModel();
        allYrLvl.setRowCount(0);

        List<Data> yearLevelList = ComLabMethods.yearlvlComboContent();

        for (Data acct : yearLevelList) {
            Object[] yearLvlRow = {acct.getYrlvl()};
            allYrLvl.addRow(yearLvlRow);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient3 = new computerlabsystem.Design.PanelGradient();
        jScrollPane2 = new javax.swing.JScrollPane();
        yrLvlTable = new javax.swing.JTable();
        lblAddYrLvl = new javax.swing.JLabel();
        txtAddYrLvl = new javax.swing.JTextField();
        btnAddYrLvl = new javax.swing.JButton();
        btnDeleteYrLvl = new javax.swing.JButton();
        btnClearYearLevel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yrLvlTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "YEAR LEVEL"
            }
        ));
        jScrollPane2.setViewportView(yrLvlTable);

        panelGradient3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 330, 200));

        lblAddYrLvl.setText("YEAR LEVEL");
        panelGradient3.add(lblAddYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        txtAddYrLvl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddYrLvl.setText("Enter Level");
        panelGradient3.add(txtAddYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        btnAddYrLvl.setText("ADD");
        btnAddYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddYrLvlActionPerformed(evt);
            }
        });
        panelGradient3.add(btnAddYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        btnDeleteYrLvl.setText("DELETE");
        btnDeleteYrLvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteYrLvlActionPerformed(evt);
            }
        });
        panelGradient3.add(btnDeleteYrLvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        btnClearYearLevel.setText("CLEAR");
        btnClearYearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearYearLevelActionPerformed(evt);
            }
        });
        panelGradient3.add(btnClearYearLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient3.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddYrLvlActionPerformed
        String addYrLvl = txtAddYrLvl.getText();
        ComLabMethods.yearLevelComboBox(addYrLvl);
        displayYearLvl();
        txtAddYrLvl.setText("");
    }//GEN-LAST:event_btnAddYrLvlActionPerformed

    private void btnDeleteYrLvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteYrLvlActionPerformed
        DefaultTableModel model = (DefaultTableModel) yrLvlTable.getModel();
        int selectedRow = yrLvlTable.getSelectedRow();
        if (selectedRow != 1) {
            String yrLvl = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteYearLvl(yrLvl);
            displayYearLvl();
        }
    }//GEN-LAST:event_btnDeleteYrLvlActionPerformed

    private void btnClearYearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearYearLevelActionPerformed
        txtAddYrLvl.setText("");
    }//GEN-LAST:event_btnClearYearLevelActionPerformed

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
            java.util.logging.Logger.getLogger(YearLevelAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YearLevelAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YearLevelAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YearLevelAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                YearLevelAddDelete dialog = new YearLevelAddDelete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddYrLvl;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearYearLevel;
    private javax.swing.JButton btnDeleteYrLvl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddYrLvl;
    private computerlabsystem.Design.PanelGradient panelGradient3;
    private javax.swing.JTextField txtAddYrLvl;
    private javax.swing.JTable yrLvlTable;
    // End of variables declaration//GEN-END:variables
}
