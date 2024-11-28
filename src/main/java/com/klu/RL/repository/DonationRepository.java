package com.klu.RL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer>{

}
