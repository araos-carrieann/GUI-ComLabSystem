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

        lblMyTimeSpent.setText(formatDuration(timeSpent));
        lblTotalLogs.setText(String.valueOf(totalLogs));
    }

    private void displayMyLogs(String sfID) {
        DefaultTableModel myLogs = (DefaultTableModel) myLogsTable.getModel();
        myLogs.setRowCount(0);

        int id = ComLabMethods.getUserID(sfID);
        List<Data> logsList = ComLabMethods.getUserLogs(id);

        for (Data acct : logsList) {
            Object[] logsRow = {acct.getUserLogin(), acct.getUserLogout()};
            myLogs.addRow(logsRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        panelGradient2 = new computerlabsystem.Design.PanelGradient();
        lblUserName = new javax.swing.JLabel();
        panelGradient3 = new computerlabsystem.Design.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        myLogsTable = new javax.swing.JTable();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        lblTotalLogs = new javax.swing.JLabel();
        panelBorder2 = new computerlabsystem.Design.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        lblMyTimeSpent = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradient1.setColorPrimary(new java.awt.Color(255, 51, 51));
        panelGradient1.setLayout(new java.awt.BorderLayout());

        panelGradient2.setColorPrimary(new java.awt.Color(241, 211, 179));
        panelGradient2.setColorSecondary(new java.awt.Color(241, 211, 179));
        panelGradient2.setPreferredSize(new java.awt.Dimension(100, 70));

        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-male-user-24.png")); // NOI18N
        lblUserName.setText("jLabel1");
        lblUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserNameMouseClicked(evt);
            }
        });

        panelGradient2.setLayer(lblUserName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelGradient2Layout = new javax.swing.GroupLayout(panelGradient2);
        panelGradient2.setLayout(panelGradient2Layout);
        panelGradient2Layout.setHorizontalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient2Layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGradient2Layout.setVerticalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelGradient1.add(panelGradient2, java.awt.BorderLayout.PAGE_START);

        panelGradient3.setColorPrimary(new java.awt.Color(101, 100, 124));
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

        panelBorder1.setBackground(new java.awt.Color(199, 188, 161));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MY TOTAL LOGS");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(0, 0, 120, 30);

        lblTotalLogs.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblTotalLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalLogs.setText("jLabel4");
        panelBorder1.add(lblTotalLogs);
        lblTotalLogs.setBounds(20, 30, 80, 40);

        panelBorder2.setBackground(new java.awt.Color(199, 188, 161));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TIME DURATION SPENT");
        panelBorder2.add(jLabel3);
        jLabel3.setBounds(40, 0, 130, 30);

        lblMyTimeSpent.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblMyTimeSpent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyTimeSpent.setText("jLabel4");
        panelBorder2.add(lblMyTimeSpent);
        lblMyTimeSpent.setBounds(20, 30, 160, 40);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelGradient3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(panelBorder1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(panelBorder2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelGradient3.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelGradient3Layout = new javax.swing.GroupLayout(panelGradient3);
        panelGradient3.setLayout(panelGradient3Layout);
        panelGradient3Layout.setHorizontalGroup(
            panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient3Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGradient3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient3Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        panelGradient3Layout.setVerticalGroup(
            panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
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
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserDashboardMethods.userLogout(getSfID());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

/**
 * @param args the command line arguments
 */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMyTimeSpent;
    private javax.swing.JLabel lblTotalLogs;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable myLogsTable;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelBorder panelBorder2;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private computerlabsystem.Design.PanelGradient panelGradient2;
    private computerlabsystem.Design.PanelGradient panelGradient3;
    // End of variables declaration//GEN-END:variables
}
