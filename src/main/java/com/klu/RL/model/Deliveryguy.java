package com.klu.RL.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
public class Deliveryguy {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(unique = true)
    private String phoneNumber;

    private String otp;

    private LocalDateTime otpExpiry;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpExpiry() {
		return otpExpiry;
	}

	public void setOtpExpiry(LocalDateTime otpExpiry) {
		this.otpExpiry = otpExpiry;
	}

	public Deliveryguy(Long id, String name, String phoneNumber, String otp, LocalDateTime otpExpiry) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
	}
	
	public Deliveryguy(){
		
	}

	

}
