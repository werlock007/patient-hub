package com.straumann.group.patienthub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.straumann.group.patienthub.dto.DoctorDTO;
import com.straumann.group.patienthub.dto.Response;
import com.straumann.group.patienthub.entity.Doctor;
import com.straumann.group.patienthub.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<Response> getAllDoctors() {
    	return  ResponseEntity.ok(generateResponse(
				"successfully updated the patient", 
				HttpStatus.OK.name(), doctorService.getAllDoctor()));
    }

 

    @PostMapping
    public ResponseEntity<Response> createDoctor(@RequestBody DoctorDTO doctor) {
    	return  ResponseEntity.ok(generateResponse(
				"successfully updated the patient", 
				HttpStatus.OK.name(), doctorService.createDoctor(doctor)));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDoctor(@PathVariable Long id) {
    	return  ResponseEntity.ok(generateResponse(
				"successfully updated the patient", 
				HttpStatus.OK.name(),doctorService.deleteDoctor(id)));
    }
    
    private Response generateResponse(String message, String status, Object responseData) {
    	Response response = new Response();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setResponseData(responseData);
    	return response;
    }
}
