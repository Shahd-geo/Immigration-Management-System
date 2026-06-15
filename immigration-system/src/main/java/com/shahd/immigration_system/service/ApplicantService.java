package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.Interview;
import com.shahd.immigration_system.exception.ErrorMessages;
import com.shahd.immigration_system.exception.ImmigrationException;
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
            throw ImmigrationException.badRequest(ErrorMessages.PASSPORT_REQUIRED);
        }
        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()) {
            throw ImmigrationException.badRequest(ErrorMessages.FIRST_NAME_REQUIRED);
        }

        if (applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            throw ImmigrationException.badRequest(ErrorMessages.LAST_NAME_REQUIRED);
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
                orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.APPLICANT_NOT_FOUND);
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

