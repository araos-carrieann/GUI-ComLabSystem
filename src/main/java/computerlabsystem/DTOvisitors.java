/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

/**
 *
 * @author araos
 */
public class DTOvisitors {

    private int logsID;
    private String codeIdentity;
    private String fullname;
    private String email;
    private String mobilenumber;
    private String gender;
    private String purpose;
    private String loginTime;
    private String logoutTime;

    public DTOvisitors( String fullname, String email, String mobilenumber, String gender, String purpose, String loginTime, String logoutTime) {
        this.fullname = fullname;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.gender = gender;
        this.purpose = purpose;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    
    
    public int getLogsID() {
        return logsID;
    }

    public void setLogsID(int logsID) {
        this.logsID = logsID;
    }

    public String getCodeIdentity() {
        return codeIdentity;
    }

    public void setCodeIdentity(String codeIdentity) {
        this.codeIdentity = codeIdentity;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    
    
}
