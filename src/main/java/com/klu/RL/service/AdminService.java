package com.klu.RL.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Admin;
import com.klu.RL.model.Donor;

@Service
public interface AdminService {

//	public void addadmin(Admin ad);
	public Admin checkadminlogin(String ausername,String apwd);
	public boolean addAdmin(String username,String password);
	public List<Admin> showalladmin();
	public boolean deletedonor(Integer id);
	public boolean updatedonor(Integer id, Donor donor);
}
