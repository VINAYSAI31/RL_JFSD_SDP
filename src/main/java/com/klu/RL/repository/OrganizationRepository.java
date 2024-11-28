package com.klu.RL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.RL.model.Campaign;
import com.klu.RL.model.Donor;
import com.klu.RL.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
	
	@Query("select o from Organization o where o.email = :email and o.password = :password")
	public Organization checkorglogin(@Param("email") String email, @Param("password") String password);

	 @Query("select o from Organization o where o.name=:name")	
		public Organization findbyname(@Param("name") String name);
}
