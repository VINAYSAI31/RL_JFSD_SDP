package com.klu.RL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.RL.model.Logistics;
import com.klu.RL.repository.LogisticsRepository;

@Service
public class LogisticsServiceImp implements LogisticsService{
	
	@Autowired
	private LogisticsRepository logisrepo;

	@Override
	public boolean adddelivery(Logistics logi) {
		try {
			logisrepo.save(logi);
			return true;
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return false;
			// TODO: handle exception
		}
	}

}
