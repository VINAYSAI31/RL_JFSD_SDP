package com.klu.RL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Logistics;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Integer>{

}
