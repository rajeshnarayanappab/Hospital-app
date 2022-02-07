package com.ty.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason;
	private LocalDateTime createdDateTime;
	private String creatorName;

	@ManyToOne
	@JoinColumn
	private Person person;
	
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL)
	private List<MedOrder> medOrders;
	
	@ManyToOne
	@JoinColumn
	Branch branchs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<MedOrder> getOrders() {
		return medOrders;
	}

	public void setOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}

	public Branch getBranchs() {
		return branchs;
	}

	public void setBranchs(Branch branchs) {
		this.branchs = branchs;
	}


	
	
}