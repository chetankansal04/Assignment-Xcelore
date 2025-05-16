package com.assignment.xcelore.assignment_xcelore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.xcelore.assignment_xcelore.entity.Patient;
import com.assignment.xcelore.assignment_xcelore.repository.PatientRepository;

@Service
public class PatientServices {
  @Autowired
  private PatientRepository patientRepository;

  public Patient addPatient(Patient patient){
    return patientRepository.save(patient);
  }

  public List<Patient> getAllPatients(){
    return patientRepository.findAll();
  } 

  public void deletePatient(Long id){
    patientRepository.deleteById(id);
  }

  public Patient getPatientById(Long id){
    return patientRepository.findById(id).orElse(null);
  }
}
