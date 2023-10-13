package com.straumann.group.patienthub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.straumann.group.patienthub.dto.Response;
import com.straumann.group.patienthub.entity.MedicalHistory;
import com.straumann.group.patienthub.service.MedicalHistoryService;

@RestController
@RequestMapping("/medical-history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping
    public ResponseEntity<Response> getAllMedicalHistories() {
    	return ResponseEntity.ok(generateResponse(
    			"Successfully fetched", 
    			HttpStatus.OK.name(),medicalHistoryService.getAllMedicalHistories()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getMedicalHistoryById(@PathVariable Long id) {
    	return ResponseEntity.ok(generateResponse(
    			"Successfully fetched", 
    			HttpStatus.OK.name(), medicalHistoryService.getMedicalHistoryById(id)));
    }

    @PostMapping
    public ResponseEntity<Response> createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
    	return ResponseEntity.ok(generateResponse(
    			"Successfully created", 
    			HttpStatus.OK.name(), medicalHistoryService.createMedicalHistory(medicalHistory)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
    	return  ResponseEntity.ok(generateResponse(
    			"Successfully updated", 
    			HttpStatus.OK.name(), medicalHistoryService.updateMedicalHistory(id, medicalHistory)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteMedicalHistory(@PathVariable Long id) {
    	return  ResponseEntity.ok(generateResponse(
    			"Successfully medical history  Deleted", 
    			HttpStatus.OK.name(), 
    			medicalHistoryService.deleteMedicalHistory(id)));
		
      
    }
    


	private Response generateResponse(String message, String status, Object responseData) {
    	Response response = new Response();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setResponseData(responseData);
    	return response;
    }
}
