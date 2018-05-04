/*
Author: David Yu and Michael Zhang
Date: 05/01/2018
Description: this java file handles the email components of our program.
 */
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class JMailSender {
    public static void sent(String account, String pw, String[] addressList) throws IOException {

        final String username = account;
        final String password = pw;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setSubject("Today's Dining Hall is Serving...");
            message.setContent(new MenuGetter().toString(),"text/html");

            for (String s : addressList) {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(s));
                Transport.send(message);
            }
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
