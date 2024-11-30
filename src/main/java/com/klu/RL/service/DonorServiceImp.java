package com.klu.RL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Campaign;
import com.klu.RL.model.Donor;
import com.klu.RL.repository.CampaignRepository;
import com.klu.RL.repository.DonorRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class DonorServiceImp implements DonorService{

	 @Autowired
	 private DonorRepository donorRepository;
	 
	 @Autowired
	 private CampaignRepository campRepository;

	@Override
	public Donor registerDonor(Donor donor) {
		return donorRepository.save(donor);
	}

	@Override
	public Donor checkdonorlogin(String demail, String dpwd) {
		// TODO Auto-generated method stub
		
		return donorRepository.checkdonorlogin(demail, dpwd);
		
		
	}

	@Override
	public List<Donor> getalldonors() {
		// TODO Auto-generated method stub
		return donorRepository.findAll();
	}

	@Override
	public List<Campaign> getallcamps() {
		// TODO Auto-generated method stub
		
		return campRepository.findAll();
	}
	
	
	
	
}
