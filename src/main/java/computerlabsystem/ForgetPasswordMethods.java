/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computerlabsystem;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import com.google.api.services.gmail.model.Message;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author araos
 */
public class ForgetPasswordMethods {

    private static final String EMAIL = "pupschoolpurposes@gmail.com";

    public static void updatePassword(String password, String code) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM users WHERE code = ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET password = ? WHERE code = ?")) {

            // Set parameters for the SELECT statement
            selectStmt.setString(1, code);

            // Execute the SELECT statement
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, it means the provided code exists, so proceed with the update
            if (resultSet.next()) {
                // Set parameters for the UPDATE statement
                updateStmt.setString(1, password);
                updateStmt.setString(2, code);

                // Execute the UPDATE statement
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully");
                } else {
                    System.out.println("Failed to update password");
                }
            } else {
                System.out.println("Invalid code. Password update failed.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public static void updateCode(String code, String studentFacultyID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM users WHERE studentFacultyID = ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET code = ? WHERE studentFacultyID = ?")) {

            // Set parameters for the SELECT statement
            selectStmt.setString(1, studentFacultyID);

            // Execute the SELECT statement
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, update the code for the existing studentFacultyID
            if (resultSet.next()) {
                // Set parameters for the UPDATE statement
                updateStmt.setString(1, code);
                updateStmt.setString(2, studentFacultyID);

                // Execute the UPDATE statement
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Code updated successfully");
                    System.out.println("Record updated successfully.");
                } else {
                    System.out.println("Failed to update code");
                    System.out.println("Failed to update the record.");
                }
            } else {
                System.out.println("StudentFacultyID not found. Code update failed.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public static String generateCode() {
        // Generate a random recovery code
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        // Load client secrets.
        File file = new File("C:\\Users\\araos\\Documents\\NetBeansProjects\\ComputerLabSystem\\src\\main\\java\\computerlabsystem\\mailerAPI\\client_secret_154140134592-t3o5q6qn83ciotu874r9aouhlnc27m66.apps.googleusercontent.com.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new FileReader(file));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
    }

    public String getName(String email) {
        String firstName = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT firstName FROM users WHERE email = ?")) {

            stmt.setString(1, email); // Set the email parameter using a parameterized query

            try (ResultSet rsltSet = stmt.executeQuery()) {
                if (rsltSet.next()) {
                    firstName = rsltSet.getString("firstName");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return firstName;
    }

    public void sendMail(String receiver, String name, String studentFacultyID) throws Exception {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        Gmail service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("My Mailer")
                .build();

        // Create the email content
        String code = generateCode();
        updateCode(code, studentFacultyID);

        String messageSubject = "Password Reset Verification Code";
        String bodyText = "Hello " + name + ",\n"
                + "\n"
                + "We've received a request to reset the password associated with your account. To proceed with the password reset, please enter the following verification code:\n"
                + "\n"
                + "Verification Code: " + code + "\n"
                + "\n"
                + "If you didn't initiate this request, you can safely ignore this email.\n"
                + "\n"
                + "If you are the one requesting the password reset, please copy the verification code and paste it into the password reset page on our system. You will then be prompted to create a new password.\n"
                + "\n"
                + "If you have any questions or need further assistance, feel free to contact our support team at pupschoolpurposes@gmail.com. We're here to help!\n"
                + "\n"
                + "Best regards,\n"
                + "PUP Unisan Branch";

        // Encode as MIME msg
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(EMAIL));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(receiver));
        email.setSubject(messageSubject);
        email.setText(bodyText);

        // Encode and wrap the MIME msg into a gmail msg
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            // Create send msg
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }

    public void sendMailToAccountableFaculty(String receiver, String name, String studentName, String dateTime) throws Exception {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        Gmail service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("My Mailer")
                .build();

        // Create the email content

        String messageSubject = " Urgent: User Logged in Under Your Name ";
        String bodyText = "Dear Professor "+ name + ",\n"
                + "\n"
                + "We hope this email finds you well. We wanted to inform you that a user recently accessed our ComLab platform, and they specified that they are under your care or affiliation.\n"
                + "\n"
                + "User Details:\n"
                + "\n"
                + "Username:" + studentName + "\n"
                + "Date and Time: "+ dateTime + "\n"
                + "\n"
                + "If you are aware of this association and have authorized the user's access, no further action is needed. We appreciate your support in our academic community.\n"
                + "\n"
                + "However, if you are not familiar with this user or their affiliation, please let us know as soon as possible. Ensuring accurate records is important to us.\n"
                + "\n"
                + "If you have any questions or concerns, please contact us at pupschoolpurposes@gmail.com.\n"
                + "\n"
                + "Thank you for your attention.\n"
                + "\n"
                + "Best regards,\n"
                + "\n"
                + "PUP Unisan Branch";

        // Encode as MIME msg
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(EMAIL));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(receiver));
        email.setSubject(messageSubject);
        email.setText(bodyText);

        // Encode and wrap the MIME msg into a gmail msg
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            // Create send msg
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }
}
