package com.klu.RL.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klu.RL.model.Campaign;
import com.klu.RL.model.Organization;
import com.klu.RL.repository.CampaignRepository;
import com.klu.RL.repository.OrganizationRepository;

@Service
public class OrganizationServiceimp implements OrganizationService{
   
	@Autowired
	OrganizationRepository orgrepo;
	
	@Autowired
	CampaignRepository camprepo;
	
	@Override
	public Organization addorg(Organization org) {
		// TODO Auto-generated method stub
		return orgrepo.save(org) ;
	}

	@Override
	public Organization checkorganizationlogin(String email, String password) {
		// TODO Auto-generated method stub
		return orgrepo.checkorglogin(email, password);
	}

	
	@Override
	public Campaign addcampaign(Campaign campaign, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		campaign.setImagename(image.getOriginalFilename());
		campaign.setImagetype(image.getContentType());
		campaign.setImagedata(image.getBytes());
		return camprepo.save(campaign);
		
		
	}

	

	@Override
	public Campaign findbyid(int id) {
		// TODO Auto-generated method stub
		return camprepo.findById(id).get();
	}

	@Override
	public Organization findbyname(String name) {
		// TODO Auto-generated method stub
		return orgrepo.findbyname(name);
	}

	

}
