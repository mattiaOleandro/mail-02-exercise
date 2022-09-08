package co.develhope.mail01exercise.notifications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1 style=\"color:blue;\">My First Email Notification</h1>" +
                "<h2>You have a new message: </h2>" +
                "<img src='https://www.mirandola.net/wp-content/uploads/2021/03/logo-develhope-mirandola-comunicazione.png' alt='Alternative text'>" +
                "<h3>" + text + "</h3>";
        message.setTo(email);
        message.setFrom("develhopeemailexercise@gmail.com");
        message.setReplyTo("develhopeemailexercise@gmail.com");
        message.setSubject(title);
        message.setText(htmlMsg, true);
        javaMailSender.send(mimeMessage);
    }
}
