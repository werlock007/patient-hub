package com.straumann.group.patienthub.service;

import com.straumann.group.patienthub.entity.MedicalHistory;

import java.util.List;

public interface MedicalHistoryService {
    List<MedicalHistory> getAllMedicalHistories();
    MedicalHistory getMedicalHistoryById(Long id);
    MedicalHistory createMedicalHistory(MedicalHistory medicalHistory);
    MedicalHistory updateMedicalHistory(Long id, MedicalHistory medicalHistory);
    boolean deleteMedicalHistory(Long id);
}
