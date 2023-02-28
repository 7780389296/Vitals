package com.cerner.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String dateOfBirth;
	private int address;
	private String gender;
	
	@OneToMany
	@JoinColumn(name="patientId")
	private List<Vitals> vitals;
	
	@OneToMany
	@JoinColumn(name="patientId")
	private List<Encounter> encounter;
	
	@OneToMany
	@JoinColumn(name="pId")
	private List<Facility> facility;
	
	

	public Patient(int id, String name, int age, String dateOfBirth, int address, String gender, List<Vitals> vitals,
			List<Encounter> encounter, List<Facility> facility) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.vitals = vitals;
		this.encounter = encounter;
		this.facility = facility;
	}




	public List<Encounter> getEncounter() {
		return encounter;
	}




	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}




	public List<Facility> getFacility() {
		return facility;
	}




	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}




	public Patient() {
		super();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Vitals> getVitals() {
		return vitals;
	}
	public void setVitals(List<Vitals> vitals) {
		this.vitals = vitals;
	}
	

}
