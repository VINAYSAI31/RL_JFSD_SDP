package com.klu.RL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Donation;
import com.klu.RL.repository.DonationRepository;
import com.klu.RL.repository.DonorRepository;

@Service
public class DonationServiceImp implements DonationService{

	@Autowired
	DonationRepository donationrepo;
	
	@Override
	public Donation savedonation(Donation donation) {
		
			return donationrepo.save(donation);
			
				
		
	}

	@Override
	public List<Donation> getDonationsByDonorName(String donorName) {
		  return donationrepo.findByDonorName(donorName);
	}

}
