package com.vijay.patientclinicals.clinicalsapi.clinicalsapi.models;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="patient" )
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClinicalData> clinicalData;
    
    // Default constructor
    public Patient() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // Constructor with all fields
    public Patient( String firstName, String lastName, int age, List<ClinicalData> clinicalData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.clinicalData = clinicalData;
    }
    // Other methods

    public List<ClinicalData> getClinicalData() {
        return clinicalData;
    }

    public void setClinicalData(List<ClinicalData> clinicalData) {
        this.clinicalData = clinicalData;
    }

}