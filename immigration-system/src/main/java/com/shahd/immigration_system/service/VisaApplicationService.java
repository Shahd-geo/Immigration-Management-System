package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
import com.shahd.immigration_system.entity.VisaApplication;
import com.shahd.immigration_system.exception.ErrorMessages;
import com.shahd.immigration_system.exception.ImmigrationException;
import com.shahd.immigration_system.repository.ApplicantRepository;
import com.shahd.immigration_system.repository.OfficerRepository;
import com.shahd.immigration_system.repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaApplicationService {
    @Autowired
    private VisaApplicationRepository visaApplicationRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private OfficerRepository officerRepository;

    public VisaApplication submitApplication(Long applicantId, String visaType) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.APPLICANT_NOT_FOUND));
        VisaApplication visaApplication = new VisaApplication();
        visaApplication.setVisaType(visaType);
        visaApplication.setApplicant(applicant);
        if (applicant.isCriminalRecord()) {
            visaApplication.setOfficerNotes("Auto-rejected due to criminal flag.");
            visaApplication.setStatus("REJECTED");

        } else {

            visaApplication.setStatus("PENDING");

        }
        return visaApplicationRepository.save(visaApplication);

    }
    public VisaApplication assignOfficer(Long visaId, Long officerId) {
        VisaApplication visaApplication = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.VISA_NOT_FOUND));
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() ->  ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
        if (visaApplication.getVisaType().equalsIgnoreCase("Asylum")) {
            if (officer.getClearanceLevel() < 4  ) {
                throw new RuntimeException("Asylum visas require clearance level 4 or 5");
            }

        }
        visaApplication.setHandlingOfficer(officer);

        return visaApplicationRepository.save(visaApplication);
    }
    public VisaApplication processVisa(Long visaId, String newStatus, String notes){

        VisaApplication visaApplication = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa application not found"));

        if (!newStatus.equalsIgnoreCase("APPROVED") && !newStatus.equalsIgnoreCase("REJECTED")) {

            throw new RuntimeException("Status must be APPROVED or REJECTED");
        }
        visaApplication.setStatus(newStatus);
        visaApplication.setOfficerNotes(notes);

        return visaApplicationRepository.save(visaApplication);
    }


}
