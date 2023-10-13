package com.straumann.group.patienthub.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.dto.DoctorDTO;
import com.straumann.group.patienthub.entity.Doctor;
import com.straumann.group.patienthub.repository.DoctorRepository;
import com.straumann.group.patienthub.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public boolean deleteDoctor(Long docId) {
		Optional<Doctor> doctor = doctorRepository.findById(docId);
		if(doctor.isPresent()) {
			doctorRepository.delete(doctor.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		Iterable<Doctor> doctors = doctorRepository.findAll();
		List<Doctor> doctorList = StreamSupport.stream(doctors.spliterator(), false)
		            .collect(Collectors.toList());

		return doctorList;
	}

	@Override
	public String createDoctor(DoctorDTO doctor) {
		try {
			Doctor doctorEntity = new Doctor();
			doctorEntity.setDoctorName(doctor.getDoctorName());
			doctorEntity.setSpecialty(doctor.getDoctorSpecialty());
			doctorRepository.save(doctorEntity);
			return doctor.getDoctorName();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return doctor.getDoctorName();
	
	}
	

}
