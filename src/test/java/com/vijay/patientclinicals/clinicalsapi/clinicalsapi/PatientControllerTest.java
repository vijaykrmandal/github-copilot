package com.vijay.patientclinicals.clinicalsapi.clinicalsapi;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.controllers.PatientController;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.models.Patient;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.repos.PatientRepository;

@SpringBootTest
public class PatientControllerTest {

    @Autowired
    private PatientController patientController;

    @MockBean
    private PatientRepository patientRepository;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);
        Patient created = patientController.createPatient(patient);
        assertEquals(created, patient);
    }

    @Test
    public void testGetPatients() {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        List<Patient> patients = Arrays.asList(patient1, patient2);
        when(patientRepository.findAll()).thenReturn(patients);
        List<Patient> returned = patientController.getPatients();
        assertEquals(returned, patients);
    }

    @Test
    public void testGetPatient() {
        Patient patient = new Patient();
        when(patientRepository.findById(any(Long.class))).thenReturn(Optional.of(patient));
        Patient returned = patientController.getPatient(1L);
        assertEquals(returned, patient);
    }

    @Test
    public void testUpdatePatient() {
        Patient patient = new Patient();
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);
        Patient updated = patientController.updatePatient(1L, patient);
        assertEquals(updated, patient);
    }

    @Test
    public void testDeletePatient() {
        doNothing().when(patientRepository).deleteById(any(Long.class));
        patientController.deletePatient(1L);
        verify(patientRepository, times(1)).deleteById(any(Long.class));
    }
}