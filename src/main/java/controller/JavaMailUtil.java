/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bhask
 */
public class JavaMailUtil {
    public static void sendMail(String recepient, String id,String pass) throws MessagingException{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String hostEmail = "facultyachivementforum@gmail.com";
        String password = "FacultyAchivementForum3000";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(hostEmail, password);
            }
        });
        Message message = prepareMessage(session,hostEmail,recepient,id,pass);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String hostEmail, String recepient, String id, String pass) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(hostEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account created on Teacher Forum");
            message.setContent("<h1>Welcome to Faculty Achivement Forum</h1></br><h2>Here is your Login credentials for future references:</h2><br/><h2>ID:"+id+"</h2><br/><h2>Password:"+pass+"</h2>","text/html");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, "Email not sent", ex);
        }
        return null;
    }
}


