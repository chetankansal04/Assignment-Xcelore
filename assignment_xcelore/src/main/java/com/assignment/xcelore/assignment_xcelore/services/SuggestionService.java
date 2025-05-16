package com.assignment.xcelore.assignment_xcelore.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.xcelore.assignment_xcelore.entity.Doctor;
import com.assignment.xcelore.assignment_xcelore.entity.Patient;
import com.assignment.xcelore.assignment_xcelore.repository.DoctorRepository;
import com.assignment.xcelore.assignment_xcelore.repository.PatientRepository;

@Service
public class SuggestionService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private static final Map<String, String> symptomToSpeciality = Map.ofEntries(
        Map.entry("Arthritis", "Orthopaedic"),
        Map.entry("Back Pain", "Orthopaedic"),
        Map.entry("Tissue injuries", "Orthopaedic"),

        Map.entry("Dysmenorrhea", "Gynecology"),
        Map.entry("Pelvic Pain", "Gynecology"),
        Map.entry("Irregular Periods", "Gynecology"),

        Map.entry("Skin infection", "Dermatology"),
        Map.entry("Skin burn", "Dermatology"),
        Map.entry("Acne", "Dermatology"),
        Map.entry("Rashes", "Dermatology"),

        Map.entry("Ear pain", "ENT"),
        Map.entry("Sore Throat", "ENT"),
        Map.entry("Sinus Issues", "ENT"),
        Map.entry("Hearing loss", "ENT")
    );

    private static final List<String> supportedCities = List.of("Delhi", "Noida", "Faridabad");

    public String getSuggestedDoctors(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isEmpty()) {
            return "Patient not found";
        }

        Patient patient = optionalPatient.get();
        String city = patient.getCity();
        String symptom = patient.getSymptom();

        if (!supportedCities.contains(city)) {
            return "We are still waiting to expand to your location";
        }

        String speciality = symptomToSpeciality.get(symptom);
        if (speciality == null) {
            return "There isn't any doctor present at your location for your symptom";
        }

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);
        if (doctors.isEmpty()) {
            return "There isn't any doctor present at your location for your symptom";
        }

        return doctors.toString(); // Replace with proper response model if needed
    }
}
