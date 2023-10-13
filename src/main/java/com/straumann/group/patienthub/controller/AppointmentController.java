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
import com.straumann.group.patienthub.entity.Appointment;
import com.straumann.group.patienthub.exception.AppointmentException;
import com.straumann.group.patienthub.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<Response> getAllAppointments() {
    	return ResponseEntity.ok(generateResponse(
				"successfully getched the Appointmant", 
				HttpStatus.OK.name(), appointmentService.getAllAppointments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getAppointmentById(@PathVariable Long id) {
    	return ResponseEntity.ok(generateResponse(
				"successfully getched the Appointmant", 
				HttpStatus.OK.name(), appointmentService.getAppointmentById(id)));
    }

    @PostMapping
    public ResponseEntity<Response> createAppointment(@RequestBody Appointment appointment) {
    	return ResponseEntity.ok(generateResponse(
				"successfully created the Appointmant", 
				HttpStatus.OK.name(), appointmentService.createAppointment(appointment)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) throws AppointmentException {
    	return ResponseEntity.ok(generateResponse(
				"successfully updated the Appointmant", 
				HttpStatus.OK.name(), appointmentService.updateAppointment(id, appointment)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAppointment(@PathVariable Long id) {
    	return  ResponseEntity.ok(generateResponse(
				"successfully updated the Appointmant", 
				HttpStatus.OK.name(),appointmentService.deleteAppointment(id)));
    }
    
    private Response generateResponse(String message, String status, Object responseData) {
    	Response response = new Response();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setResponseData(responseData);
    	return response;
    }
}
