package com.klu.RL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.klu.RL.model.Donor;
import com.klu.RL.service.DonorServiceImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/donor/api")
public class DonorController {

	@Autowired
	DonorServiceImp donorserviceimp;
	@GetMapping("/donorhome")
	public String donorhome()
	{
		return "donorhome";
	}
	
	@GetMapping("/donorprofile")
	public String profile()
	{
		return "donorprofile";
	}
	
	@GetMapping("/donorlogin")
	public String donorlogin()
	{
		return "donorlogin";
	}
	
	@GetMapping("/donorsignup")
	public String donorsignup()
	{
		return "donorreg";
	}
	
	
	@PostMapping("/donorregister")
    public ResponseEntity<?> registerDonor(@RequestBody  Donor donor) {

        // Save the donor using the service layer
        Donor savedDonor = donorserviceimp.registerDonor(donor);

        // Add a message to the model and redirect to a confirmation page (e.g., a success page)
        if(savedDonor!=null)
        {
        	return ResponseEntity.ok("You have Registered succesfully..!");
        }
        else
        {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Internal Server has been occured");
        }
    }
	
	
	 @PostMapping("/checkdonorlogin")
	   public ResponseEntity<?> checkdonorlogin(@RequestBody Donor donor)
	   {
		 System.out.println("Received details "+donor);
		  String demail=donor.getEmail();
		  String dpwd=donor.getPassword();
		   Donor dono=donorserviceimp.checkdonorlogin(demail, dpwd);
		   if (dono != null) {
		        System.out.println("Login successful for user: " + demail);
		        return ResponseEntity.ok(dono);
		    } else {
		        System.out.println("Login failed for user: " + demail);
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		    }
		   
		  
	   }
		   
	
	
	
	
}
