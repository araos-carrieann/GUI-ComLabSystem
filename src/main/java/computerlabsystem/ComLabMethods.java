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

    public static String registerUser(String status, String role, String studentFacultyID, String fname, String lname, String email, String pass, String program, String yrLvl, String department, String code) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, status VARCHAR(10) NOT NULL, studentFacultyID VARCHAR(10) NOT NULL, role VARCHAR(10) NOT NULL, firstName VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(60) NOT NULL, program VARCHAR(30), yearLvl VARCHAR(10), department VARCHAR(30), code VARCHAR(30))";
            stmt.executeUpdate(createTableQuery);

            // Prepare the SELECT query with parameters
            String selectQuery = "SELECT * FROM users WHERE studentFacultyID = ? AND lastName = ? AND firstName = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setString(1, studentFacultyID);
            selectStmt.setString(2, lname);
            selectStmt.setString(3, fname);

            // Execute the SELECT query
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, display a message indicating that the input already exists
            if (resultSet.next()) {
                message = "The Account already exists.";
            } else {
                // If no rows are returned, proceed with the insert operation
                String insertQuery = "INSERT INTO users (status, studentFacultyID, role, firstName, lastName, email, password, program, yearLvl, department, code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, status);
                insertStmt.setString(2, studentFacultyID);
                insertStmt.setString(3, role);
                insertStmt.setString(4, fname);
                insertStmt.setString(5, lname);
                insertStmt.setString(6, email);
                insertStmt.setString(7, pass);
                insertStmt.setString(8, program);
                insertStmt.setString(9, yrLvl);
                insertStmt.setString(10, department);
                insertStmt.setString(11, code);

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

    public static String getInfo(String stuFaculID) {
        String id = "";
        String userRole = "";
        String studFaculID = "";
        String program = "";
        String yearLevel = "";
        String department = "";

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            stmt.setString(1, stuFaculID);
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                id = rsltSet.getString("id");
                studFaculID = rsltSet.getString("studentfacultyID");
                String fname = rsltSet.getString("firstName");
                String lname = rsltSet.getString("lastName");
                String email = rsltSet.getString("email");
                program = rsltSet.getString("program");
                yearLevel = rsltSet.getString("yearLvl");
                department = rsltSet.getString("department");

                return id + "," + studFaculID + "," + fname + "," + lname + "," + email + "," + program + "," + yearLevel + "," + department;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return "";
    }

    public static String getUserDetails(String stuFaculID, String password) {

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            stmt.setString(1, stuFaculID);
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                String storedHashedPassword = rsltSet.getString("password");
                if (ComLabMethods.verifyPassword(password, storedHashedPassword)) {
                    String userRole = rsltSet.getString("role");
                    String studFaculID = rsltSet.getString("studentfacultyID");
                    String fname = rsltSet.getString("firstName");
                    String lname = rsltSet.getString("lastName");

                    return userRole + "," + studFaculID + "," + fname + "," + lname;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return "false";
    }

    public static String userChangePass(String stuFaculID, String password, String newPassword) {
        String msg = "";
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id, password FROM users WHERE studentFacultyID = ?")) {

            stmt.setString(1, stuFaculID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                int userId = rs.getInt("id");

                // Verify the password
                if (verifyPassword(password, hashedPassword)) {
                    // Update the user's password
                    String updateQuery = "UPDATE users SET password = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        String hashedNewPassword = hashPassword(newPassword);
                        updateStmt.setString(1, hashedNewPassword);
                        updateStmt.setInt(2, userId);
                        updateStmt.executeUpdate();
                        msg = "Password Changed Successfully";
                    }
                } else {
                    msg = "Password Didn't match";
                }
            } else {
                msg = "User not found";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static void createLogs() {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS logs (logID SERIAL PRIMARY KEY, "
                    + "user_id_users INTEGER REFERENCES users(id), "
                    + "user_id_visitors INTEGER REFERENCES visitors(id), "
                    + "fullname VARCHAR(255), "
                    + "login_time TIMESTAMP DEFAULT (TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')), "
                    + "logout_time TIMESTAMP)";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void logUserLogin(String stuFaculID, String fullName, String pass) {
        createLogs();
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Retrieve the user ID from the users table
            String selectUserIdQuery = "SELECT id, password FROM users WHERE studentFacultyID = ?";

            try (PreparedStatement selectUserIdStatement = conn.prepareStatement(selectUserIdQuery)) {
                // Set the value of the stuFaculID parameter in the query
                selectUserIdStatement.setString(1, stuFaculID);

                try (ResultSet rs = selectUserIdStatement.executeQuery()) {
                    // Check if there is at least one row in the result set
                    if (rs.next()) {
                        // Retrieve the hashed password from the result set
                        String hashedPassword = rs.getString("password");

                        // Retrieve the user ID from the result set
                        int userId = rs.getInt("id");

                        // Verify the password
                        if (verifyPassword(pass, hashedPassword)) {
                            // Insert log entry
                            String insertQuery = "INSERT INTO logs (user_id_users, fullname, login_time) VALUES (?, ?, DEFAULT)";
                            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                                insertStatement.setInt(1, userId);
                                insertStatement.setString(2, fullName);
                                insertStatement.executeUpdate();
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ADMIN DASHBOARD
    //ACCOUNTS 
    public static List<DTOaccount> getAllStudentDatas() {
        List<DTOaccount> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'STUDENT' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String studentID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");
                String userProgram = rsltSet.getString("program");
                String userYrLvl = rsltSet.getString("yearLvl");

                DTOaccount data = new DTOaccount(studentID, userEmail, userFname, userLname, userProgram, userYrLvl);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<DTOaccount> getAllFacultiesDatas() {
        List<DTOaccount> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'FACULTY' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String facultyID = rsltSet.getString("studentfacultyID");
                String userDepartment = rsltSet.getString("department");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                DTOaccount data = new DTOaccount(facultyID, userDepartment, userEmail, userFname, userLname);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    public static List<DTOaccount> getAllAdminDatas() {
        List<DTOaccount> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'ADMIN' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int id = rsltSet.getInt("id");
                String facultyID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                DTOaccount data = new DTOaccount(id, facultyID, userFname, userLname, userEmail);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    //Comboxes
    public static void programComboBox(String prog) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS program (program VARCHAR(100))";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                statement.execute();
            }

            String insertProgramQuery = "INSERT INTO program (program) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertProgramQuery)) {
                insertStatement.setString(1, prog);
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<DTOaccount> programComboContent() {
        List<DTOaccount> programList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM program"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String program = rsltSet.getString("program");

                DTOaccount data = new DTOaccount(program, "null", "null");
                programList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return programList;

    }

    public static void deleteProgram(String program) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM program WHERE program = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, program);
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting row from database: " + e.getMessage());
        }
    }

    public static void yearLevelComboBox(String lvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS yearLevel (yearLevel VARCHAR(10))";
            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                statement.execute();
            }
            String insertYrLvlQuery = "INSERT INTO yearLevel (yearLevel) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertYrLvlQuery)) {
                insertStatement.setString(1, lvl);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<DTOaccount> yearlvlComboContent() {
        List<DTOaccount> yearLevelList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM yearLevel"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String yrlvl = rsltSet.getString("yearLevel");
                DTOaccount data = new DTOaccount("null", yrlvl, "null");
                yearLevelList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        return yearLevelList;

    }

    public static void deleteYearLvl(String yrLvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM yearLevel WHERE yearLevel = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, yrLvl);
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting row from database: " + e.getMessage());
        }
    }

    public static void departmentComboBox(String department) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS department (facultyDepartment VARCHAR(100))";
            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                statement.execute();
            }
            String insertDepartmentQuery = "INSERT INTO department (facultyDepartment) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertDepartmentQuery)) {
                insertStatement.setString(1, department);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<DTOaccount> departmentComboContent() {
        List<DTOaccount> departmentList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM department"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String department = rsltSet.getString("facultyDepartment");
                DTOaccount data = new DTOaccount(null, null, department);
                departmentList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        return departmentList;
    }

    public static void deleteDepartment(String department) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM yearLevel WHERE yearLevel = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, department);
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting row from database: " + e.getMessage());
        }
    }

    public static String updateAccount(int id, String role, String stuFaculID, String firstName, String lastName, String email, String program, String yrLvl, String department) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM users WHERE studentFacultyID = ? AND id <> ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET studentFacultyID = ?, role = ?, firstName = ?, lastName = ?, email = ?, program = ?, yearLvl = ?, department = ? WHERE id = ?")) {

            // Set parameters for the SELECT statement
            selectStmt.setString(1, stuFaculID);
            selectStmt.setInt(2, id);

            // Execute the SELECT statement
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, display a message indicating that the studentFacultyID already exists
            if (resultSet.next()) {
                message = "The studentFacultyID already exists.";
            } else {
                // Set parameters for the UPDATE statement
                updateStmt.setString(1, stuFaculID);
                updateStmt.setString(2, role);
                updateStmt.setString(3, firstName);
                updateStmt.setString(4, lastName);
                updateStmt.setString(5, email);
                updateStmt.setString(6, program);
                updateStmt.setString(7, yrLvl);
                updateStmt.setString(8, department);
                updateStmt.setInt(9, id);

                // Execute the UPDATE statement
                updateStmt.executeUpdate();

                message = "Account updated successfully";
                System.out.println("Record updated successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return message;
    }

    public static int getUserID(String studentFacultyID) {
        int id = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE studentFacultyID = '" + studentFacultyID + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                id = rsltSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return id;
    }

    //home dashboard
    public static List<DTOaccount> mostLogs() {
        List<DTOaccount> userLogs = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT users.role, logs.fullname, COUNT(*) AS total_logs "
                + "FROM logs "
                + "JOIN users ON logs.user_id_users = users.id "
                + "GROUP BY users.role, logs.fullname "
                + "ORDER BY total_logs DESC "
                + "LIMIT 5"); ResultSet resultSet = selectStmt.executeQuery()) {

            while (resultSet.next()) {
                // Retrieve the role, fullname, and total_logs from the ResultSet
                String role = resultSet.getString("role");
                String fullname = resultSet.getString("fullname");
                int totalLogs = resultSet.getInt("total_logs");

                // Create a new instance of DTOaccount and add it to the userLogs list
                DTOaccount userLog = new DTOaccount(role, fullname, null, String.valueOf(totalLogs));
                userLogs.add(userLog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userLogs;
    }

    public static List<DTOaccount> longestTimeSpent() {
        List<DTOaccount> userSessions = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT users.role, fullname, EXTRACT(EPOCH FROM (logout_time - login_time)) AS session_duration "
                + "FROM logs "
                + "JOIN users ON logs.user_id_users = users.id "
                + "ORDER BY session_duration DESC "
                + "LIMIT 5"); ResultSet resultSet = selectStmt.executeQuery()) {

            while (resultSet.next()) {
                // Retrieve the role, fullname, and session_duration from the ResultSet
                String userRole = resultSet.getString("role");
                String userFullname = resultSet.getString("fullname");
                double sessionDurationInSeconds = resultSet.getDouble("session_duration");

                // Convert session duration to hours, minutes, and seconds
                int hours = (int) (sessionDurationInSeconds / 3600);
                int minutes = (int) ((sessionDurationInSeconds % 3600) / 60);
                int seconds = (int) (sessionDurationInSeconds % 60);

                // Create a new instance of DTOaccount and add it to the userSessions list
                DTOaccount data = new DTOaccount(userRole, userFullname, String.format("%02d:%02d:%02d", hours, minutes, seconds), null);
                userSessions.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userSessions;
    }

    public static int getVisitorID(String codeIdentity) {
        int id = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM visitors WHERE codeidentity = '" + codeIdentity + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                id = rsltSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return id;
    }
    
        public static String getStudentFacultyID(String email) {
        String studentFacultyID = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT studentFacultyID FROM users WHERE email = '" + email + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                studentFacultyID = rsltSet.getString("studentFacultyID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return studentFacultyID;
    }

        public static String getUpdatedCode(String email) {
        String code = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT code FROM users WHERE email = '" + email + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                code = rsltSet.getString("code");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return code;
    }
}
