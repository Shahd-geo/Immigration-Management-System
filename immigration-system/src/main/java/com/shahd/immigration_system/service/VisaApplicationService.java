package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.VisaApplication;
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
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
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
                .orElseThrow(() -> new RuntimeException("Visa application not found"));
    }
}
