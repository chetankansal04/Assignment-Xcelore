
package com.assignment.xcelore.assignment_xcelore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.xcelore.assignment_xcelore.entity.Doctor;

@Repository
public interface  DoctorRepository extends JpaRepository<Doctor, Long> {

  List<Doctor> findByCityAndSpeciality(String city, String speciality);



}
