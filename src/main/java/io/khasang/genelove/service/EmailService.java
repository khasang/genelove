package io.khasang.genelove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Component("EmailService")
public class EmailService {

    @Autowired
    Environment environment;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(HttpServletRequest request) throws UnsupportedEncodingException {
        // takes input from e-mail form
        request.setCharacterEncoding("UTF8");
        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(environment.getProperty("mail.username"));
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);

        // sends the e-mail
        mailSender.send(email);
    }
}
