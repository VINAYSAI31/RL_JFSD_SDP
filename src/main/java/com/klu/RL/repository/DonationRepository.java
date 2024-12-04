package com.klu.RL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer>{
	
	 List<Donation> findByDonorName(String donorName);
}
