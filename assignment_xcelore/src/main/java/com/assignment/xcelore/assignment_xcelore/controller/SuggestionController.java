
package com.assignment.xcelore.assignment_xcelore.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.xcelore.assignment_xcelore.entity.Doctor;
import com.assignment.xcelore.assignment_xcelore.entity.Patient;
import com.assignment.xcelore.assignment_xcelore.repository.DoctorRepository;
import com.assignment.xcelore.assignment_xcelore.repository.PatientRepository;
import com.assignment.xcelore.assignment_xcelore.services.PatientServices;
import com.assignment.xcelore.assignment_xcelore.services.SuggestionService;

@RestController
@RequestMapping("api/suggestions")
public class SuggestionController {

  @Autowired
  private SuggestionService suggestionService;

  @Autowired
  private PatientServices patientService;

  @GetMapping
  public ResponseEntity<?> suggestDoctors(@RequestParam Long patientId) {
    Patient patient = patientService.getPatientById(patientId);
    if (patient == null) {
      return ResponseEntity.badRequest().body("Patient not found");
    }

    Object result = suggestionService.getSuggestedDoctors(patientId);
    return ResponseEntity.ok(result);
  }

}
