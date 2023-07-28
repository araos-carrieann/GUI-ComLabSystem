/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
import chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        chart.setTitle("Chart Data");
        chart.addLegend("Student", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Admin", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Faculty", Color.decode("#0099F7"), Color.decode("#F11712"));
        setData();
    }

    private void setData() {
        List<DTOchart> lists = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT\n"
                + "    TO_CHAR(sub.login_time, 'Month') AS Month,\n"
                + "    SUM(CASE WHEN sub.role = 'FACULTY' THEN 1 ELSE 0 END) AS facultyLogs,\n"
                + "    SUM(CASE WHEN sub.role = 'ADMIN' THEN 1 ELSE 0 END) AS adminLogs,\n"
                + "    SUM(CASE WHEN sub.role = 'STUDENT' THEN 1 ELSE 0 END) AS studentLogs\n"
                + "FROM\n"
                + "    (\n"
                + "        SELECT\n"
                + "            login_time,\n"
                + "            users.role,\n"
                + "            TO_CHAR(login_time, 'MMYYYY') AS month_year\n"
                + "        FROM\n"
                + "            logs\n"
                + "        JOIN\n"
                + "            users ON logs.user_id_users = users.id\n"
                + "        ORDER BY\n"
                + "            login_time DESC\n"
                + "    ) AS sub\n"
                + "GROUP BY\n"
                + "    sub.login_time,\n"
                + "    TO_CHAR(sub.login_time, 'Month'),\n"
                + "    sub.month_year\n"
                + "ORDER BY\n"
                + "    sub.login_time DESC;"
        ); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String month = rsltSet.getString("Month");
                int facultyLogs = rsltSet.getInt("facultyLogs");
                int adminLogs = rsltSet.getInt("adminLogs");
                int studentLogs = rsltSet.getInt("studentLogs");
                lists.add(new DTOchart(month, studentLogs, facultyLogs, adminLogs));
            }
            // Close the ResultSet and PreparedStatement
            rsltSet.close();
            stmt.close();

            // Add Data to the chart
            chart.clear(); // Clear the existing data in the chart
            for (int i = lists.size() - 1; i >= 0; i--) { // Reverse order to get the past month data first
                DTOchart d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getFacultyLogs(), d.getAdminLogs(), d.getStudentLogs()}));
            }

            // Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new computerlabsystem.Design.PanelShadow();
        chart = new chart.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(0, 0, 0));
        panelShadow1.setColorGradient(new java.awt.Color(0, 0, 0));

        chart.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.CurveLineChart chart;
    private computerlabsystem.Design.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
