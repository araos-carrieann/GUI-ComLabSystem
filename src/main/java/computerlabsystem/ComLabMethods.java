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
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author araos
 */
public class ComLabMethods {

    //METHODS FOR SIGN UP
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static String registerUser(String status, String role, String stuFaculID, String fname, String lname, String email, String pass, String program, String yrLvl, String department) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, status VARCHAR(10) NOT NULL, studentFacultyID VARCHAR(10) NOT NULL, role VARCHAR(10) NOT NULL, firstName VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(60) NOT NULL, program VARCHAR(30) DEFAULT 'NOT APPLICABLE', yearLvl VARCHAR(10) DEFAULT 'NOT APPLICABLE', department VARCHAR(30) DEFAULT 'NOT APPLICABLE')";
            stmt.executeUpdate(createTableQuery);

            // Prepare the SELECT query with parameters
            String selectQuery = "SELECT * FROM users WHERE studentFacultyID = ? AND lastName = ? AND firstName = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setString(1, stuFaculID);
            selectStmt.setString(2, lname);
            selectStmt.setString(3, fname);

            // Execute the SELECT query
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, display a message indicating that the input already exists
            if (resultSet.next()) {
                message = "The Account already exists.";
            } else {
                // If no rows are returned, proceed with the insert operation
                String insertQuery = "INSERT INTO users (status, studentFacultyID, role, firstName, lastName, email, password, program, yearLvl, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, status);
                insertStmt.setString(2, stuFaculID);
                insertStmt.setString(3, role);
                insertStmt.setString(4, fname);
                insertStmt.setString(5, lname);
                insertStmt.setString(6, email);
                insertStmt.setString(7, pass);
                insertStmt.setString(8, program);
                insertStmt.setString(9, yrLvl);
                insertStmt.setString(10, department);

                // Execute the INSERT query
                insertStmt.executeUpdate();

                message = "User added successfully";
                System.out.println("Record inserted successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return message;
    }

    //METHODS FOR LOGIN
    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static String getUserDetails(String email, String password) {
        String userRole = "";
        String studFaculID;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            stmt.setString(1, email);
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                String storedHashedPassword = rsltSet.getString("password");
                if (ComLabMethods.verifyPassword(password, storedHashedPassword)) {
                    String fname = rsltSet.getString("firstName");
                    String lname = rsltSet.getString("lastname");
                    userRole = rsltSet.getString("role");
                    studFaculID = rsltSet.getString("studentfacultyID");
                    return studFaculID + "," + fname + "," + lname  + "," + userRole;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return "false";
    }

public static void logUserLogin(String stuFaculID, String fullName, String pass) {
    try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS logs (logID SERIAL PRIMARY KEY, "
                + "user_id INTEGER REFERENCES users(id), "
                + "fullname VARCHAR(255), "
                + "login_time TIMESTAMP DEFAULT (TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')), "
                + "logout_time TIMESTAMP DEFAULT (TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')))";

        try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
            statement.execute();
        }

        String insertQuery = "INSERT INTO logs (user_id, fullname) SELECT id, ? FROM users WHERE studentFacultyID = ? AND password = ?";

        try (PreparedStatement statement = conn.prepareStatement(insertQuery)) {
            statement.setString(1, fullName);
            statement.setString(2, stuFaculID);
            statement.setString(3, pass);
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    //ADMIN DASHBOARD
    //ACCOUNTS 
    public static List<Data> getAllStudentDatas() {
        List<Data> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'STUDENT' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String studentID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("userEmail");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");
                String userProgram = rsltSet.getString("program");
                String userYrLvl = rsltSet.getString("yrLvl");

                Data data = new Data(studentID, userEmail, userFname, userLname, userProgram, userYrLvl);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<Data> getAllFacultiesDatas() {
        List<Data> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'FACULTY' or role = 'ADMIN' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String facultyID = rsltSet.getString("studentfacultyID");
                String userDepartment = rsltSet.getString("department");
                String userEmail = rsltSet.getString("userEmail");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                Data data = new Data(facultyID, userDepartment, userEmail, userFname, userLname);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<Data> getAllLogs() {
        List<Data> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(("SELECT logs.logID, logs.login, logs.logout, logs.fullname, users.studentfacultyID AS sfID, users.role AS role, users.program AS program, users.yrlvl AS yrlvl, users.department AS department\n"
                + "FROM users\n"
                + "RIGHT JOIN logs ON users.userID = logs.userID;")); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int userLogsID = rsltSet.getInt("log_id");
                String studentfacultyID = rsltSet.getString("studentfacultyID");
                String userRole = rsltSet.getString("role");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yrlvl");
                String userDepartment = rsltSet.getString("department");
                String userFullname = rsltSet.getString("fullname");
                String userLogin = rsltSet.getString("login");
                String userLogout = rsltSet.getString("logout");

                Data data = new Data(userLogsID, studentfacultyID, userRole, userProgram, userYrlvl, userDepartment, userFullname, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    //Logout methods
    public static void logUserLogout(int userId) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String updateQuery = "UPDATE logs SET time_out = NOW() WHERE user_id = ? AND time_out IS NULL";

            try (PreparedStatement statement = conn.prepareStatement(updateQuery)) {
                statement.setInt(1, userId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
