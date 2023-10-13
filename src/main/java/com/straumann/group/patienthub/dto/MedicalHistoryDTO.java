package com.straumann.group.patienthub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryDTO {
	private String condition;
	private String treatment;
	private String patientName;
}
