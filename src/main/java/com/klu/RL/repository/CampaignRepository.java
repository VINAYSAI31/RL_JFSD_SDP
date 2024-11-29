package com.klu.RL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klu.RL.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer>{
   
	
	@Query("SELECT c FROM Campaign c WHERE c.organization.id = :id")
	List<Campaign> findCampByOrgId(@Param("id") int id);

}
