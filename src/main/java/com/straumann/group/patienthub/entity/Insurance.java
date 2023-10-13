package com.straumann.group.patienthub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provider is required")
    @Size(max = 255, message = "Provider name must not exceed 255 characters")
    @Column(name = "provider", nullable = false, length = 255)
    private String provider;

    @NotBlank(message = "Policy number is required")
    @Pattern(regexp = "[A-Z0-9]+", message = "Policy number must contain uppercase letters and digits only")
    @Size(min = 6, max = 20, message = "Policy number must be between 6 and 20 characters")
    @Column(name = "policy_number", nullable = false, length = 20)
    private String policyNumber;
    
    @NotBlank(message = "Policy coverage is required")
    @Column(name = "coverage", nullable = false, length = 255)
    private String coverage;

    // You can add more fields here if needed

    @JsonBackReference
    @OneToOne(mappedBy = "insurance")
    private Patient patient;

    // Constructors, getters, and setters
}