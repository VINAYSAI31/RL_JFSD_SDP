package com.klu.RL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Deliveryguy;

@Repository
public interface DeliveryGuyRepo extends JpaRepository<Deliveryguy, Integer>{
	
	 Optional<Deliveryguy> findByPhoneNumber(String phoneNumber);

}
