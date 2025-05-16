
package com.assignment.xcelore.assignment_xcelore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.xcelore.assignment_xcelore.repository.PatientRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment.xcelore.assignment_xcelore.entity.Patient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.xcelore.assignment_xcelore.services.PatientServices;

import jakarta.xml.ws.Response;

@RestController
@RequestMapping("api/patient")
public class PatientController {

  @Autowired
  private PatientServices patientService;

  @PostMapping
  public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
      return ResponseEntity.ok(patientService.addPatient(patient));
  }

  @GetMapping
  public ResponseEntity<List<Patient>> getAllPatients() {
      return ResponseEntity.ok(patientService.getAllPatients());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePatient(@PathVariable Long id) {
      patientService.deletePatient(id);
      return ResponseEntity.ok("Patient removed successfully");
  }

}
