package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.raj.model.MailRequest;
import com.raj.model.User;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

	@Override
	public void sendWelcomeMail(User user) {
		
		System.out.println("Preparing welcome email...");

        String body = """
                Hello %s,

                Your account has been created successfully.
                Username: %s

                Thank you for registering with us!
                """.formatted(user.getName(), user.getUsername());

        MailRequest request = new MailRequest(
                user.getEmail(),
                "Welcome to Our Application",
                body
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());

        System.out.println("Sending email to: " + request.getTo());
        mailSender.send(message);

        System.out.println("Welcome email sent successfully!");

	}

}
