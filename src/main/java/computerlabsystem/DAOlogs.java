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
                String facultyaccountable = rsltSet.getString("facultyaccountable");

                DTOlogs data = new DTOlogs(facultyaccountable, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<DTOlogs> getAllLogs() {
        List<DTOlogs> dataList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT\n"
                + "    logs.logID,\n"
                + "    logs.fullname,\n"
                + "    logs.login_time,\n"
                + "    logs.logout_time,\n"
                + "    logs.facultyAccountable,\n"
                + "    users.studentfacultyID AS sfID,\n"
                + "    users.role AS userRole,\n"
                + "    users.program,\n"
                + "    users.yearlvl,\n"
                + "    users.department AS facultyDepartment\n"
                + "FROM\n"
                + "    users\n"
                + "RIGHT JOIN\n"
                + "    logs\n"
                + "ON\n"
                + "    logs.user_id_users = users.id\n"
                + "WHERE\n"
                + "    users.role = 'STUDENT' OR users.role = 'FACULTY' OR users.role = 'ADMIN'\n"
                + "ORDER BY\n"
                + "    logs.login_time DESC;"); // Execute the query and retrieve the ResultSet
                 ResultSet rsltSet = stmt.executeQuery()) {

            // Loop through the ResultSet and fetch data for each row
            while (rsltSet.next()) {
                int userLogsID = rsltSet.getInt("logID");
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yearlvl");
                String userDepartment = rsltSet.getString("facultyDepartment");
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");
                String facultyAccountable = rsltSet.getString("facultyAccountable");

                // Create a DTOlogs object and add it to the dataList
                DTOlogs data = new DTOlogs(userLogsID, userRole, userFullname, userProgram, userYrlvl, userDepartment, userLogin, userLogout, facultyAccountable);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of DTOlogs containing the retrieved data
        return dataList;
    }

    public static List<DTOvisitors> getAllVisitorsLogs() {
        List<DTOvisitors> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT "
                + "    logs.logID,"
                + "    logs.login_time,"
                + "    logs.logout_time,"
                + "    visitors.codeidentity AS visitorID,"
                + "    visitors.fullname AS fullname,"
                + "    visitors.mobilenumber AS mobilenumber,"
                + "    visitors.email AS email,"
                + "    visitors.gender AS gender,"
                + "    visitors.purpose AS purpose "
                + "FROM "
                + "    logs "
                + "RIGHT JOIN "
                + "    visitors "
                + "ON "
                + "    logs.user_id_visitors = visitors.id "
                + "ORDER BY "
                + "    logs.login_time DESC"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int userLogsID = rsltSet.getInt("logID");
                String visitorID = rsltSet.getString("visitorID");
                String userFullname = rsltSet.getString("fullname");
                String mobilenumber = rsltSet.getString("mobilenumber");
                String email = rsltSet.getString("email");
                String gender = rsltSet.getString("gender");
                String purpose = rsltSet.getString("purpose");
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");

                DTOvisitors data = new DTOvisitors(userLogsID, visitorID, userFullname, email, mobilenumber, gender, purpose, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

}
