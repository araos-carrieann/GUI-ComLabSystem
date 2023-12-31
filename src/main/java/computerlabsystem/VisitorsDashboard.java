/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;

/**
 *
 * @author araos
 */
public class VisitorsDashboard extends javax.swing.JFrame {

    private String codeIdentity;

    public String getCodeIdentity() {
        return codeIdentity;
    }

    public void setCodeIdentity(String codeIdentity) {
        this.codeIdentity = codeIdentity;
    }

    public VisitorsDashboard(String codeIdentity, String name) {
        this.codeIdentity = codeIdentity;
        initComponents();
        lblName.setText(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelBorder2 = new computerlabsystem.Design.PanelBorder();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelGradient1.setColorPrimary(new java.awt.Color(153, 153, 255));

        panelBorder1.setBackground(new java.awt.Color(153, 153, 255));

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(153, 153, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. Put Bags in the designated area. Laboratory Instructor is \n   not liable to any loss or damage in the student belongings.\n\n2. Sit properly with feet on the ground \n    and far from the power outlet to avoid electrical hazard.\n\n3. No food and drink are allowed Inside the  Laboratory. \n   Water should be in the closed bottle not in a cup.\n\n4. To minimize the usage of electricity, turn off the lights \n     and plug out all the equipment");
        jScrollPane2.setViewportView(jTextArea1);

        panelBorder1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 380, 200);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DO's and Dont's");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(130, 20, 140, 16);

        panelGradient1.add(panelBorder1);
        panelBorder1.setBounds(30, 100, 400, 260);

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        panelGradient1.add(btnLogout);
        btnLogout.setBounds(170, 390, 100, 23);

        panelBorder2.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder2.setLayout(new java.awt.GridLayout(1, 0));

        lblName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardUserIcon.png"))); // NOI18N
        lblName.setText("jLabel1");
        panelBorder2.add(lblName);

        panelGradient1.add(panelBorder2);
        panelBorder2.setBounds(30, 10, 210, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        VisitorsDAO.visitorsLogout(getCodeIdentity());
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblName;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelBorder panelBorder2;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}
