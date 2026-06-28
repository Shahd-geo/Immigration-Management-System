package com.shahd.immigration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visaType;
    private String status;
    private String officerNotes;

    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private ImmigrationOfficer handlingOfficer;

}
