package com.straumann.group.patienthub.dto;

import java.time.LocalDateTime;

import com.straumann.group.patienthub.entity.Doctor;
import com.straumann.group.patienthub.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    private Doctor doctor;
    private Patient patient;
    
 
}
