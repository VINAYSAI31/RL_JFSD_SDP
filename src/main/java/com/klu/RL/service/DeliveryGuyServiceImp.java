package com.klu.RL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import com.klu.RL.model.Deliveryguy;
import com.klu.RL.repository.DeliveryGuyRepo;

@Service
public class DeliveryGuyServiceImp implements DeliveryGuyService {

	@Autowired
	private DeliveryGuyRepo delrepo;
	
	@Override
	public String generateOtp(String phoneNumber) {
		// TODO Auto-generated method stub
		
        Optional<Deliveryguy> deliveryGuyOpt = delrepo.findByPhoneNumber(phoneNumber);
        if (deliveryGuyOpt.isEmpty()) {
            throw new RuntimeException("Delivery guy not found with phone number: " + phoneNumber);
        }

        Deliveryguy deliveryGuy = deliveryGuyOpt.get();
        String otp = String.format("%06d", new Random().nextInt(999999));
        
        deliveryGuy.setOtp(otp);
        deliveryGuy.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
        delrepo.save(deliveryGuy);
        System.out.println("OTP for " + phoneNumber + ": " + otp);

        return otp;

		
	}

	@Override
	public boolean verifyOtp(String phoneNumber, String otp) {
		// TODO Auto-generated method stub
        Optional<Deliveryguy> deliveryGuyOpt = delrepo.findByPhoneNumber(phoneNumber);
        
        if (deliveryGuyOpt.isEmpty()) {
            throw new RuntimeException("Delivery guy not found with phone number: " + phoneNumber);
        }
        
        Deliveryguy deliveryGuy = deliveryGuyOpt.get();
        if (deliveryGuy.getOtp().equals(otp) && LocalDateTime.now().isBefore(deliveryGuy.getOtpExpiry())) {
            return true; // OTP is valid
        }

		return false;
	}

	@Override
	public boolean adddeliveryguy(Deliveryguy del) {
		// TODO Auto-generated method stub
	try {
		 delrepo.save(del);
		
			return true;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.err.println(e.getLocalizedMessage());
		return false;
	}	
	}

}
