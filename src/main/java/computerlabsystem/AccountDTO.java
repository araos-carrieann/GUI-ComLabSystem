/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
public class AccountDTO {

    private int userID;
    private int logsID;
    private String logsDuration;
    private String mostLogs;
    private String studentfacultyID;
    private String status;
    private String role;
    private String firstName;
    private String lastName;
    private String fullname;
    private String accountablename;
    private String email;
    private String program;
    private String yrlvl;
    private String department;
    private String userLogin;
    private String userLogout;

    public AccountDTO(String accountablename) {
        this.accountablename = accountablename;
    }

    public AccountDTO(int logsID, String fullname, String userLogin, String userLogout) {
        this.logsID = logsID;
        this.fullname = fullname;
        this.userLogin = userLogin;
        this.userLogout = userLogout;
    }

    public AccountDTO(String program, String yrlvl, String department) {
        this.program = program;
        this.yrlvl = yrlvl;
        this.department = department;
    }

    public AccountDTO(String role, String fullname, String logsDuration, String mostLogs) {
        this.role = role;
        this.fullname = fullname;
        this.logsDuration = logsDuration;
        this.mostLogs = mostLogs;
    }

    public AccountDTO(int userID, String studentfacultyID, String firstName, String lastName, String email) {
        this.userID = userID;
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AccountDTO(int logsID, String studentfacultyID, String role, String firstName, String lastName, String email, String program, String yrlvl, String department, String userTimeIn, String userTimeOut) {
        this.logsID = logsID;
        this.studentfacultyID = studentfacultyID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.program = program;
        this.yrlvl = yrlvl;
        this.department = department;
        this.userLogin = userTimeIn;
        this.userLogout = userTimeOut;
    }

    //Student account
    public AccountDTO(String studentfacultyID, String firstName, String lastName, String email, String program, String yrlvl) {
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.program = program;
        this.yrlvl = yrlvl;
    }

    //Faculty account
    public AccountDTO(String studentfacultyID, String department, String firstName, String lastName, String email) {
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLogsID() {
        return logsID;
    }

    public void setLogsID(int logsID) {
        this.logsID = logsID;
    }

    public String getStudentfacultyID() {
        return studentfacultyID;
    }

    public void setStudentfacultyID(String studentfacultyID) {
        this.studentfacultyID = studentfacultyID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAccountablename() {
        return accountablename;
    }

    public void setAccountablename(String accountablename) {
        this.accountablename = accountablename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getYrlvl() {
        return yrlvl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYrlvl(String yrlvl) {
        this.yrlvl = yrlvl;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogout() {
        return userLogout;
    }

    public void setUserLogout(String userLogout) {
        this.userLogout = userLogout;
    }

    public String getLogsDuration() {
        return logsDuration;
    }

    public void setLogsDuration(String logsDuration) {
        this.logsDuration = logsDuration;
    }

    public String getMostLogs() {
        return mostLogs;
    }

    public void setMostLogs(String mostLogs) {
        this.mostLogs = mostLogs;
    }

}
