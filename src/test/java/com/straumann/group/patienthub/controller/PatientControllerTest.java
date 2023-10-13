package com.straumann.group.patienthub.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.straumann.group.patienthub.dto.Response;
import com.straumann.group.patienthub.entity.Patient;
import com.straumann.group.patienthub.enums.Gender;
import com.straumann.group.patienthub.service.PatientService;

@ExtendWith(SpringExtension.class)
public class PatientControllerTest {
    @InjectMocks
	private PatientController patientController;

    @Mock
    private PatientService patientService;


    @Test
    public void testGetAllPatientDetails() {
        List<Patient> mockPatients = Arrays.asList(new Patient(), new Patient());
        when(patientService.getAllPatients()).thenReturn(mockPatients);
        ResponseEntity<Response> responseEntity = patientController.getAllPatientDetails();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Response response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals(HttpStatus.OK.name(), response.getStatus());
        assertEquals(mockPatients, response.getResponseData());
    }
    
    @Test
    public void testGetPatientByName() {
        String patientName = "John Doe";
        Patient mockPatient = new Patient();
        mockPatient.setPatientName(patientName);
        when(patientService.getPatientByName(patientName)).thenReturn(mockPatient);
        ResponseEntity<Response> responseEntity = patientController.getPatientByName(patientName);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Response response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals("successfully fetched the patient", response.getMessage());
        assertEquals(HttpStatus.OK.name(), response.getStatus());
        assertEquals(mockPatient, response.getResponseData());
    }
    
    @Test
    public void testDeletePatient() {
        Long patientId = 1L;
        when(patientService.deletePatient(patientId)).thenReturn(true);
        ResponseEntity<Response> responseEntity = patientController.deletePatient(patientId);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Response response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals("successfully deleted the patient", response.getMessage());
        assertEquals(HttpStatus.OK.name(), response.getStatus());
    }
    
    @Test
    public void testCreatePatient() {
        Patient newPatient = new Patient();
        newPatient.setPatientName("John Doe");
        newPatient.setAge(30);
        newPatient.setGender(Gender.MALE);
        newPatient.setDiagnosis("Sample Diagnosis");
        when(patientService.createPatient(newPatient)).thenReturn("John Doe");
        ResponseEntity<Response> responseEntity = patientController.create(newPatient);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Response response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals("successfully created the patient", response.getMessage());
        assertEquals(HttpStatus.OK.name(), response.getStatus());
    
    }
    
    @Test
    public void testUpdatePatientData() {
        // Mock data for the updated patient
        Patient updatedPatient = new Patient();
        updatedPatient.setPatientName("Updated Name");
        updatedPatient.setAge(35);
        updatedPatient.setGender(Gender.FEMALE);
        updatedPatient.setDiagnosis("Updated Diagnosis");
        when(patientService.updatePatient(updatedPatient)).thenReturn(true);
        ResponseEntity<Response> responseEntity = patientController.upePatientdat(updatedPatient);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Response response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals("successfully updated the patient", response.getMessage());
        assertEquals(HttpStatus.OK.name(), response.getStatus());
        // You can add more assertions if needed
    }
}
