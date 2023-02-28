package com.cerner.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	@ManyToOne
	@JoinColumn(name="Facility_Id",unique = true)
	private Encounter encounter;
	
	

	public Facility(int id, String location, Encounter encounter) {
		super();
		this.id = id;
		this.location = location;
		this.encounter = encounter;
	}

	public Facility(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
