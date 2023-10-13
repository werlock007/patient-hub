package com.straumann.group.patienthub.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.entity.Patient;
import com.straumann.group.patienthub.exception.PatientException;
import com.straumann.group.patienthub.repository.PatientRepository;
import com.straumann.group.patienthub.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	@Cacheable(value = "patients")
	public List<Patient> getAllPatients(){
		Iterable<Patient> patients = patientRepository.findAll();
		List<Patient> patientList = StreamSupport.stream(patients.spliterator(), false)
		            .collect(Collectors.toList());

		return patientList;
	
	}
	@Override
	public Patient getPatientById(Long patientId){
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isEmpty()) {
			throw new PatientException("No patient found with".concat(patientId.toString()).concat("Id"));
		}
		return patient.get();
	
	}

	@Override
	public Patient getPatientByName(String patientName) {
		Optional<Patient> patient = patientRepository.findByPatientName(patientName);
		if(patient.isEmpty()) {
			throw new PatientException("No patient found with".concat(patientName).concat(" Name"));
		}
		return patient.get();
			
	}

	@Override
	@CacheEvict(value = "patients", key = "#patientId")
	public boolean deletePatient(Long patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isPresent()) {
			Patient patientTemp = patient.get(); 
			patientRepository.delete(patientTemp);
			return true;
		}
		return false;
	}

	@Override
	@CachePut(value = "patients", key = "#updatedPatient.id")
	 public boolean updatePatient(Patient updatedPatient) {
        // Check if the patient with the given ID exists
        Long patientId = updatedPatient.getId();
        if (patientRepository.existsById(patientId)) {
            // The patient exists, so update its properties
            Patient existingPatient = patientRepository.findById(patientId).get();
            existingPatient.setPatientName(updatedPatient.getPatientName());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setDiagnosis(updatedPatient.getDiagnosis());
            existingPatient.setInsurance(updatedPatient.getInsurance());
            existingPatient.setMedicalHistory(updatedPatient.getMedicalHistory());
            existingPatient.setAppointments(updatedPatient.getAppointments());
            patientRepository.save(existingPatient);

            return true; // Patient updated successfully
        } else {
            return false; // Patient with the given ID doesn't exist
        }
    }
	@Override
	public String createPatient(Patient patient) {
		patientRepository.save(patient);
		return patient.getPatientName();
	}
	


}
