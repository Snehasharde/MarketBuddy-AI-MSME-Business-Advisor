package com.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("MarketBuddyy@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Welcome to Our Service!");
        message.setText("Hello " + userName + ",\n\nThank you for registering!");

        mailSender.send(message);
    }
}

