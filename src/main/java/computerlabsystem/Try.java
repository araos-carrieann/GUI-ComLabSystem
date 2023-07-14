//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class PasswordRecovery {
//
//    public static void requestPasswordReset(String username) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            // Check if the username exists in the users table
//            int userId = getUserId(connection, username);
//
//            if (userId != -1) {
//                // Retrieve the security question for the user
//                String securityQuestion = getSecurityQuestion(connection, userId);
//
//                if (securityQuestion != null) {
//                    // Prompt the user to answer the security question
//                    String answer = getUserInput("Security Question: " + securityQuestion);
//
//                    // Verify the user's answer
//                    if (verifySecurityAnswer(connection, userId, answer)) {
//                        // Generate a unique recovery token
//                        String recoveryToken = generateRecoveryToken();
//
//                        // Set the expiration time (e.g., 1 hour from the current time)
//                        LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
//
//                        // Insert the recovery information into the password_recovery table
//                        insertRecoveryToken(connection, userId, recoveryToken, expirationTime);
//
//                        // Display the recovery token to the user
//                        System.out.println("Recovery Token: " + recoveryToken);
//                    } else {
//                        System.out.println("Security answer does not match.");
//                    }
//                } else {
//                    System.out.println("No security question set for the user.");
//                }
//            } else {
//                System.out.println("Username not found.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void resetPassword(String recoveryToken, String newPassword) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            // Check if the recovery token exists and is not expired or already used
//            boolean tokenValid = verifyRecoveryToken(connection, recoveryToken);
//
//            if (tokenValid) {
//                // Prompt the user to enter a new password
//                String newPassword = getUserInput("Enter a new password:");
//
//                // Update the user's password in the users table
//                updatePassword(connection, recoveryToken, newPassword);
//            } else {
//                System.out.println("Invalid or expired recovery token.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//
//    private static String getSecurityQuestion(Connection connection, int userId) throws SQLException {
//        String query = "SELECT question FROM security_questions WHERE user_id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, userId);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    return resultSet.getString("question");
//                }
//            }
//        }
//        return null;
//    }
//
//    private static boolean verifySecurityAnswer(Connection connection, int userId, String answer) throws SQLException {
//        String query = "SELECT COUNT(*) FROM security_questions WHERE user_id = ? AND answer = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, userId);
//            statement.setString(2, answer);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    int count = resultSet.getInt(1);
//                    return count > 0;
//                }
//            }
//        }
//        return false;
//    }
//private static void insertRecoveryToken(Connection connection, int userId, String recoveryToken, LocalDateTime expirationTime) throws SQLException {
//        String query = "INSERT INTO password_recovery (user_id, recovery_token, expiration_time, is_used) VALUES (?, ?, ?, false)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, userId);
//            statement.setString(2, recoveryToken);
//            statement.setObject(3, expirationTime);
//            statement.executeUpdate();
//        }
//    }
//
//    private static boolean verifyRecoveryToken(Connection connection, String recoveryToken) throws SQLException {
//        String query = "SELECT COUNT(*) FROM password_recovery WHERE recovery_token = ? AND expiration_time > NOW() AND is_used = false";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, recoveryToken);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    int count = resultSet.getInt(1);
//                    return count > 0;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static void updatePassword(Connection connection, String recoveryToken, String newPassword) throws SQLException {
//        String query = "UPDATE users SET password = ? WHERE user_id IN (SELECT user_id FROM password_recovery WHERE recovery_token = ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, newPassword);
//            statement.setString(2, recoveryToken);
//            statement.executeUpdate();
//        }
//
//        query = "UPDATE password_recovery SET is_used = true WHERE recovery_token = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, recoveryToken);
//            statement.executeUpdate();
//        }
//    }
//
//    private static String generateRecoveryToken() {
//        // Generate a random recovery token using a secure random generator
//        return UUID.randomUUID().toString();
//    }
//
//    private static String getUserInput(String prompt) {
//        // Implement the method to get user input from the desired source (e.g., command line, GUI)
//        // and return the user's response
//        return null;
//    }