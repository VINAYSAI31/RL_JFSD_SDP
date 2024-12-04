package com.klu.RL.Email;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	
	 private Map<String, String> otpStorage = new HashMap<>();

	    public void sendOtp(String email) {
	        String otp = String.format("%06d", new Random().nextInt(999999));
	        otpStorage.put(email, otp);

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Your OTP for Email Verification");
	        message.setText("Your OTP is: " + otp);
	        mailsender.send(message);
	    }

	    public boolean verifyOtp(String email, String otp) {
	        return otpStorage.containsKey(email) && otpStorage.get(email).equals(otp);
	    }

}
