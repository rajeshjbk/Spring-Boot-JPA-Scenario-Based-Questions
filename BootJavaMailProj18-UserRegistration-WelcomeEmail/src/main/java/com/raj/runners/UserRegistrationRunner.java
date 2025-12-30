package com.raj.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.model.User;
import com.raj.service.MailService;

@Component
public class UserRegistrationRunner implements CommandLineRunner {

    @Autowired
    private MailService mailService;

    @Override
    public void run(String... args) {

        User user = new User(
                101,
                "Rajesh Kumar",
                "mahtorajeshkumar8920@gmail.com",
                "Rajesh@8102"
        );

        System.out.println("Registering new user: " + user.getName());
        mailService.sendWelcomeMail(user);
    }
}