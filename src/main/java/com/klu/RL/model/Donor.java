package com.klu.RL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Donor {
	 @Id //primary key unique+ not null
	    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
		private int id;
		private String name;
		private String gender;
		private String dateofbirth;
		private String email;
		private String password;
		private String location;
		private String contact;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDateofbirth() {
			return dateofbirth;
		}
		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		
		public Donor()
		{
			
		}
		public Donor(int id, String name, String gender, String dateofbirth, String email, String password,
				String location, String contact) {
			super();
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.dateofbirth = dateofbirth;
			this.email = email;
			this.password = password;
			this.location = location;
			this.contact = contact;
		}
		
}
