package com.klu.RL.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Donation;

@Service
public interface DonationService {

	public Donation savedonation(Donation donation);
	public List<Donation> getDonationsByDonorName(String donorName);
}
