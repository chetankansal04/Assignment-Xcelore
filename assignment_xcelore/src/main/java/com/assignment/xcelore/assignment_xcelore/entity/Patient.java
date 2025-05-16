package com.assignment.xcelore.assignment_xcelore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 2, message = "Name must be atleast 3 characters")
  private String name;

  @Size(max = 20, message = "City must be atmost 20 characters")
  private String city;

  @Email(message = "Email should be valid")
  private String email;

  @Size(min = 10, message = "Phone no. should be of 10 characters")
  private String phone;

  @Pattern(regexp = "Arthritis|Back Pain|Tissue injuries|Dysmenorrhea|Skin infection|skin burn|Ear pain|Acne|Rashes|Skin Burn|Sore Throat|Sinus Issues|Hearing loss|Pelvic Pain|Irregular Periods", message = "Symptoms must be one of the allowed values")
  private String symptom;

}
