/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

//import the needed libraries
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.mindrot.jbcrypt.BCrypt;
import scroll.ScrollBarCustom;
import java.awt.Dimension;

/**
 *
 * @author araos
 */
public class ComLabMethods {

    /*
    1. hashPassword
    2. verifyPassword
    3. registerUser
    4. getInfo (for Admin and User profile)
    5. getUserDetails
    6. userChangePass
    7. createLogs
    8. logUserLogin
    9.
    10. 
    11. 
    
     */
    // Hashes the password using BCrypt with a work factor of 12 and returns the hashed value
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    // Verifies if the provided plaintext password matches the given hashed password
    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static boolean registerUser(String status, String role, String studentFacultyID, String fname, String lname, String email, String pass, String program, String yrLvl, String department, String code) {
        boolean success = false;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, status VARCHAR(10) NOT NULL, studentFacultyID VARCHAR(10) NOT NULL, role VARCHAR(10) NOT NULL, firstName VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(60) NOT NULL, program VARCHAR(30), yearLvl VARCHAR(10), department VARCHAR(30), code VARCHAR(30))";
            stmt.executeUpdate(createTableQuery);

            // Prepare the SELECT query with parameters
            String selectQuery = "SELECT * FROM users WHERE studentFacultyID = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setString(1, studentFacultyID);

            // Execute the SELECT query
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, set success to false
            if (resultSet.next()) {
                success = false;
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

                success = true;
                System.out.println("Record inserted successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return success;
    }

    // Retrieves user information based on the provided student/faculty ID from the database
    public static String getInfo(String stuFaculID) {
        // Initialize variables to store user information
        String id = "";
        String studFaculID = "";
        String program = "";
        String yearLevel = "";
        String department = "";

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            // Set the student/faculty ID as a parameter in the SQL query
            stmt.setString(1, stuFaculID);
            // Execute the query and retrieve the result set
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                // Extract user information from the result set
                id = rsltSet.getString("id");
                studFaculID = rsltSet.getString("studentfacultyID");
                String fname = rsltSet.getString("firstName");
                String lname = rsltSet.getString("lastName");
                String email = rsltSet.getString("email");
                program = rsltSet.getString("program");
                yearLevel = rsltSet.getString("yearLvl");
                department = rsltSet.getString("department");

                // Concatenate user information into a single string and return it
                return id + "," + studFaculID + "," + fname + "," + lname + "," + email + "," + program + "," + yearLevel + "," + department;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return an empty string if no matching user information found
        return "";
    }

// Retrieves user details from the database based on the provided student/faculty ID and password
    public static String getUserDetails(String stuFaculID, String password) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            // Set the student/faculty ID as a parameter in the SQL query
            stmt.setString(1, stuFaculID);
            // Execute the query and retrieve the result set
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                // Extract the stored hashed password from the result set
                String storedHashedPassword = rsltSet.getString("password");
                // Verify if the provided password matches the stored hashed password
                if (ComLabMethods.verifyPassword(password, storedHashedPassword)) {
                    // If password verification is successful, extract user details from the result set
                    String status = rsltSet.getString("status");
                    String userRole = rsltSet.getString("role");
                    String studFaculID = rsltSet.getString("studentfacultyID");
                    String fname = rsltSet.getString("firstName");
                    String lname = rsltSet.getString("lastName");

                    // Concatenate user details into a single string and return it
                    return status + "," + userRole + "," + studFaculID + "," + fname + "," + lname;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return "false" if no matching user details found or if the provided password doesn't match the stored hashed password
        return "false";
    }

    // Changes the user's password in the database based on the provided student/faculty ID, current password, and new password
    public static String userChangePass(String stuFaculID, String password, String newPassword) {
        // Initialize a variable to store the result message
        String msg = "";
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id, password FROM users WHERE studentFacultyID = ?")) {

            // Set the student/faculty ID as a parameter in the SQL query
            stmt.setString(1, stuFaculID);
            // Execute the query and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Extract the stored hashed password and user ID from the result set
                String hashedPassword = rs.getString("password");
                int userId = rs.getInt("id");

                // Verify if the provided password matches the stored hashed password
                if (verifyPassword(password, hashedPassword)) {
                    // Update the user's password in the database
                    String updateQuery = "UPDATE users SET password = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        String hashedNewPassword = hashPassword(newPassword);
                        // Set the new hashed password and user ID as parameters in the update query
                        updateStmt.setString(1, hashedNewPassword);
                        updateStmt.setInt(2, userId);
                        // Execute the update query to change the password
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
        // Return a message indicating the result of the password change process
        return msg;
    }

    // Logs user login activity in the database based on the provided student/faculty ID, full name, and password
    public static void logUserLogin(String stuFaculID, String fullName, String pass) {
        // Create the "logs" table if it doesn't exist
        LogsDAO.createLogs();
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Retrieve the user ID from the users table along with status and hashed password
            String selectUserIdQuery = "SELECT id, status, password FROM users WHERE studentFacultyID = ?";

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

                        // Verify the provided password against the stored hashed password
                        if (verifyPassword(pass, hashedPassword)) {
                            // Insert a log entry for successful login
                            String insertQuery = "INSERT INTO logs (user_id_users, fullname, login_time) VALUES (?, ?, DEFAULT)";
                            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                                insertStatement.setInt(1, userId);
                                insertStatement.setString(2, fullName);
                                // Use the default value for login_time (current timestamp) in the query
                                insertStatement.executeUpdate();
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves a list of all active student account data from the database
    public static List<AccountDTO> getAllStudentDatas() {
        // Create an empty list to store the retrieved student data
        List<AccountDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'STUDENT' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve data for each student
            while (rsltSet.next()) {
                // Extract relevant information for each student
                String studentID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");
                String userProgram = rsltSet.getString("program");
                String userYrLvl = rsltSet.getString("yearLvl");

                // Create an AccountDTO object and add it to the list
                AccountDTO data = new AccountDTO(studentID, userEmail, userFname, userLname, userProgram, userYrLvl);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of student account data
        return dataList;
    }

// Retrieves a list of all active faculty account data from the database
    public static List<AccountDTO> getAllFacultiesDatas() {
        // Create an empty list to store the retrieved faculty data
        List<AccountDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'FACULTY' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve data for each faculty member
            while (rsltSet.next()) {
                // Extract relevant information for each faculty member
                String facultyID = rsltSet.getString("studentfacultyID");
                String userDepartment = rsltSet.getString("department");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                // Create an AccountDTO object and add it to the list
                AccountDTO data = new AccountDTO(facultyID, userDepartment, userEmail, userFname, userLname);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of faculty account data
        return dataList;
    }

    public static List<AccountDTO> getAllAdminDatas() {
        List<AccountDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'ADMIN' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int id = rsltSet.getInt("id");
                String facultyID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                AccountDTO data = new AccountDTO(id, facultyID, userFname, userLname, userEmail);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    //Comboxes
    // Adds a program option to the program combobox in the database
    public static void programComboBox(String prog) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the "program" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS program (program VARCHAR(100))";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "program" table
                statement.execute();
            }

            // Insert the new program option into the "program" table
            String insertProgramQuery = "INSERT INTO program (program) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertProgramQuery)) {
                // Set the program name as a parameter in the insert query
                insertStatement.setString(1, prog);
                // Execute the query to insert the program into the table
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }
    // Retrieves the content of the program combobox from the "program" table in the database

    public static List<AccountDTO> programComboContent() {
        // Create an empty list to store the retrieved program options
        List<AccountDTO> programList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM program"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve program options
            while (rsltSet.next()) {
                // Extract the program option from the result set
                String program = rsltSet.getString("program");

                // Create an AccountDTO object with the program option and "null" values for unused fields
                AccountDTO data = new AccountDTO(program, "null", "null");
                programList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of program options
        return programList;
    }

    // Deletes a program option from the "program" table in the database
    public static void deleteProgram(String program) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Prepare the SQL delete query
            String sql = "DELETE FROM program WHERE program = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set the program name as a parameter in the delete query
            statement.setString(1, program);
            // Execute the delete query to remove the program option from the table
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            // Handle the exception by printing the error message
            System.out.println("Error deleting row from the database: " + e.getMessage());
        }
    }

    // Adds a year level option to the year level combobox in the database
    public static void yearLevelComboBox(String lvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the "yearLevel" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS yearLevel (yearLevel VARCHAR(10))";
            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "yearLevel" table
                statement.execute();
            }
            // Insert the new year level option into the "yearLevel" table
            String insertYrLvlQuery = "INSERT INTO yearLevel (yearLevel) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertYrLvlQuery)) {
                // Set the year level as a parameter in the insert query
                insertStatement.setString(1, lvl);
                // Execute the query to insert the year level into the table
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves the content of the year level combobox from the "yearLevel" table in the database
    public static List<AccountDTO> yearlvlComboContent() {
        // Create an empty list to store the retrieved year level options
        List<AccountDTO> yearLevelList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM yearLevel"); ResultSet rsltSet = stmt.executeQuery()) {
            // Iterate through the result set to retrieve year level options
            while (rsltSet.next()) {
                // Extract the year level from the result set
                String yrlvl = rsltSet.getString("yearLevel");
                // Create an AccountDTO object with the year level and "null" values for unused fields
                AccountDTO data = new AccountDTO("null", yrlvl, "null");
                yearLevelList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        // Return the list of year level options
        return yearLevelList;
    }

    // Deletes a year level option from the "yearLevel" table in the database
    public static void deleteYearLvl(String yrLvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Prepare the SQL delete query
            String sql = "DELETE FROM yearLevel WHERE yearLevel = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set the year level as a parameter in the delete query
            statement.setString(1, yrLvl);
            // Execute the delete query to remove the year level option from the table
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            // Handle the exception by printing the error message
            System.out.println("Error deleting row from the database: " + e.getMessage());
        }
    }

    // Adds a department option to the department combobox in the database
    public static void departmentComboBox(String department) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the "department" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS department (facultyDepartment VARCHAR(100))";
            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "department" table
                statement.execute();
            }
            // Insert the new department option into the "department" table
            String insertDepartmentQuery = "INSERT INTO department (facultyDepartment) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertDepartmentQuery)) {
                // Set the department name as a parameter in the insert query
                insertStatement.setString(1, department);
                // Execute the query to insert the department into the table
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves the content of the department combobox from the "department" table in the database
    public static List<AccountDTO> departmentComboContent() {
        // Create an empty list to store the retrieved department options
        List<AccountDTO> departmentList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM department"); ResultSet rsltSet = stmt.executeQuery()) {
            // Iterate through the result set to retrieve department options
            while (rsltSet.next()) {
                // Extract the department from the result set
                String department = rsltSet.getString("facultyDepartment");
                // Create an AccountDTO object with the department and "null" values for unused fields
                AccountDTO data = new AccountDTO(null, null, department);
                departmentList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        // Return the list of department options
        return departmentList;
    }

    // Deletes a department option from the "department" table in the database
    public static void deleteDepartment(String department) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Prepare the SQL delete query
            String sql = "DELETE FROM department WHERE facultyDepartment = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set the department name as a parameter in the delete query
            statement.setString(1, department);
            // Execute the delete query to remove the department option from the table
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            // Handle the exception by printing the error message
            System.out.println("Error deleting row from the database: " + e.getMessage());
        }
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

    // Retrieves a list of AccountDTO objects representing users with the most logs from the "logs" table in the database
    public static List<AccountDTO> mostLogs() {
        // Create an empty list to store user logs
        List<AccountDTO> userLogs = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT users.role, logs.fullname, COUNT(*) AS total_logs "
                + "FROM logs "
                + "JOIN users ON logs.user_id_users = users.id "
                + "GROUP BY users.role, logs.fullname "
                + "ORDER BY total_logs DESC "
                + "LIMIT 5"); ResultSet resultSet = selectStmt.executeQuery()) {

            // Iterate through the result set to retrieve users with the most logs
            while (resultSet.next()) {
                // Retrieve the role, fullname, and total_logs from the ResultSet
                String role = resultSet.getString("role");
                String fullname = resultSet.getString("fullname");
                int totalLogs = resultSet.getInt("total_logs");

                // Create a new instance of AccountDTO and add it to the userLogs list
                AccountDTO userLog = new AccountDTO(role, fullname, null, String.valueOf(totalLogs));
                userLogs.add(userLog);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of AccountDTO objects representing users with the most logs
        return userLogs;
    }

    // Retrieves a list of AccountDTO objects representing users with the longest session duration from the "logs" table in the database
    public static List<AccountDTO> longestTimeSpent() {
        // Create an empty list to store user sessions
        List<AccountDTO> userSessions = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT users.role, fullname, EXTRACT(EPOCH FROM (logout_time - login_time)) AS session_duration\n"
                + "FROM logs\n"
                + "JOIN users ON logs.user_id_users = users.id\n"
                + "WHERE users.status = 'ACTIVE'\n"
                + "ORDER BY session_duration ASC\n"
                + "LIMIT 5;"); ResultSet resultSet = selectStmt.executeQuery()) {

            // Iterate through the result set to retrieve users with the longest session duration
            while (resultSet.next()) {
                // Retrieve the role, fullname, and session_duration from the ResultSet
                String userRole = resultSet.getString("role");
                String userFullname = resultSet.getString("fullname");
                double sessionDurationInSeconds = resultSet.getDouble("session_duration");

                // Convert session duration to hours, minutes, and seconds
                int hours = (int) (sessionDurationInSeconds / 3600);
                int minutes = (int) ((sessionDurationInSeconds % 3600) / 60);
                int seconds = (int) (sessionDurationInSeconds % 60);

                // Create a new instance of AccountDTO and add it to the userSessions list
                AccountDTO data = new AccountDTO(userRole, userFullname, String.format("%02d:%02d:%02d", hours, minutes, seconds), null);
                userSessions.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of AccountDTO objects representing users with the longest session duration
        return userSessions;
    }

    // Retrieves the visitor ID from the "visitors" table based on the given code identity
    public static int getVisitorID(String codeIdentity) {
        int id = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM visitors WHERE codeidentity = '" + codeIdentity + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve the visitor ID from the result set
            while (rsltSet.next()) {
                id = rsltSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return id;
    }

// Retrieves the student or faculty ID from the "users" table based on the given email
    public static String getStudentFacultyID(String email) {
        String studentFacultyID = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT studentFacultyID FROM users WHERE email = '" + email + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve the student or faculty ID from the result set
            while (rsltSet.next()) {
                studentFacultyID = rsltSet.getString("studentFacultyID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return studentFacultyID;
    }

// Retrieves the updated code from the "users" table based on the given email
    public static String getUpdatedCode(String email) {
        String code = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT code FROM users WHERE email = '" + email + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve the updated code from the result set
            while (rsltSet.next()) {
                code = rsltSet.getString("code");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return code;
    }

    // Checks if the given email exists in the "users" table in the database
    public static boolean isEmailExistsInDatabase(String email) {
        boolean emailExists = false;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM users WHERE email = ?")) {

            // Set the email as a parameter in the query
            stmt.setString(1, email);
            try (ResultSet rsltSet = stmt.executeQuery()) {
                // If the result set has at least one row, the email exists in the database
                emailExists = rsltSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return emailExists;
    }

    // Retrieves the total number of rows in the "users" table
    public static int getTotalUserRows() {
        int totalRows = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS total_rows FROM users"); ResultSet rs = stmt.executeQuery()) {

            // Retrieve the total number of rows from the result set
            if (rs.next()) {
                totalRows = rs.getInt("total_rows");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return totalRows;
    }

    // Retrieves the total number of active users (users with a null logout_time) from the "logs" table
    public static int getTotalActiveUser() {
        int totalActive = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS total_active FROM logs WHERE logout_time IS NULL;"); ResultSet rs = stmt.executeQuery()) {

            // Retrieve the total number of active users from the result set
            if (rs.next()) {
                totalActive = rs.getInt("total_active");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return totalActive;
    }

    // Retrieves a list of AccountDTO objects representing professors and administrators for the combo box
    public static List<AccountDTO> professorComboContent() {
        List<AccountDTO> yearLevelList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT CONCAT(lastname, ', ', firstname) AS accountablename\n"
                + "FROM users\n"
                + "WHERE role = 'FACULTY' OR role = 'ADMIN';"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve professors and administrators' names from the result set
            while (rsltSet.next()) {
                String accountablename = rsltSet.getString("accountablename");
                AccountDTO data = new AccountDTO(accountablename);
                yearLevelList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        return yearLevelList;
    }

    // Retrieves the email of the accountable user (professor or administrator) based on their last name and first name
    public static String getAccountableEmail(String lastname, String firstname) {
        String email = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT email FROM users WHERE lastname = ? AND firstname = ?")) {

            // Set the last name and first name as parameters in the query
            stmt.setString(1, lastname);
            stmt.setString(2, firstname);

            try (ResultSet rsltSet = stmt.executeQuery()) {
                // Retrieve the email from the result set
                if (rsltSet.next()) {
                    email = rsltSet.getString("email");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return email;
    }

    // Updates the faculty accountable field in the logs table for a specific student
    void updateLogsFacultyAccountable(String accountableName, String studentFacultyID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "UPDATE logs SET facultyAccountable = ? "
                + "WHERE user_id_users = (SELECT id FROM users WHERE studentFacultyID = ?) "
                + "AND logout_time IS NULL")) {

            // Set the faculty accountable name and student faculty ID as parameters in the query
            stmt.setString(1, accountableName);
            stmt.setString(2, studentFacultyID);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves the login time of a specific student based on their studentFacultyID
    public String getTimeLogin(String studentFacultyID) {
        String loginTime = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT login_time FROM logs "
                + "WHERE user_id_users = (SELECT id FROM users WHERE studentFacultyID = ?) "
                + "AND logout_time IS NULL")) {

            // Set the studentFacultyID as a parameter in the query
            stmt.setString(1, studentFacultyID);

            try (ResultSet rs = stmt.executeQuery()) {
                // Retrieve the login time from the result set
                if (rs.next()) {
                    loginTime = rs.getString("login_time");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        return loginTime;
    }

    // Sets custom vertical and horizontal scroll bars for a JScrollPane
    public void Scroll(JScrollPane pane) {
        // Set the custom vertical scroll bar
        pane.setVerticalScrollBar(new ScrollBarCustom());
        // Set the custom horizontal scroll bar
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        pane.setHorizontalScrollBar(sp);
    }

    // Customizes the appearance of a JTable's header
    public void Table(JTable table) {
        // Set font and appearance for table header
        table.getTableHeader().setFont(new Font("Segui UI", Font.BOLD, 14));
        // Set height of the table header
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getPreferredSize().width, 30));
    }

}
