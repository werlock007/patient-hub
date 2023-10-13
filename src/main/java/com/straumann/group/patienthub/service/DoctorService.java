package com.straumann.group.patienthub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.dto.DoctorDTO;
import com.straumann.group.patienthub.entity.Doctor;

@Service
public interface DoctorService {
	
	boolean deleteDoctor(Long docId);
	
	List<Doctor> getAllDoctor();
	
	String createDoctor(DoctorDTO doctor);
	
	//String updateDoctor(Doctor doctor);

}
