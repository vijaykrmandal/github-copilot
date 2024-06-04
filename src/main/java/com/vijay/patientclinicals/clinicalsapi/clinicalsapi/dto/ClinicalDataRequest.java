/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.vijay.patientclinicals.clinicalsapi.clinicalsapi.dto;

public class ClinicalDataRequest {
    private String componentName;
    private String componentValue;
    private Long patientId;

    public ClinicalDataRequest() {
    }

    public ClinicalDataRequest(String componentName, String componentValue, Long patientId) {
        this.componentName = componentName;
        this.componentValue = componentValue;
        this.patientId = patientId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentValue() {
        return componentValue;
    }

    public void setComponentValue(String componentValue) {
        this.componentValue = componentValue;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

}
