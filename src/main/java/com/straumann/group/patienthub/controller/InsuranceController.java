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

import com.straumann.group.patienthub.dto.Response;
import com.straumann.group.patienthub.entity.Insurance;
import com.straumann.group.patienthub.service.InsuranceService;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<Response> getAllInsurances() {
    	return  ResponseEntity.ok(generateResponse(
				"successfully created", 
				HttpStatus.OK.name(), insuranceService.getAllInsurance()));
    }



    @PostMapping
    public ResponseEntity<Response> createInsurance(@RequestBody Insurance insurance) {
    	return  ResponseEntity.ok(generateResponse(
				"successfully created", 
				HttpStatus.OK.name(), insuranceService.createInsurance(insurance)));
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteInsurance(@PathVariable Long id) {
    	return  ResponseEntity.ok(generateResponse(
				"successfully deleted", 
				HttpStatus.OK.name(), insuranceService.deleteInsurance(id)));
    }
    
    private Response generateResponse(String message, String status, Object responseData) {
    	Response response = new Response();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setResponseData(responseData);
    	return response;
    }
}
