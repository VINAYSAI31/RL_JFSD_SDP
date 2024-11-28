package com.klu.RL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer>{

	
	@Query("select d from Donor d where d.email = :email and d.password = :password")
	public Donor checkdonorlogin(@Param("email") String email, @Param("password") String password);
	
	
	@Query("SELECT d FROM Donor d WHERE d.id = ?1")
	public Donor getUserById(Integer id);

}
