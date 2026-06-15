package com.shahd.immigration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;

    private String nationality;

    private boolean criminalRecord;

    @OneToMany(mappedBy = "applicant")
    private List<VisaApplication> visaApplications;
}
