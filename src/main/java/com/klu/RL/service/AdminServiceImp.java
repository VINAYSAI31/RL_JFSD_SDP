package com.klu.RL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Donor;
import com.klu.RL.repository.AdminRepository;
import com.klu.RL.repository.DonorRepository;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminRepository adminrepository;
	
	@Autowired
    private DonorRepository donorrepository;
	


	@Override
	public Admin checkadminlogin(String ausername, String apwd) {
		return adminrepository.checkAdminLogin(ausername, apwd);
		
	}

	@Override
	public boolean addAdmin(String username, String password) {
		// TODO Auto-generated method stub
		 Admin admin = new Admin( username, password);
	        adminrepository.save(admin);
	        return true;
	}

	@Override
	public List<Admin> showalladmin() {
		// TODO Auto-generated method stub
		return adminrepository.findAll();
	}



	@Override
	public boolean deletedonor(Integer id) {
		try {
			Donor curruser=donorrepository.getUserById(id);
			donorrepository.delete(curruser);
			return true;
		} catch (Exception e) {
			System.err.println("Error while deleteing user"+e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public boolean updatedonor(Integer id, Donor donor) {
		try {
	        // Retrieve the current donor by ID
	        Donor curr = donorrepository.getUserById(id);
	        if (curr == null) {
	            // Handle case where the user is not found
	            throw new RuntimeException("User not found with ID: " + id);
	        }

	        // Update fields if new values are not null
	        if (donor.getName() != null) {
	            curr.setName(donor.getName());
	        }
	        if (donor.getGender() != null) {
	            curr.setGender(donor.getGender());
	        }
	        if (donor.getDateofbirth() != null) {
	            curr.setDateofbirth(donor.getDateofbirth());
	 
	        }
	        if (donor.getEmail() != null) {
	            curr.setEmail(donor.getEmail());
	        }
	        if (donor.getPassword() != null) {
	            curr.setPassword(donor.getPassword());
	        }
	        if (donor.getLocation() != null) {
	            curr.setLocation(donor.getLocation());
	        }
	        if (donor.getContact() != null) {
	            curr.setContact(donor.getContact());
	        }

	        // Save updated donor back to repository
	        donorrepository.save(curr);
	        return true;
	    } catch (Exception e) {
	        // Log the error (use a logging framework in a real app)
	        System.err.println("Error updating user: " + e.getMessage());
	        return false;
	    }
	}




	
	

	

}
