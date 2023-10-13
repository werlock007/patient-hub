package com.straumann.group.patienthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.straumann.group.patienthub.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	

}
