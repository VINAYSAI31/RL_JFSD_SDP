package com.klu.RL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.repository.AdminRepository;
import com.klu.RL.repository.DonorRepository;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminRepository adminrepository;
	


	@Override
	public Admin checkadminlogin(String ausername, String apwd) {
		return adminrepository.checkAdminLogin(ausername, apwd);
		
	}

	@Override
	public boolean addAdmin(String username, String password) {
		// TODO Auto-generated method stub
		 Admin admin = new Admin(username, password);
	        adminrepository.save(admin);
	        return true;
	}

	

}
