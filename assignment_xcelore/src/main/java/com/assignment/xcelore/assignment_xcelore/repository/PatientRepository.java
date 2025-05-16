
package com.assignment.xcelore.assignment_xcelore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.xcelore.assignment_xcelore.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
