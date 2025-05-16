package com.assignment.xcelore.assignment_xcelore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Doctor {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 2, message = "Name must be atleast 3 characters")
  private String name;

  @Pattern(regexp = "Delhi|Noida|Faridabad", message = "City must be one of the allowed values")
  private String city;

  @Email(message = "Email should be valid")
  private String email;

  @Size(min = 10, message = "Phone no. must be of 10 characters")
  private String phone;

  @Pattern(regexp = "Orthopaedic|Gynecology|Dermatology|ENT", message = "Speciality must be one of the allowed values")
  private String speciality;

}
