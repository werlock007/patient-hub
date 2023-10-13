package com.straumann.group.patienthub.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.straumann.group.patienthub.enums.Gender;

import lombok.Data;


@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "full_name", nullable = false)
    private String patientName;

    @NotNull(message = "Age is required")
    @Column(name = "age", nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Gender is required")
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotBlank(message = "Diagnosis is required")
    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @JsonManagedReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalHistory> medicalHistory;

    @JsonManagedReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors;
    


}
