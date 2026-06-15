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
        return applicantRepository.save(applicant);
    }
}
