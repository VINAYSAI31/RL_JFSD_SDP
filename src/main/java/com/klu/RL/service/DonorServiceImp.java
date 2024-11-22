package com.klu.RL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Donor;
import com.klu.RL.repository.DonorRepository;

@Service
public class DonorServiceImp implements DonorService{

	 @Autowired
	 private DonorRepository donorRepository;

	@Override
	public Donor registerDonor(Donor donor) {
		return donorRepository.save(donor);
	}

	@Override
	public Donor checkdonorlogin(String demail, String dpwd) {
		// TODO Auto-generated method stub
		
		return donorRepository.checkdonorlogin(demail, dpwd);
		
	}
}
