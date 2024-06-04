package com.vijay.patientclinicals.clinicalsapi.clinicalsapi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.dto.ClinicalDataRequest;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.models.ClinicalData;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.repos.ClinicalDataRepository;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.repos.PatientRepository;

@RestController
@RequestMapping("/api/clinicalData")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ClinicalData createClinicalData(@RequestBody ClinicalData clinicalData) {
        return clinicalDataRepository.save(clinicalData);
    }

    @GetMapping
    public List<ClinicalData> getClinicalData() {
        return clinicalDataRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClinicalData getClinicalData(@PathVariable Long id) {
        return clinicalDataRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ClinicalData updateClinicalData(@PathVariable Long id, @RequestBody ClinicalData clinicalData) {
        clinicalData.setId(id);
        return clinicalDataRepository.save(clinicalData);
    }

    @DeleteMapping("/{id}")
    public void deleteClinicalData(@PathVariable Long id) {
        clinicalDataRepository.deleteById(id);
    }
    //method that receives patient id, clinical data and saves it to the database
    @PostMapping("/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());

        patientRepository.findById(request.getPatientId())
                .ifPresent(patient -> {
                    clinicalData.setPatient(patient);
                });
        return clinicalDataRepository.save(clinicalData);
    }
        
}