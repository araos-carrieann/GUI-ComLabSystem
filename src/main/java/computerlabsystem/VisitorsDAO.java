/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author araos
 */
public class VisitorsDAO {

    public static void createVisitorsTable() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS visitors (id SERIAL PRIMARY KEY, codeidentity VARCHAR(20), fullname VARCHAR(50) NOT NULL, mobileNumber VARCHAR(15) NOT NULL, email VARCHAR(100) NOT NULL, gender VARCHAR(30) NOT NULL, purpose VARCHAR(150))";
            try (PreparedStatement stmt = conn.prepareStatement(createTableQuery)) {
                stmt.executeUpdate();
                System.out.println("Visitors table created successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            System.out.println("Failed to create visitors table.");
        }
    }

    public static String insertVisitorData(String codeidentity, String fullname, String mobileNumber, String email, String gender, String purpose) {
        String message = null;

        try (Connection conn = DatabaseConnector.getConnection()) {
            String insertQuery = "INSERT INTO visitors (codeidentity, fullname, mobileNumber, email, gender, purpose) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, codeidentity);
                insertStmt.setString(2, fullname);
                insertStmt.setString(3, mobileNumber);
                insertStmt.setString(4, email);
                insertStmt.setString(5, gender);
                insertStmt.setString(6, purpose);

                int rowsInserted = insertStmt.executeUpdate();

                if (rowsInserted > 0) {
                    message = "Visitor added successfully";
                    System.out.println("Record inserted successfully.");
                } else {
                    message = "Failed to add visitor";
                    System.out.println("Failed to insert the record.");
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            message = "Failed to add visitor";
            System.out.println("Failed to insert the record.");
        } catch (Exception exc) {
            exc.printStackTrace();
            message = "An unexpected error occurred";
            System.out.println("An unexpected error occurred.");
        }
        return message;
    }

    public static String VisitorInsertLog(int userId, String fullName) {
        LogsDAO.createLogs();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String insertQuery = "INSERT INTO logs (user_id_visitors, fullname, login_time) VALUES (?, ?, DEFAULT)";

            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                insertStatement.setInt(1, userId);
                insertStatement.setString(2, fullName);
                insertStatement.executeUpdate();
                System.out.println("Log entry added successfully.");
                return "Log entry added successfully";
            } catch (SQLException exc) {
                exc.printStackTrace();
                System.out.println("Failed to add log entry.");
                return "Failed to add log entry";
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
            System.out.println("Failed to connect to the database.");
            return "Failed to connect to the database";
        }
    }

    public boolean isValidMobileNumber(String input) {
        String number = input.replaceAll("[^0-9]", "");

        if ((number.startsWith("+63") || number.startsWith("0")) && number.substring(1).matches("\\d+") && number.length() >= 10 && number.length() <= 15) {
            // Valid mobile number
            return true;
        } else {
            // Invalid mobile number
            return false;
        }
    }

    public static void visitorsLogout(String codeidentity) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT id FROM visitors WHERE codeidentity = ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE logs SET logout_time = CURRENT_TIMESTAMP WHERE user_id_visitors = ? AND logout_time IS NULL")) {

            // Set the parameter for the SELECT query
            selectStmt.setString(1, codeidentity);

            // Execute the SELECT query to get the user_id_visitors
            try (ResultSet resultSet = selectStmt.executeQuery()) {
                if (resultSet.next()) {
                    int userIdVisitors = resultSet.getInt("id");

                    // Set the parameter for the UPDATE query
                    updateStmt.setInt(1, userIdVisitors);

                    // Execute the UPDATE query to set the logout_time
                    updateStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
