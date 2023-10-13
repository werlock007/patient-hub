package com.straumann.group.patienthub.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.entity.Insurance;
import com.straumann.group.patienthub.repository.InsuranceRepository;
import com.straumann.group.patienthub.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	InsuranceRepository insuranceRepository;

	@Override
	public boolean deleteInsurance(Long insuranceId) {
		Optional<Insurance> insurance = insuranceRepository.findById(insuranceId);
		if(insurance.isPresent()) {
			insuranceRepository.delete(insurance.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		Iterable<Insurance> insurances = insuranceRepository.findAll();
		List<Insurance> insuranceList = StreamSupport.stream(insurances.spliterator(), false)
		            .collect(Collectors.toList());

		return insuranceList;
	}

	@Override
	public String createInsurance(Insurance insurance) {
		try {
			insuranceRepository.save(insurance);
			return insurance.getPolicyNumber();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return insurance.getPolicyNumber();
	}

}
