package com.klu.RL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klu.RL.model.Donor;
import com.klu.RL.service.DonorServiceImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
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
    public String registerDonor(HttpServletRequest request,Model model) {
		
		String name = request.getParameter("dname");
        String gender = request.getParameter("dgender");
        String dob = request.getParameter("ddob");
        String email = request.getParameter("demail");
        String password = request.getParameter("dpwd");
        String location = request.getParameter("dlocation");
        String contact = request.getParameter("dcontact");
        
     // Create a Donor object and set its properties
        Donor donor = new Donor();
        donor.setName(name);
        donor.setGender(gender);
        donor.setDateofbirth(dob);
        donor.setEmail(email);
        donor.setPassword(password);
        donor.setLocation(location);
        donor.setContact(contact);
        
        // Save the donor using the service layer
        Donor savedDonor = donorserviceimp.registerDonor(donor);

        // Add a message to the model and redirect to a confirmation page (e.g., a success page)
        if (savedDonor != null) {
            model.addAttribute("message", "Registration successful!");
            return "donorlogin";  // Redirect to a success page
        } else {
            model.addAttribute("message", "Registration failed. Please try again.");
            return "donorreg";  // Stay on the registration page in case of error
        }
    }
	
	
	 @PostMapping("/checkdonorlogin")
	   public ModelAndView checkdonorlogin(HttpServletRequest request)
	   {
		   ModelAndView mv = new ModelAndView();

		   String demail=request.getParameter("demail");
		   String dpwd = request.getParameter("dpwd");
		   
		   Donor donor = donorserviceimp.checkdonorlogin(demail, dpwd);
		   
		   if(donor!=null)
		   {
			 mv.setViewName("donorhome");  
			 HttpSession session = request.getSession();
			 session.setAttribute("userName", donor.getName()); // Assuming 'loggedInUser.getName()' gets the user's name
			 session.setAttribute("userEmail", donor.getEmail());
			 session.setAttribute("userPhone", donor.getContact());
			 session.setAttribute("userAddress", donor.getLocation());
		   }
		   else
		   {
			   mv.setViewName("donorlogin");
			   mv.addObject("message","login failed!");
		   }
		   return mv;
	   }
		   
	
	
	
	
}
