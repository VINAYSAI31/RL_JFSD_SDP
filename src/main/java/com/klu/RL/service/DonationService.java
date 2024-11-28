package com.klu.RL.service;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Donation;

@Service
public interface DonationService {

	public Donation savedonation(Donation donation);
}
