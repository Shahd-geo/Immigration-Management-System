package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.Interview;
import com.shahd.immigration_system.repository.ApplicantRepository;
import com.shahd.immigration_system.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private InterviewRepository interviewRepository;

    public Applicant saveApplicant(Applicant applicant) {
        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isEmpty()) {
            throw new RuntimeException("Passport number is required");
        }
        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()) {
            throw new RuntimeException("First name is required");
        }

        if (applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }

        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        return saveApplicant(applicant);
    }

    public Applicant flagCriminalRecord(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId).
                orElseThrow(() -> new RuntimeException("Applicant not found"));
                 applicant.setCriminalRecord(true);
                 applicantRepository.save(applicant);
        List<Interview> interviews = interviewRepository.findByApplicantId(applicantId);
        for (Interview interview : interviews) {
            if (interview.getStatus().equalsIgnoreCase("SCHEDULED")) {
                interview.setStatus("CANCELLED");
                interviewRepository.save(interview);
            }
        }

        return applicant;
    }

}

