package com.straumann.group.patienthub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.entity.Patient;


@Service
public interface PatientService {
	
	List<Patient> getAllPatients();
	
	Patient getPatientById(Long patientId);
	
	Patient getPatientByName(String patientName);
	
	boolean deletePatient(Long patientId);
	
	boolean updatePatient(Patient patient);
	
	String createPatient(Patient patient);
	
	

}
