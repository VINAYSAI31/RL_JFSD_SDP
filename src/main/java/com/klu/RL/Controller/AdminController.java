	package com.klu.RL.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Campaign;
import com.klu.RL.model.Donor;
import com.klu.RL.service.AdminServiceImp;
import com.klu.RL.service.DonorServiceImp;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/admin/api")
public class AdminController {

	@Autowired
	AdminServiceImp adminservice;
	
	@Autowired
	DonorServiceImp donorimp;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/login")
	public String Login()
	{
		return "login";
	}
	
	@GetMapping("/chooserole")
	public String Role()
	{
		return "chooserole";
	}
	
	@GetMapping("/adminlogin")
	public String adminlogin()
	{
		return "adminlogin";
	}
	
	@GetMapping("/adminhome")
	public String adminhome()
	{
		return "adminhome";
	}
	@PostMapping("/checkadminlogin")
	public ResponseEntity<?> checkadminlogin(@RequestBody Admin loginrequest) {
	    System.out.println("Received login request: " + loginrequest);
	    String ausername = loginrequest.getUsername();
	    String apwd = loginrequest.getPassword();
	    System.out.println("Username: " + ausername + ", Password: " + apwd);
	    
	    Admin admin = adminservice.checkadminlogin(ausername, apwd);
	    if (admin != null) {
	        System.out.println("Login successful for user: " + ausername);
	        return ResponseEntity.ok(admin);
	    } else {
	        System.out.println("Login failed for user: " + ausername);
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
	}

	@PostMapping("/addadmin")
	public String addAdmin(@RequestParam String username, @RequestParam String password, Model model) {
	    // Call your service to add the admin (e.g., save the admin in the database)
	    boolean success = adminservice.addAdmin(username, password);
	    
	    if (success) {
	        model.addAttribute("successMessage", "Admin added successfully!");
	    } else {
	        model.addAttribute("errorMessage", "Failed to add admin.");
	    }
	    
	    return "addadmin";  // Stay on the form page, it'll display the message
	}

	 @GetMapping("/getalladmins")
     public List<Admin> getalladmins()
     
     {
		 System.out.println("Received");
    	 return adminservice.showalladmin();
     }
	 
	 @GetMapping("/getalldonors")
	 public List<Donor> getalldonors()
	 {
		 return donorimp.getalldonors();
	 }
	 
	 @PutMapping("updatedonor/{id}")
	 public boolean updatedonor(@PathVariable Integer id,@RequestBody Donor donor)
	 
	 {
		 try {
			adminservice.updatedonor(id, donor);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		 
	 }
	 
	 @DeleteMapping("deletedonor/{id}")
	 public ResponseEntity<?> deletedonor(@PathVariable Integer id)
	 {
		try {
			boolean res=adminservice.deletedonor(id);
			return (res)?ResponseEntity.ok().body("user deleted succesfully"):
				ResponseEntity.badRequest().body("couldn't delete user");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	 }
	 
	 
	
	 
	
	
	
	
}
