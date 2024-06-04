package com.vijay.patientclinicals.clinicalsapi.clinicalsapi.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.models.ClinicalData;

@Repository
public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
    // You can define custom queries here if needed
}