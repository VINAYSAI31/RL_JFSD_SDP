	package com.klu.RL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klu.RL.model.Admin;
import com.klu.RL.service.AdminServiceImp;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

	@Autowired
	AdminServiceImp adminservice;
	
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
	public ModelAndView checkadminlogin(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String ausername=request.getParameter("ausername");
		String apwd = request.getParameter("apwd");
		
		Admin admin =  adminservice.checkadminlogin(ausername, apwd);
		
		
		if(admin!=null)
		{
			mv.setViewName("adminhome"); //login success
		}
		else
		{
			mv.setViewName("adminlogin");
			mv.addObject("message","Login failed! Invalid username or password!");
		}
		return mv;

	}
	
	@GetMapping("/addadmin")
	public String showAddAdminForm()
	{
		return "addadmin";
		
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

	
	
	
	
}
