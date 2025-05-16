
package com.assignment.xcelore.assignment_xcelore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.xcelore.assignment_xcelore.repository.DoctorRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment.xcelore.assignment_xcelore.entity.Doctor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.xcelore.assignment_xcelore.services.DoctorServices;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {

  @Autowired
  private DoctorServices doctorServices;

  @PostMapping
  public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
    return ResponseEntity.ok(doctorServices.addDoctor(doctor));
  }

  @GetMapping
  public ResponseEntity<List<Doctor>> getAllDoctors() {
    return ResponseEntity.ok(doctorServices.getAllDoctors());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
    doctorServices.deleteDoctor(id);
    return ResponseEntity.ok("Doctor removed successfully");
  }

}
