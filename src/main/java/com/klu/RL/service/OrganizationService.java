package com.klu.RL.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klu.RL.model.Campaign;
import com.klu.RL.model.Organization;

@Service
public interface OrganizationService {

	public Organization addorg(Organization org);
	public Organization checkorganizationlogin(String email,String password);
	public Campaign addcampaign(Campaign campaign,MultipartFile image) throws IOException;
	public Campaign findbyid(int id);
	public Organization findbyname(String name);
}
