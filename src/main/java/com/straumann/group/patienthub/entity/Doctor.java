package com.straumann.group.patienthub.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.straumann.group.patienthub.enums.DoctorSpecialty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "specialty", nullable = false)
    private DoctorSpecialty specialty;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Medication> medication;
    
    @ManyToMany
    @JoinTable(
        name = "doctor_patient",
        joinColumns = @JoinColumn(name = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;

    @JsonManagedReference
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
