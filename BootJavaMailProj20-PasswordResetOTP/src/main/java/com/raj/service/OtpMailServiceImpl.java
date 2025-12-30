package com.raj.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.raj.model.OtpRequest;
@Service
public class OtpMailServiceImpl implements IOtpMailService{

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendOtpMail(OtpRequest request) {

		validateOtp(request);

		String body = """
				Dear User,

				Your OTP for password reset is: %s
				This OTP is valid for 5 minutes.

				Do not share this OTP with anyone.
				""".formatted(request.getOtp());

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(request.getEmail());
		message.setSubject("Password Reset OTP");
		message.setText(body);

		System.out.println("Sending OTP to: " + request.getEmail());
		mailSender.send(message);

		System.out.println("OTP email sent successfully!");
		System.out.println("OTP valid for 5 minutes.");
	}

	private void validateOtp(OtpRequest request) {
		if (request.getOtp() == null || request.getOtp().length() != 6) {
			throw new IllegalArgumentException("Invalid OTP");
		}

		if (LocalDateTime.now().isAfter(request.getExpiryTime())) {
			throw new IllegalStateException("OTP expired");
		}
	}

}
