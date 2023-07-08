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
public class DepartmentAddDelete extends javax.swing.JDialog {

    /**
     * Creates new form ProgramDialog
     */
    public DepartmentAddDelete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayDepartment();
    }

    private void displayDepartment() {
        DefaultTableModel allDepartment = (DefaultTableModel) departmentTable.getModel();
        allDepartment.setRowCount(0);

        List<Data> departmentList = ComLabMethods.departmentComboContent();

        for (Data data : departmentList) {
            Object[] departmentRow = {data.getDepartment()};
            allDepartment.addRow(departmentRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient4 = new computerlabsystem.Design.PanelGradient();
        jScrollPane3 = new javax.swing.JScrollPane();
        departmentTable = new javax.swing.JTable();
        lblAddDepartment = new javax.swing.JLabel();
        txtAddDepartment = new javax.swing.JTextField();
        btnAddDepartment = new javax.swing.JButton();
        btnDeleteDepartment = new javax.swing.JButton();
        btnClearDepartment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        departmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "DEPARTMENT"
            }
        ));
        jScrollPane3.setViewportView(departmentTable);

        panelGradient4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 330, 200));

        lblAddDepartment.setText("DEPARTMENT");
        panelGradient4.add(lblAddDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        txtAddDepartment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAddDepartment.setText("Enter Department");
        panelGradient4.add(txtAddDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        btnAddDepartment.setText("ADD");
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnAddDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        btnDeleteDepartment.setText("DELETE");
        btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnDeleteDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        btnClearDepartment.setText("CLEAR");
        btnClearDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnClearDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        String addDepartment = txtAddDepartment.getText();
        ComLabMethods.departmentComboBox(addDepartment);
    }//GEN-LAST:event_btnAddDepartmentActionPerformed

    private void btnDeleteDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDepartmentActionPerformed
        DefaultTableModel model = (DefaultTableModel) departmentTable.getModel();
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != 1) {
            String department = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteProgram(department);
        }
    }//GEN-LAST:event_btnDeleteDepartmentActionPerformed

    private void btnClearDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearDepartmentActionPerformed
        txtAddDepartment.setText("");
    }//GEN-LAST:event_btnClearDepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentAddDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DepartmentAddDelete dialog = new DepartmentAddDelete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddDepartment;
    private javax.swing.JButton btnClearDepartment;
    private javax.swing.JButton btnDeleteDepartment;
    private javax.swing.JTable departmentTable;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAddDepartment;
    private computerlabsystem.Design.PanelGradient panelGradient4;
    private javax.swing.JTextField txtAddDepartment;
    // End of variables declaration//GEN-END:variables
}
