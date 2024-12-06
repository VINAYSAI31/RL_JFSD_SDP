package com.klu.RL.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String donorName; // New field for donor name
    private String campaignName; ;
    private Double amount;
    private String donatedItems;
    public Donation(int id, String donorName, String campaignName, String donatedItems, LocalDateTime timestamp,Double amount) {
		super();
		this.id = id;
		this.donorName = donorName;
		this.campaignName = campaignName;
		this.donatedItems = donatedItems;
		this.timestamp = timestamp;
		this.amount=amount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getDonatedItems() {
		return donatedItems;
	}
	public void setDonatedItems(String donatedItems) {
		this.donatedItems = donatedItems;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	private LocalDateTime timestamp;
   ;
    
    public Donation() {}

	
	

	
   
   
}
