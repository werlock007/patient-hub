package com.straumann.group.patienthub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.straumann.group.patienthub.entity.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	 Optional<Patient> findByPatientName(String patientName);

}
