package com.straumann.group.patienthub.dto;

import com.straumann.group.patienthub.enums.DoctorSpecialty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
	private String doctorName;
	private DoctorSpecialty doctorSpecialty;
}
