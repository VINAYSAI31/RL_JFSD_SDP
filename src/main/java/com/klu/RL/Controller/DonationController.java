package com.klu.RL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.RL.model.Donation;
import com.klu.RL.service.DonationServiceImp;

@CrossOrigin("*")
@RequestMapping("/donation/api")
@RestController
public class DonationController {

	@Autowired
	DonationServiceImp donationser;
	
	@PostMapping("/adddonation")
	public ResponseEntity<?> adddonation(@RequestBody Donation donation)
	{
		Donation don=donationser.savedonation(donation);
		if(don!=null)
		{
			return ResponseEntity.ok("Donation saved succesfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("internal server occcured");
		}
		
		
	}
}
