package com.klu.RL.Email;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService emailservice;

	
	@PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        emailservice.sendOtp(email);
        return ResponseEntity.ok("OTP sent to email: " + email);
    }
	
	@PostMapping("/verify-otp")
    public ResponseEntity<Map<String, Boolean>> verifyOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");
        boolean verified = emailservice.verifyOtp(email, otp);
        return ResponseEntity.ok(Map.of("verified", verified));
    }
}
