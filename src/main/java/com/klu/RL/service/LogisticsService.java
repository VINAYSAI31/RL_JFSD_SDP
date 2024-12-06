package com.klu.RL.service;

import org.springframework.stereotype.Service;

import com.klu.RL.model.Logistics;

@Service
public interface LogisticsService {
	

	public boolean adddelivery(Logistics logi);
}
