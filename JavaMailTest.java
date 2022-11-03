package sample;

import javax.mail.Session;
import javax.mail.Transport;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailTest {
    public static void sendMail(String recipient) throws Exception {

        System.out.println("Preparing to send Email");
        final String myAccountEmail = "";
        final String password = "";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    public static Message prepareMessage(Session session, String myAccountEmail, String recipient) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Password Generator");
            String a = PassGenerator.getPassString();
            message.setText("Your Passwords is: " + a);

            File file = new File("out.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(a);
            pw.close();

            System.out.println(a);
            return message;

        } catch (Exception ex) {
            Logger.getLogger(JavaMailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
