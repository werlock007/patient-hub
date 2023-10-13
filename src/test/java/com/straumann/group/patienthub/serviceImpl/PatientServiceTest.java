package com.straumann.group.patienthub.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.straumann.group.patienthub.entity.Patient;
import com.straumann.group.patienthub.enums.Gender;
import com.straumann.group.patienthub.exception.PatientException;
import com.straumann.group.patienthub.repository.PatientRepository;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientServiceImpl patientService;

    @Mock
    private PatientRepository patientRepository;


    @Test
    public void testGetAllPatients() {
    	List<Patient> mockPatients = Arrays.asList(new Patient(), new Patient());
    	when(patientRepository.findAll()).thenReturn(mockPatients);
    	List<Patient> result = patientService.getAllPatients();
    	assertEquals(mockPatients, result);
    }
    
    @Test
    public void testGetPatientById() {
        Long patientId = 1L;
        Patient mockPatient = new Patient();
        mockPatient.setId(patientId);
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(mockPatient));
       	Patient result = patientService.getPatientById(patientId);
       	assertEquals(mockPatient, result);
    }

    @Test
    public void testGetPatientByIdNotFound() {
        Long patientId = 1L;
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());
        assertThrows(PatientException.class, () -> {
            patientService.getPatientById(patientId);
        });
    }
    
    @Test
    public void testDeletePatient() {
        Long patientId = 1L;
        Patient mockPatient = new Patient();
        mockPatient.setId(patientId);
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(mockPatient));
        when(patientRepository.existsById(patientId)).thenReturn(true);
        boolean result = patientService.deletePatient(patientId);
        assertTrue(result);
    }

    @Test
    public void testDeletePatientNotFound() {
        Long patientId = 1L;
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());
        boolean result = patientService.deletePatient(patientId);
        assertFalse(result);
    }
    @Test
    public void testUpdatePatient() {
        Long patientId = 1L;
        Patient updatedPatient = new Patient();
        updatedPatient.setId(patientId);
        updatedPatient.setPatientName("Updated Name");
        updatedPatient.setAge(35);
        updatedPatient.setGender(Gender.FEMALE);
        updatedPatient.setDiagnosis("Updated Diagnosis");
        Patient existingPatient = new Patient();
        existingPatient.setId(patientId);
        existingPatient.setPatientName("Original Name");
        existingPatient.setAge(30);
        existingPatient.setGender(Gender.MALE);
        existingPatient.setDiagnosis("Original Diagnosis");
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(existingPatient));
        when(patientRepository.existsById(patientId)).thenReturn(true);
        boolean result = patientService.updatePatient(updatedPatient);
        assertTrue(result);
        assertEquals(updatedPatient.getPatientName(), existingPatient.getPatientName());
        assertEquals(updatedPatient.getAge(), existingPatient.getAge());
        assertEquals(updatedPatient.getGender(), existingPatient.getGender());
        assertEquals(updatedPatient.getDiagnosis(), existingPatient.getDiagnosis());

    }

}
