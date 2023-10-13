package com.straumann.group.patienthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.straumann.group.patienthub.entity.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {

}
