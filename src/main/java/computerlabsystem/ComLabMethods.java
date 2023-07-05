/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static String registerUser(String status, String role, String fname, String lname, String email, String pass, String program, String yrLvl) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
           String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, status VARCHAR(10) NOT NULL, role VARCHAR(10) NOT NULL, firstName VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(60) NOT NULL,  program VARCHAR(30) NOT NULL,  yearLvl VARCHAR(10) NOT NULL)";
            stmt.executeUpdate(createTableQuery);

            String selectQuery = "SELECT * FROM users WHERE firstName = '" + fname + "' AND lastName = '" + lname + "' AND password = '" + pass + "'";
            try (ResultSet resultSet = stmt.executeQuery(selectQuery)) {
                // If a row is returned, display a message indicating that the input already exists
                if (resultSet.next()) {
                    message = "The username already exists.";
                } else {
                    // If no rows are returned, proceed with the insert operation
                    String insertQuery = "INSERT INTO users (status, role, firstName, lastName, email, password, program, yearLvl) VALUES ('" + status + "', '" + role + "', '" + fname + "','" + lname + "', '" + email + "', '" + pass + "', '" + program + "', '" + yrLvl + "')";
                    stmt.executeUpdate(insertQuery);
                    message =  "User added successfully";
                    System.out.println("Record inserted successfully.");
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return message;
    }

    //METHODS FOR LOGIN
}
