package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public Applicant saveApplicant(Applicant applicant){
        if(applicant.getPassportNumber() == null || applicant.getPassportNumber().isEmpty()){
            throw new RuntimeException("Passport number is required");
        }
        if(applicant.getFirstName() == null || applicant.getFirstName().isEmpty()){
            throw new RuntimeException("First name is required");
        }

        if(applicant.getLastName() == null || applicant.getLastName().isEmpty()){
            throw new RuntimeException("Last name is required");
        }

        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality){

}
