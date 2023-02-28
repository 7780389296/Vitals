package com.cerner.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="encounter")
public class Encounter {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Encounter_Id;
	
	private int patient_Id;
	
	
	private int facility_Id;


	
	public Encounter() {
		super();
	}


	public int getEncounter_Id() {
		return Encounter_Id;
	}


	public void setEncounter_Id(int encounter_Id) {
		Encounter_Id = encounter_Id;
	}


	public int getPatient_Id() {
		return patient_Id;
	}


	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}


	public int getFacility_Id() {
		return facility_Id;
	}


	public void setFacility_Id(int facility_Id) {
		this.facility_Id = facility_Id;
	}
	
	
	
	




	

	

	
	
	

}
