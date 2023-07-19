/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author araos
 */
public class DAOaccount {

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

}
