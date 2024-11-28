package com.klu.RL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	



	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id //primary key unique+ not null
	    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
		private int id;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public Admin() {
	    }
	public Admin( String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}
	
}
