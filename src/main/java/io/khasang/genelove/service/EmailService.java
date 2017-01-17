package io.khasang.genelove.service;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.EMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Component("EmailService")
public class EmailService {

    @Autowired
    Environment environment;

    @Autowired
    private JavaMailSender mailSender;

    private EMail eMail;

    // creates a simple e-mail object
    private SimpleMailMessage setEmailFields (EMail eMail) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(eMail.getRecipient());
        email.setFrom(eMail.getSender());
        email.setSubject(eMail.getSubject());
        email.setText(eMail.getText());
        return email;
    }

    public void sendEmail(HttpServletRequest request) throws UnsupportedEncodingException {
        // takes input from e-mail form
        request.setCharacterEncoding("UTF8");
        eMail = new EMail(
                request.getParameter("recipient"),
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message")
        );

        // sends the e-mail
        mailSender.send(setEmailFields(eMail));
    }

    public void sendEmail(User user) throws UnsupportedEncodingException {
        // takes input from e-mail form
        String subject = "Hi " + user.getFirstName() + " " + user.getLastName() + "!";
        String text = "text"; //+

        // Sorry, the email was not sent To User because of the following error:
        // Failed messages: com.sun.mail.smtp.SMTPSendFailedException: 451 Ratelimit exceeded for mailbox . Try again later.


              //  " Here some your personal data: \n" ; //+
           //     "Your First Name is " + user.getFirstName() + "\n" +
          //      "Your Last Name is " + user.getLastName() + "\n" +
         //       "Your Gender is " + user.getGender() + "\n" ;

        eMail = new EMail(
                user.getEmail(),
                environment.getProperty("mail.username"),
                subject,
                text);

        // sends the e-mail
        mailSender.send(setEmailFields(eMail));
    }


    public void sendEmail(ArrayList<User> users) throws UnsupportedEncodingException {
        // takes input from e-mail form

        for (User user: users) {
            sendEmail(user);
        }
    }
}
