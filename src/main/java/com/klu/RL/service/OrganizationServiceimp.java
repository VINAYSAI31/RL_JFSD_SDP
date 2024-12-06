package com.klu.RL.service;

import java.io.IOException;
import java.util.List;

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

	@Override
	public boolean deletecampbyid(int id) {
		// TODO Auto-generated method stub
		try {
			 camprepo.deleteById(id);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public Campaign updatecampbyid(int id, Campaign camp) {
	    try {
	        // Retrieve the current campaign by ID
	        Campaign curr = camprepo.findById(id).get();
	        if (curr == null) {
	            // Handle case where the campaign is not found
	            throw new RuntimeException("Campaign not found with ID: " + id);
	        }

	        // Update fields if new values are not null
	        if (camp.getTitle() != null) {
	            curr.setTitle(camp.getTitle());
	        }
	        if (camp.getDescription() != null) {
	            curr.setDescription(camp.getDescription());
	        }
	        if (camp.getCategory() != null) {
	            curr.setCategory(camp.getCategory());
	        }
	        if (camp.getRequired() != null) {
	            curr.setRequired(camp.getRequired());
	        }
	        if (camp.getLocation() != null) {
	            curr.setLocation(camp.getLocation());
	        }
	        if(camp.getStatus()!=null){
	        	curr.setStatus(camp.getStatus());
	        }
	        if (camp.getStartdate() != null) {
	            curr.setStartdate(camp.getStartdate());
	        }
	        if (camp.getEnddate() != null) {
	            curr.setEnddate(camp.getEnddate());
	        }
	        if (camp.getEmail() != null) {
	            curr.setEmail(camp.getEmail());
	        }
	        if (camp.getImagename() != null) {
	            curr.setImagename(camp.getImagename());
	        }
	        if (camp.getImagetype() != null) {
	            curr.setImagetype(camp.getImagetype());
	        }
	        if (camp.getImagedata() != null) {
	            curr.setImagedata(camp.getImagedata());
	        }

	        // Save updated campaign back to repository
	        camprepo.save(curr);
	        return curr;
	    } catch (Exception e) {
	        // Log the error (use a logging framework in a real app)
	        System.err.println("Error updating campaign: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public List<Campaign> getcampbyorgid(int id) {
		
		return camprepo.findCampByOrgId(id);
	}

	@Override
	public Organization findorgbyid(int id) {
		// TODO Auto-generated method stub
		return orgrepo.findById(id).get();
	}

	

}
