package com.straumann.group.patienthub.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.straumann.group.patienthub.entity.Appointment;
import com.straumann.group.patienthub.entity.Doctor;
import com.straumann.group.patienthub.entity.MedicalHistory;
import com.straumann.group.patienthub.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String patientName;
    private int age;
    private Gender gender;
    private String diagnosis;
    private InsuranceDTO insurance; 
    private String primaryPhysician; 
    private List<MedicalHistory> medicalHistory;
    private List<Appointment> appointments;
    private Set<Doctor> doctors;
}
