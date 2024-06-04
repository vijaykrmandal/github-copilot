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

import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.controllers.ClinicalDataController;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.models.ClinicalData;
import com.vijay.patientclinicals.clinicalsapi.clinicalsapi.repos.ClinicalDataRepository;

@SpringBootTest
public class ClinicalDataControllerTest {

    @Autowired
    private ClinicalDataController clinicalDataController;

    @MockBean
    private ClinicalDataRepository clinicalDataRepository;

    @Test
    public void testCreateClinicalData() {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.save(any(ClinicalData.class))).thenReturn(clinicalData);
        ClinicalData created = clinicalDataController.createClinicalData(clinicalData);
        assertEquals(created, clinicalData);
    }

    @Test
    public void testGetClinicalData() {
        ClinicalData clinicalData1 = new ClinicalData();
        ClinicalData clinicalData2 = new ClinicalData();
        List<ClinicalData> clinicalDataList = Arrays.asList(clinicalData1, clinicalData2);
        when(clinicalDataRepository.findAll()).thenReturn(clinicalDataList);
        List<ClinicalData> returned = clinicalDataController.getClinicalData();
        assertEquals(returned, clinicalDataList);
    }

    @Test
    public void testGetClinicalDataById() {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.findById(any(Long.class))).thenReturn(Optional.of(clinicalData));
        ClinicalData returned = clinicalDataController.getClinicalData(1L);
        assertEquals(returned, clinicalData);
    }

    @Test
    public void testUpdateClinicalData() {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.save(any(ClinicalData.class))).thenReturn(clinicalData);
        ClinicalData updated = clinicalDataController.updateClinicalData(1L, clinicalData);
        assertEquals(updated, clinicalData);
    }

    @Test
    public void testDeleteClinicalData() {
        doNothing().when(clinicalDataRepository).deleteById(any(Long.class));
        clinicalDataController.deleteClinicalData(1L);
        verify(clinicalDataRepository, times(1)).deleteById(any(Long.class));
    }
}