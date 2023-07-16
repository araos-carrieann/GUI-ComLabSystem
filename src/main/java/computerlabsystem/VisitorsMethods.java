/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import static computerlabsystem.ComLabMethods.verifyPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author araos
 */
public class VisitorsMethods {

    public static String visitorsInfo(String role, String fullname, String mobileNumber, String email, String gender, String purpose) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS visitors (id SERIAL PRIMARY KEY, role VARCHAR(10) NOT NULL, fullname VARCHAR(50) NOT NULL, mobileNumber VARCHAR(15) NOT NULL, email VARCHAR(100) NOT NULL, gender VARCHAR(30) NOT NULL, purpose VARCHAR(150))";
            stmt.executeUpdate(createTableQuery);

            // Prepare the INSERT query
            String insertQuery = "INSERT INTO visitors (role, fullname, mobileNumber, email, gender, purpose) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, role);
            insertStmt.setString(2, fullname);
            insertStmt.setString(3, mobileNumber);
            insertStmt.setString(4, email);
            insertStmt.setString(5, gender);
            insertStmt.setString(6, purpose);

            // Execute the INSERT query
            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted > 0) {
                message = "Visitor added successfully";
                System.out.println("Record inserted successfully.");
            } else {
                message = "Failed to add visitor";
                System.out.println("Failed to insert the record.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return message;
    }

    public void visitorLogs(String fullname, String mobileNumber, String email) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Retrieve the user ID from the visitors table
            String selectUserIdQuery = "SELECT id FROM visitors WHERE email = ? AND mobileNumber = ?";

            try (PreparedStatement selectUserIdStatement = conn.prepareStatement(selectUserIdQuery)) {
                // Set the values of the email and mobileNumber parameters in the query
                selectUserIdStatement.setString(1, email);
                selectUserIdStatement.setString(2, mobileNumber);

                try (ResultSet rs = selectUserIdStatement.executeQuery()) {
                    // Check if there is at least one row in the result set
                    if (rs.next()) {
                        // Retrieve the user ID from the result set
                        int userId = rs.getInt("id");

                        // Insert the log entry into the logs table
                        String insertQuery = "INSERT INTO logs (user_id_visitors , fullname, login_time) VALUES (?, ?, DEFAULT)";

                        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                            insertStatement.setInt(1, userId);
                            insertStatement.setString(2, fullname);
                            insertStatement.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

}
