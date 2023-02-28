package com.cerner.service;

import java.util.List;


import com.cerner.dao.VitalsDAO;
import com.cerner.dto.PVRequestDTO;
import com.cerner.dto.Pv;
import com.cerner.model.Vitals;

public class VitalService {
	VitalsDAO vitalDao = new VitalsDAO();

	public List<Vitals> getAllVitals() {
		List<Vitals> patientList = vitalDao.getAllVitals();
		return patientList;
	}

	public Vitals getVitalForId(Integer id) {
		Vitals patient = vitalDao.getVitalForId(id);
		return patient;
	}

	public String createVital(PVRequestDTO vitalReqDTO) {
		
		//paitientId -- encounterid  select * from encounter where patientId= ?vitalReqDTO.getPatientId()
		List<Pv>   lstPv = vitalReqDTO.getPv();
		Vitals v = new Vitals();
		int encounter_Id=  vitalDao.getEncounter(vitalReqDTO.getPatientId());
		for(Pv pv : lstPv) {
			
			v.setPatient_Id(vitalReqDTO.getPatientId());
			v.setEncounter_id(encounter_Id);
			v.setValue(pv.getValue());
			v.setVital_name(pv.getName());
			v.setUnitsOfMesurment(pv.getUom());
			
			
			vitalDao.createVital(v);
			
		}
		
		
		return "All vitals created succesfully";
	}

	public Vitals updateVital(Vitals vital) {
		Vitals patientResponse = vitalDao.updateVital(vital);
		return patientResponse;
	}

	public Vitals deleteVital(Integer id) {
		Vitals patientResponse = vitalDao.deleteVital(id);
		return patientResponse;
	}
	
	public Vitals recentData() {
		Vitals patientResponse = vitalDao.recentData();
		return patientResponse;
	}

}
