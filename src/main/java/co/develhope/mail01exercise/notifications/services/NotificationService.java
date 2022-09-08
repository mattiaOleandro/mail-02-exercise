package co.develhope.mail01exercise.notifications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("develhopeemailexercise@gmail.com");
        message.setReplyTo("develhopeemailexercise@gmail.com");
        message.setSubject(title);
        message.setText(text);
        javaMailSender.send(message);
    }
}
