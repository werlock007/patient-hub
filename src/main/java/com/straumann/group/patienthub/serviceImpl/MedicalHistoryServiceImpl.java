package com.straumann.group.patienthub.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straumann.group.patienthub.entity.MedicalHistory;
import com.straumann.group.patienthub.repository.MedicalHistoryRepository;
import com.straumann.group.patienthub.service.MedicalHistoryService;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistory> getAllMedicalHistories() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public MedicalHistory getMedicalHistoryById(Long id) {
        Optional<MedicalHistory> optionalMedicalHistory = medicalHistoryRepository.findById(id);
        return optionalMedicalHistory.orElse(null);
    }

    @Override
    public MedicalHistory createMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public MedicalHistory updateMedicalHistory(Long id, MedicalHistory medicalHistory) {
        if (medicalHistoryRepository.existsById(id)) {
            medicalHistory.setId(id);
            return medicalHistoryRepository.save(medicalHistory);
        }
        return null;
    }

    @Override
    public boolean deleteMedicalHistory(Long medicalHistoryid) {
    	Optional<MedicalHistory> medicalHistory = medicalHistoryRepository.findById(medicalHistoryid);
		if(medicalHistory.isPresent()) {
			MedicalHistory medicalHistoryTemp = medicalHistory.get(); 
			medicalHistoryRepository.delete(medicalHistoryTemp);
			return true;
		}
		return false;
    }
}
