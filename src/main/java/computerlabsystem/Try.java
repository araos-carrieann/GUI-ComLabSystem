//public static String updateAccount(int id, String role, String stuFaculID, String lastName, String firstName, String email, String program, String yrLvl, String department) {
//    String message = null;
//    try (Connection conn = DatabaseConnector.getConnection(); 
//PreparedStatement selectStmt = conn.prepareStatement("SELECT id FROM users WHERE studentFacultyID = ? AND id <> ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET studentFacultyID = ?, role = ?, firstName = ?, lastName = ?, email = ?, program = ?, yearLvl = ?, department = ? WHERE id = ?")) {
//
//        // Set parameters for the SELECT statement
//        selectStmt.setString(1, stuFaculID);
//        selectStmt.setInt(2, id);
//
//        // Execute the SELECT statement
//        ResultSet resultSet = selectStmt.executeQuery();
//
//        // If a row is returned, display a message indicating that the studentFacultyID already exists
//        if (resultSet.next()) {
//            message = "The studentFacultyID already exists.";
//        } else {
//            // Set parameters for the UPDATE statement
//            updateStmt.setString(1, stuFaculID);
//            updateStmt.setString(2, role);
//            updateStmt.setString(3, firstName);
//            updateStmt.setString(4, lastName);
//            updateStmt.setString(5, email);
//            updateStmt.setString(6, program);
//            updateStmt.setString(7, yrLvl);
//            updateStmt.setString(8, department);
//            updateStmt.setInt(9, id);
//
//            // Execute the UPDATE statement
//            updateStmt.executeUpdate();
//
//            message = "Account updated successfully";
//            System.out.println("Record updated successfully.");
//        }
//    } catch (SQLException exc) {
//        exc.printStackTrace();
//    }
//    return message;
//}
