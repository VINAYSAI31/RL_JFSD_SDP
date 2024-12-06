package com.klu.RL.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.RL.model.Deliveryguy;
import com.klu.RL.service.DeliveryGuyServiceImp;
import com.klu.RL.service.SmsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/delivery")
public class DeliveryGuyController {

    @Autowired
    private DeliveryGuyServiceImp delser;

    @Autowired
    private SmsService sms;

    // Add a delivery guy
    @PostMapping("/adddel")
    public ResponseEntity<?> addDeliveryGuy(@RequestBody Deliveryguy del) {
        System.out.println("Received Deliveryguy: " + del.getName());
        try {
            boolean res = delser.adddeliveryguy(del);
            if (res) {
                return ResponseEntity.ok("Delivery guy added successfully");
            } else {
                return ResponseEntity.status(500).body("Internal server error");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Generate and send OTP
    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> payload) {
        System.out.println("Received request for OTP generation");

        try {
            String phoneNumber = payload.get("phone");
            System.out.println("Phone number: " + phoneNumber);

            // Generate OTP
            String response = delser.generateOtp(phoneNumber);
            System.out.println("Generated OTP: " + response); // Ensure this is not logged in production for security reasons

            // Send OTP as SMS
            sms.sendSms(phoneNumber, "Your OTP is: " + response);
            Deliveryguy del = new Deliveryguy();
            del.setOtp(response);
            System.out.println("OTP sent successfully to " + phoneNumber);

            return ResponseEntity.ok("OTP sent successfully to " + phoneNumber);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // Print full stack trace for debugging
            return ResponseEntity.badRequest().body("Failed to send OTP. Please try again.");
        }
    }

    // Verify OTP
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> payload) {
        try {
            String phoneNumber = payload.get("phoneNumber");
            String otp = payload.get("otp");
            boolean isValid = delser.verifyOtp(phoneNumber, otp);

            if (isValid) {
                return ResponseEntity.ok("OTP verified successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid or expired OTP");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
