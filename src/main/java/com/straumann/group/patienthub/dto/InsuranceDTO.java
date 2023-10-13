package com.straumann.group.patienthub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDTO {
    private Long id;
    private String provider;
    private String policyNumber;
    private String coverage;
    
}

