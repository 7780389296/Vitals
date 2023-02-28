package com.cerner.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cerner.dto.PVRequestDTO;

//import com.cerner.dto.PVRequestDTO;

import com.cerner.model.Vitals;
import com.cerner.service.VitalService;



@Path("/vitalDetails")
//@Api("/patientInfo")
//@SwaggerDefinition(tags={@Tag(name="patientInfo",description="REST EndPoint for patientInfo")})
public class VitalsResource {
	VitalService vitalService = new VitalService();

	// CRUD -- CREATE operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String createVital(PVRequestDTO vitalReqDTO) {
		
		String response = vitalService.createVital(vitalReqDTO);
		return response;
	}

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vitals> getAllpatients() {
		List<Vitals> patientList = vitalService.getAllVitals();
		return patientList;
	}

	// CRUD -- READ operation
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vitals getpatientForId(@PathParam("id") Integer id) {
		Vitals patient = vitalService.getVitalForId(id);
		return patient;
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vitals updatepatient(Vitals patient) {
		Vitals patientResponse = vitalService.updateVital(patient);
		return patientResponse;
	}

	// CRUD -- DELETE operation
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vitals deleteepatient(@PathParam("id") Integer id) {
		Vitals patientResponse = vitalService.deleteVital(id);
		return patientResponse;
	}
	@GET
	@Path("/recent")
	@Produces(MediaType.APPLICATION_JSON)
	public Vitals getRecentData() {
		Vitals patientList = vitalService.recentData();
		return patientList;
	}
	
}
