package com.klu.RL.service;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Deliveryguy;

@Service
public interface DeliveryGuyService {

	public boolean adddeliveryguy(Deliveryguy del);
	
	public String generateOtp(String phoneNumber);
	public boolean verifyOtp(String phoneNumber, String otp);
}
