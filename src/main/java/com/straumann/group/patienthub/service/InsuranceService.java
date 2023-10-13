package com.straumann.group.patienthub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.entity.Insurance;

@Service
public interface InsuranceService {
	
	boolean deleteInsurance(Long insuranceId);
	
	List<Insurance> getAllInsurance();
	
	String createInsurance(Insurance insurance);

}
