/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package computerlabsystem;

import chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author araos
 */
public class ChartPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChartPanel
     */
    public ChartPanel() {
        initComponents();
        chart.setTitle("Logs Data");
        chart.addLegend("Student", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Faculty", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Admin", Color.decode("#0099F7"), Color.decode("#F11712"));
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
                int studentLogs = rsltSet.getInt("studentLogs");
                int facultyLogs = rsltSet.getInt("facultyLogs");
                int adminLogs = rsltSet.getInt("adminLogs");
                lists.add(new DTOchart(month, studentLogs, facultyLogs, adminLogs));
            }
            // Close the ResultSet and PreparedStatement
            rsltSet.close();
            stmt.close();

            // Add Data to the chart
            chart.clear(); // Clear the existing data in the chart
            for (int i = lists.size() - 1; i >= 0; i--) { // Reverse order to get the past month data first
                DTOchart d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getStudentLogs(), d.getFacultyLogs(), d.getAdminLogs()}));
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

        panelShadow1.setBackground(new java.awt.Color(51, 51, 51));
        panelShadow1.setColorGradient(new java.awt.Color(51, 51, 51));

        chart.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.CurveLineChart chart;
    private computerlabsystem.Design.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
