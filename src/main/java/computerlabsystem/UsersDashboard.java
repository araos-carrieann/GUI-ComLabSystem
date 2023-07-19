/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import static computerlabsystem.UserDashboardMethods.formatDuration;
import java.time.Duration;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author araos
 */
public class UsersDashboard extends javax.swing.JFrame {

    private String sfID;

    public String getSfID() {
        return sfID;
    }

    public void setSfID(String sfID) {
        this.sfID = sfID;
    }

    public UsersDashboard(String fname, String sfID) {
        this.sfID = sfID;
        initComponents();
        displayMyLogs(sfID);
        lblUserName.setText(fname);
        showTimeSpentTotalLogs(sfID);
    }

    public void showTimeSpentTotalLogs(String sfID) {
        int id = ComLabMethods.getUserID(sfID);
        Duration timeSpent = UserDashboardMethods.getTotalTimeSpentByUser(id);
        int totalLogs = UserDashboardMethods.getTotalLogsByUser(id);

        lblTimeSpent.setText(formatDuration(timeSpent));
        lblTotalLogs.setText(String.valueOf(totalLogs));
    }

    private void displayMyLogs(String sfID) {
        DefaultTableModel myLogs = (DefaultTableModel) myLogsTable.getModel();
        myLogs.setRowCount(0);

        int id = ComLabMethods.getUserID(sfID);
        List<DTOlogs> logsList = DAOlogs.getUserLogs(id);

        for (DTOlogs acct : logsList) {
            Object[] logsRow = {acct.getUserLogin(), acct.getUserLogout()};
            myLogs.addRow(logsRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        panelGradient3 = new computerlabsystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        myLogsTable = new javax.swing.JTable();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        lblMyTotalLogs = new javax.swing.JLabel();
        lblTotalLogs = new javax.swing.JLabel();
        panelBorder2 = new computerlabsystem.Design.PanelBorder();
        lblTimeDurationSpent = new javax.swing.JLabel();
        lblTimeSpent = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradient1.setColorPrimary(new java.awt.Color(255, 51, 51));
        panelGradient1.setLayout(new java.awt.BorderLayout());

        panelGradient3.setColorPrimary(new java.awt.Color(109, 113, 249));
        panelGradient3.setColorSecondary(new java.awt.Color(139, 126, 116));

        myLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "LOG IN TIME", "LOG OUT TIME "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(myLogsTable);
        if (myLogsTable.getColumnModel().getColumnCount() > 0) {
            myLogsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        panelBorder1.setBackground(new java.awt.Color(255, 255, 204));

        lblMyTotalLogs.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblMyTotalLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyTotalLogs.setText("MY TOTAL LOGS");
        panelBorder1.add(lblMyTotalLogs);
        lblMyTotalLogs.setBounds(20, 10, 120, 30);

        lblTotalLogs.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblTotalLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalLogs.setText("jLabel4");
        panelBorder1.add(lblTotalLogs);
        lblTotalLogs.setBounds(30, 30, 80, 40);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 204));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimeDurationSpent.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblTimeDurationSpent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeDurationSpent.setText("TIME DURATION SPENT");
        panelBorder2.add(lblTimeDurationSpent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblTimeSpent.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblTimeSpent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimeSpent.setText("jLabel4");
        panelBorder2.add(lblTimeSpent, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 50, 170, 40));

        btnLogout.setBackground(new java.awt.Color(255, 255, 204));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-64.png"))); // NOI18N
        lblUserName.setText("jLabel1");
        lblUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserNameMouseClicked(evt);
            }
        });

        panelGradient3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(panelBorder1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(panelBorder2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(btnLogout, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(lblUserName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelGradient3Layout = new javax.swing.GroupLayout(panelGradient3);
        panelGradient3.setLayout(panelGradient3Layout);
        panelGradient3Layout.setHorizontalGroup(
            panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(14, 14, 14))
            .addGroup(panelGradient3Layout.createSequentialGroup()
                .addGroup(panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient3Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGradient3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGradient3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelGradient3Layout.setVerticalGroup(
            panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addGap(16, 16, 16))
        );

        panelGradient1.add(panelGradient3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserNameMouseClicked
        UserProfile dialog = new UserProfile(new javax.swing.JFrame(), true);
        String studentfacultyID = getSfID();
        System.out.println(studentfacultyID);
        String userInfo = ComLabMethods.getInfo(studentfacultyID);
        String[] parts = userInfo.split(",");
        int id = Integer.parseInt(parts[0]);
        String studFaculID = parts[1];
        String firstName = parts[2];
        String lastName = parts[3];
        String email = parts[4];
        String program = parts[5];
        String yearLevel = parts[6];

        dialog.setStudentInfo(id, studFaculID, email, firstName, lastName, program, yearLevel);
        dialog.setVisible(true);
    }//GEN-LAST:event_lblUserNameMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        UserDashboardMethods.userLogout(getSfID());
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

/**
 * @param args the command line arguments
 */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMyTotalLogs;
    private javax.swing.JLabel lblTimeDurationSpent;
    private javax.swing.JLabel lblTimeSpent;
    private javax.swing.JLabel lblTotalLogs;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable myLogsTable;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelBorder panelBorder2;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private computerlabsystem.Design.PanelGradient panelGradient3;
    // End of variables declaration//GEN-END:variables
}
