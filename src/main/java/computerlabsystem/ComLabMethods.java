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

    public static String getUserDetails(String stuFaculID, String password) {
        String userRole = "";
        String studFaculID;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            stmt.setString(1, stuFaculID);
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                String storedHashedPassword = rsltSet.getString("password");
                if (ComLabMethods.verifyPassword(password, storedHashedPassword)) {
                    studFaculID = rsltSet.getString("studentfacultyID");
                    String fname = rsltSet.getString("firstName");
                    String lname = rsltSet.getString("lastName");
                    userRole = rsltSet.getString("role");

                    return studFaculID + "," + fname + "," + lname + "," + userRole;
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
                    + "logout_time TIMESTAMP, "
                    + "FOREIGN KEY (user_id) REFERENCES users(id))";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                statement.execute();
            }

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
                            String insertQuery = "INSERT INTO logs (user_id, fullname, login_time) VALUES (?, ?, DEFAULT)";
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
    public static List<Data> getAllStudentDatas() {
        List<Data> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'STUDENT' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                String studentID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");
                String userProgram = rsltSet.getString("program");
                String userYrLvl = rsltSet.getString("yearLvl");

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
                String userEmail = rsltSet.getString("email");
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
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(("SELECT logs.logID, logs.fullname, logs.login_time, logs.logout_time,\n"
                + "       users.studentfacultyID AS sfID, users.role AS userRole,\n"
                + "       users.program AS program, users.yearlvl AS yrlvl, users.department AS facultyDepartment\n"
                + "FROM users\n"
                + "RIGHT JOIN logs ON logs.user_id = users.id;")); ResultSet rsltSet = stmt.executeQuery()) {

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

                Data data = new Data(userLogsID, userRole, studentfacultyID, userFullname, userProgram, userYrlvl, userDepartment, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }//Delete

    public static void deleteAcct(String studentID) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String updateQuery = "UPDATE users SET status = 'DEACTIVATE' WHERE studentfacultyID = ?";

            try (PreparedStatement statement = conn.prepareStatement(updateQuery)) {
                statement.setString(1, studentID);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLogs(int logID) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM logs WHERE logID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, logID);
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting row from database: " + e.getMessage());
        }
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

    public static List<Data> programComboContent() {
        List<Data> programList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM program"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String program = rsltSet.getString("program");

                Data data = new Data(program, "null", "null");
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
            String createTableQuery = "CREATE TABLE IF NOT EXISTS yearLevel (yearLevel VARCHAR(5))";
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

    public static List<Data> yearlvlComboContent() {
        List<Data> yearLevelList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM yearLevel"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String yrlvl = rsltSet.getString("yearLevel");
                Data data = new Data("null", yrlvl, "null");
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

    public static List<Data> departmentComboContent() {
        List<Data> departmentList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM department"); ResultSet rsltSet = stmt.executeQuery()) {
            while (rsltSet.next()) {
                String department = rsltSet.getString("facultyDepartment");
                Data data = new Data(null, null, department);
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
}
