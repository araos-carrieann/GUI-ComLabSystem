/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
public class ChartDTO {
    
    private String Month;
    private double studentLogs;
    private double facultyLogs;
    private double adminLogs;

    public ChartDTO(String Month, double studentLogs, double facultyLogs, double adminLogs) {
        this.Month = Month;
        this.studentLogs = studentLogs;
        this.facultyLogs = facultyLogs;
        this.adminLogs = adminLogs;
    }

    
    
    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public double getStudentLogs() {
        return studentLogs;
    }

    public void setStudentLogs(int studentLogs) {
        this.studentLogs = studentLogs;
    }

    public double getFacultyLogs() {
        return facultyLogs;
    }

    public void setFacultyLogs(int facultyLogs) {
        this.facultyLogs = facultyLogs;
    }

    public double getAdminLogs() {
        return adminLogs;
    }

    public void setAdminLogs(int adminLogs) {
        this.adminLogs = adminLogs;
    }
    
    
}
    

 