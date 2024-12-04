package com.klu.RL.Controller;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    static {
        Stripe.apiKey = ; // Replace with your actual Stripe secret key
    }

    @PostMapping("/create-payment-intent")
    public ResponseEntity<Map<String, String>> createPaymentIntent(
    		
            @RequestParam("amount") long amount,
            @RequestParam("customerName") String customerName,
            @RequestParam("customerEmail") String customerEmail,
            @RequestParam("customerAddress") String customerAddress) {
    	System.out.println("Request Received: " + amount + ", " + customerName + ", " + customerEmail + ", " + customerAddress);

    	System.out.println("received");
        try {
            // Build the PaymentIntentCreateParams
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency("inr") // Adjust the currency as needed
                .setDescription("Payment for donation to support disaster relief services.")
                .setReceiptEmail(customerEmail) // Set receipt email for the customer
                .setShipping(
                    PaymentIntentCreateParams.Shipping.builder()
                        .setName(customerName)
                        .setAddress(
                            PaymentIntentCreateParams.Shipping.Address.builder()
                                .setLine1(customerAddress)
                                .setCountry("IN") // Set to 'IN' for India
                                .build()
                        )
                        .build()
                )
                .build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);

            return ResponseEntity.ok(Map.of(
                "clientSecret", paymentIntent.getClientSecret()
            ));
        } catch (Exception e) {
        	 e.printStackTrace(); 
            return ResponseEntity.status(500).body(Map.of(
                "error", e.getMessage()
            ));
        }
    }
}
