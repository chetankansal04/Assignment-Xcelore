
package com.assignment.xcelore.assignment_xcelore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.xcelore.assignment_xcelore.entity.Doctor;
import com.assignment.xcelore.assignment_xcelore.repository.DoctorRepository;
@Service
public class DoctorServices {
  @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> findByCityAndSpeciality(String city, String speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }

}
