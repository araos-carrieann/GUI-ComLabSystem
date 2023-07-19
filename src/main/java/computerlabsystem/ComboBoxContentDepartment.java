/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author araos
 */
public class ComboBoxContentDepartment extends javax.swing.JDialog {

    /**
     * Creates new form ProgramDialog
     */
    public ComboBoxContentDepartment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        displayDepartment();
    }

    private void displayDepartment() {
        DefaultTableModel allDepartment = (DefaultTableModel) departmentTable.getModel();
        allDepartment.setRowCount(0);

        List<DTOaccount> departmentList = ComLabMethods.departmentComboContent();

        for (DTOaccount data : departmentList) {
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
        txtAddDepartment = new javax.swing.JTextField();
        btnAddDepartment = new javax.swing.JButton();
        btnDeleteDepartment = new javax.swing.JButton();
        btnClearDepartment = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblDepartment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        panelGradient4.setBackground(new java.awt.Color(255, 0, 51));
        panelGradient4.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient4.setColorSecondary(new java.awt.Color(199, 188, 161));
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

        panelGradient4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 330, 200));

        txtAddDepartment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelGradient4.add(txtAddDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 210, -1));

        btnAddDepartment.setBackground(new java.awt.Color(255, 255, 204));
        btnAddDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddDepartment.setText("ADD");
        btnAddDepartment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddDepartment.setMaximumSize(new java.awt.Dimension(72, 23));
        btnAddDepartment.setMinimumSize(new java.awt.Dimension(72, 23));
        btnAddDepartment.setPreferredSize(new java.awt.Dimension(72, 23));
        btnAddDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnAddDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 70, -1));

        btnDeleteDepartment.setBackground(new java.awt.Color(255, 255, 204));
        btnDeleteDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteDepartment.setText("DELETE");
        btnDeleteDepartment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteDepartment.setMaximumSize(new java.awt.Dimension(72, 23));
        btnDeleteDepartment.setMinimumSize(new java.awt.Dimension(72, 23));
        btnDeleteDepartment.setPreferredSize(new java.awt.Dimension(72, 23));
        btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnDeleteDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 80, -1));

        btnClearDepartment.setBackground(new java.awt.Color(255, 255, 204));
        btnClearDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearDepartment.setText("CLEAR");
        btnClearDepartment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClearDepartment.setMaximumSize(new java.awt.Dimension(72, 23));
        btnClearDepartment.setMinimumSize(new java.awt.Dimension(72, 23));
        btnClearDepartment.setPreferredSize(new java.awt.Dimension(72, 23));
        btnClearDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearDepartmentActionPerformed(evt);
            }
        });
        panelGradient4.add(btnClearDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 70, -1));

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        panelGradient4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        lblDepartment.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblDepartment.setText("DEPARTMENT");
        panelGradient4.add(lblDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepartmentActionPerformed
        String addDepartment = txtAddDepartment.getText();
        ComLabMethods.departmentComboBox(addDepartment);
        displayDepartment();
        txtAddDepartment.setText("");
    }//GEN-LAST:event_btnAddDepartmentActionPerformed

    private void btnDeleteDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDepartmentActionPerformed
        DefaultTableModel model = (DefaultTableModel) departmentTable.getModel();
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != 1) {
            String department = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteProgram(department);
            displayDepartment();
        }
    }//GEN-LAST:event_btnDeleteDepartmentActionPerformed

    private void btnClearDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearDepartmentActionPerformed
        txtAddDepartment.setText("");
    }//GEN-LAST:event_btnClearDepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(ComboBoxContentDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComboBoxContentDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ComboBoxContentDepartment dialog = new ComboBoxContentDepartment(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearDepartment;
    private javax.swing.JButton btnDeleteDepartment;
    private javax.swing.JTable departmentTable;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDepartment;
    private computerlabsystem.Design.PanelGradient panelGradient4;
    private javax.swing.JTextField txtAddDepartment;
    // End of variables declaration//GEN-END:variables
}
