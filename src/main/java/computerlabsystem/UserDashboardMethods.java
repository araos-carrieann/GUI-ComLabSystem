/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author araos
 */
public class UserDashboardMethods {

    public static int getTotalLogsByUser(int userId) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS totalLogs FROM logs WHERE user_id_users = ?")) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("totalLogs");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static Duration getTotalTimeSpentByUser(int userId) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT login_time, logout_time FROM logs WHERE user_id_users = ?")) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            Duration totalTimeSpent = Duration.ZERO;

            while (rs.next()) {
                Timestamp loginTime = rs.getTimestamp("login_time");
                Timestamp logoutTime = rs.getTimestamp("logout_time");

                if (loginTime != null && logoutTime != null) {
                    LocalDateTime timeIn = loginTime.toLocalDateTime();
                    LocalDateTime timeOut = logoutTime.toLocalDateTime();

                    Duration duration = Duration.between(timeIn, timeOut);
                    totalTimeSpent = totalTimeSpent.plus(duration);
                }
            }

            return totalTimeSpent;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Duration.ZERO;
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void userLogout(String stuFaculID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE logs SET logout_time = TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYY-MM-DD HH24:MI:SS'),'YYY-MM-DD HH24:MI:SS') WHERE user_id_users = (SELECT id FROM users WHERE studentFacultyID = ?) AND logout_time IS NULL")) {
            stmt.setString(1, stuFaculID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public static void visitorsLogout(String codeidentity) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE logs SET logout_time = TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYY-MM-DD HH24:MI:SS'),'YYY-MM-DD HH24:MI:SS') WHERE user_id_visitors = (SELECT id FROM logs WHERE codeidentity = ?) AND logout_time IS NULL")) {
            stmt.setString(1, codeidentity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
