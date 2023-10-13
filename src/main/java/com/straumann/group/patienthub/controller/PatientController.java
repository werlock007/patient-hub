package com.straumann.group.patienthub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.straumann.group.patienthub.dto.Response;
import com.straumann.group.patienthub.entity.Patient;
import com.straumann.group.patienthub.service.PatientService;



@RestController
@RequestMapping("api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("get-all")
	public ResponseEntity<Response> getAllPatientDetails(){
		
		return  ResponseEntity.ok(generateResponse(
				"succsessfully fetched the patient", 
				HttpStatus.OK.name(), 
				patientService.getAllPatients()));
	}
	
	@GetMapping
	public ResponseEntity<Response> getPatientByName(@RequestParam String patientName){
		
		return  ResponseEntity.ok(generateResponse(
				"successfully fetched the patient", 
				HttpStatus.OK.name(), 
				patientService.getPatientByName(patientName)));
	}
	
	@DeleteMapping
	public ResponseEntity<Response> deletePatient(@RequestParam Long patientId){
		
		return  ResponseEntity.ok(generateResponse(
				"successfully deleted the patient", 
				HttpStatus.OK.name(), 
				patientService.deletePatient(patientId)));
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody Patient patient){
		
		return  ResponseEntity.ok(generateResponse(
				"successfully created the patient", 
				HttpStatus.OK.name(), 
				patientService.createPatient(patient)));
	}
	
	@PostMapping("update-patient")
	public ResponseEntity<Response> upePatientdat(@RequestBody Patient patient){
		
		return  ResponseEntity.ok(generateResponse(
				"successfully updated the patient", 
				HttpStatus.OK.name(), 
				patientService.updatePatient(patient)));
	}
	
	
	
    private Response generateResponse(String message, String status, Object responseData) {
    	Response response = new Response();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setResponseData(responseData);
    	return response;
    }
}
