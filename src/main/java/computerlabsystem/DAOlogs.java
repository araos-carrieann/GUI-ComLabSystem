/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author araos
 */
public class DAOlogs {

    public static List<DTOlogs> getUserLogs(int id) {
        List<DTOlogs> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM logs WHERE user_id_users = '" + id + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");

                DTOlogs data = new DTOlogs(0, null, null, null, null, null, null, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<DTOlogs> getAllLogs() {
        List<DTOlogs> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(("SELECT logs.logID, logs.fullname, logs.login_time, logs.logout_time, "
    + "users.studentfacultyID AS sfID, users.role AS userRole, "
    + "users.program AS program, users.yearlvl AS yrlvl, users.department AS facultyDepartment "
    + "FROM users RIGHT JOIN logs ON logs.user_id_users = users.id "
    + "WHERE users.role = 'STUDENT' OR users.role = 'FACULTY';")); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int userLogsID = rsltSet.getInt("logID");
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String studentfacultyID = rsltSet.getString("sfID");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yrlvl");
                String userDepartment = rsltSet.getString("facultyDepartment");
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");

                DTOlogs data = new DTOlogs(userLogsID, userRole, studentfacultyID, userFullname, userProgram, userYrlvl, userDepartment, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

}
