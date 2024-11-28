package com.klu.RL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Campaign;
import com.klu.RL.model.Donor;
import com.klu.RL.repository.DonorRepository;

@Service
public interface DonorService {

	
	public Donor checkdonorlogin(String demail,String dpwd);

	 public Donor registerDonor(Donor donor) ;
	 
	 public List<Donor> getalldonors();
	 
	 public List<Campaign> getallcamps();
	 
	 
	        
	    
	 
	 
}
