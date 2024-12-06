package com.klu.RL.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.RL.model.Donation;
import com.klu.RL.service.DonationServiceImp;

@CrossOrigin("*")
@RequestMapping("/api/donation")
@RestController
public class DonationController {

	@Autowired
	DonationServiceImp donationser;
	
	@PostMapping("/adddonation")
	public ResponseEntity<?> addDonation(@RequestBody Donation donation) {
		System.out.println("received adddonation req");
	    try {
	        // Validate input
	        if (donation.getDonorName() == null || donation.getCampaignName() == null || donation.getAmount() == null ) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Invalid donation details. Donor name, campaign name, and valid amount are required.");
	        }

	        // Save the donation
	        Donation savedDonation = donationser.savedonation(donation);

	        if (savedDonation != null) {
	            return ResponseEntity.ok("Donation saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Failed to save the donation. Please try again.");
	        }
	    } catch (Exception e) {
	        // Handle unexpected exceptions
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	 @GetMapping("/donor/{donorName}")
	    public List<Donation> getDonationsByDonorName(@PathVariable String donorName) {
	        return donationser.getDonationsByDonorName(donorName);
	    }


}
