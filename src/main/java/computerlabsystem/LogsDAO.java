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
public class LogsDAO {

    // Creates a new table named "logs" in the database to store user activity logs
    public static void createLogs() {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // SQL query to create the "logs" table if it doesn't already exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS logs (\n"
                    + "    logID SERIAL PRIMARY KEY,\n"
                    + "    user_id_users INTEGER REFERENCES users(id),\n"
                    + "    user_id_visitors INTEGER REFERENCES visitors(id),\n"
                    + "    fullname VARCHAR(255),\n"
                    + "    login_time TIMESTAMP DEFAULT (TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')),\n"
                    + "    logout_time TIMESTAMP,\n"
                    + "    facultyAccountable VARCHAR(255)\n"
                    + ");";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "logs" table
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves a list of LogsDTO objects representing user logs for a specific user with the given ID
    public static List<LogsDTO> getUserLogs(int id) {
        List<LogsDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM logs WHERE user_id_users = '" + id + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve user logs from the result set
            while (rsltSet.next()) {
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");
                String facultyaccountable = rsltSet.getString("facultyaccountable");

                // Create a new instance of LogsDTO and add it to the dataList
                LogsDTO data = new LogsDTO(facultyaccountable, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<LogsDTO> getAllLogs() {
        List<LogsDTO> dataList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT\n"
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
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yearlvl");
                String userDepartment = rsltSet.getString("facultyDepartment");
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");
                String facultyAccountable = rsltSet.getString("facultyAccountable");

                // Create a LogsDTO object and add it to the dataList
                LogsDTO data = new LogsDTO(userRole, userFullname, userProgram, userYrlvl, userDepartment, userLogin, userLogout, facultyAccountable);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of LogsDTO containing the retrieved data
        return dataList;
    }

    // Retrieves a list of VisitorsDTO objects representing logs of all visitors
    public static List<VisitorsDTO> getAllVisitorsLogs() {
        List<VisitorsDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT "
                + "    logs.login_time,"
                + "    logs.logout_time,"
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

            // Retrieve visitors' logs from the result set
            while (rsltSet.next()) {
                String userFullname = rsltSet.getString("fullname");
                String mobilenumber = rsltSet.getString("mobilenumber");
                String email = rsltSet.getString("email");
                String gender = rsltSet.getString("gender");
                String purpose = rsltSet.getString("purpose");
                String userLogin = rsltSet.getString("login_time");
                String userLogout = rsltSet.getString("logout_time");

                // Create a new instance of VisitorsDTO and add it to the dataList
                VisitorsDTO data = new VisitorsDTO(userFullname, email, mobilenumber, gender, purpose, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

}
