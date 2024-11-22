package com.klu.RL.service;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;

@Service
public interface AdminService {

//	public void addadmin(Admin ad);
	public Admin checkadminlogin(String ausername,String apwd);
	public boolean addAdmin(String username,String password);
	
}
