package com.klu.RL.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klu.RL.model.Campaign;
import com.klu.RL.model.Donor;
import com.klu.RL.model.Organization;
import com.klu.RL.service.OrganizationServiceimp;

@CrossOrigin("*")
@RestController
@RequestMapping("org/api")
public class OrgController {

	@Autowired
	OrganizationServiceimp orgser;
	
	//Register
	@PostMapping("/addorg")
	public ResponseEntity<?> addorg(@RequestBody Organization org) {
	    try {
	        Organization curr = orgser.addorg(org);
	        if (curr != null) {
	            return ResponseEntity.ok("Organization added successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Error while adding organization");
	        }
	    } catch (Exception e) {
	        // Log the exception and return an appropriate error message
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	 //login
	
	 @PostMapping("/checkorglogin")
	   public ResponseEntity<?> checkdonorlogin(@RequestBody Organization org)
	   {
		 System.out.println("Received details "+org);
		  String oemail=org.getEmail();
		  String opwd=org.getPassword();
		   Organization orga=orgser.checkorganizationlogin(oemail, opwd);
		   if (orga != null) {
		        System.out.println("Login successful for user: " + oemail);
		        return ResponseEntity.ok(org);
		    } else {
		        System.out.println("Login failed for user: " + oemail);
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		    }
		   
		  
	   }
	 
	 //campaign add
	 
	 @PostMapping("/addcampaign")
	 public ResponseEntity<?> addcampaign(@RequestPart Campaign camp,
	                                     @RequestPart MultipartFile imagefile,
	                                     @RequestParam String orgName) {
	     try {
	         // Find the organization by name (or use id if preferred)
	         Organization org = orgser.findbyname(orgName); // Implement this method in your service

	         if (org != null) {
	             camp.setOrganization(org);
	         } else {
	             return ResponseEntity.badRequest().body("Organization not found");
	         }

	         // Save the campaign
	         orgser.addcampaign(camp, imagefile);

	         return ResponseEntity.ok("Campaign added successfully");
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body(e.getLocalizedMessage());
	     }
	 }
	 
	 
	 //camp by id
	 
	 @GetMapping("/campaigndetails/{id}")
	public Campaign getcampbyid(@PathVariable int id)
	{
			Campaign cmp = orgser.findbyid(id);		 		
				return cmp;			
	}
	
	 @DeleteMapping("/deletecamp/{id}")
	public ResponseEntity<?> deletecampbyid(@PathVariable int id)
	{System.out.println("Recevied request for deleteing campaign");
		 try {
			boolean del=orgser.deletecampbyid(id);
			if(del==true) {
			return ResponseEntity.ok("Campaign Deleted Succesfully");
			}
			else
			{
				return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	 
	 
	 
	 @PutMapping("updatecamp/{id}")
	 public boolean updatedonor(@PathVariable Integer id,@RequestBody Campaign camp)
	 
	 {
		 try {
			orgser.updatecampbyid(id, camp);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getLocalizedMessage());
			
			return false;
		}
		 
	 }
	 
	 @GetMapping("/getcampbyorgid/{id}")
	 public List<Campaign> getcampbyorgid(@PathVariable int id)
	 {
		 return orgser.getcampbyorgid(id);
		 
	 }

		
}
