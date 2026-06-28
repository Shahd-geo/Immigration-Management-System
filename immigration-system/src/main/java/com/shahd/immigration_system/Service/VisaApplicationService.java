package com.shahd.immigration_system.Service;

import com.shahd.immigration_system.Entity.Applicant;
import com.shahd.immigration_system.Entity.ImmigrationOfficer;
import com.shahd.immigration_system.Entity.VisaApplication;
import com.shahd.immigration_system.Exception.ErrorMessages;
import com.shahd.immigration_system.Exception.ImmigrationException;
import com.shahd.immigration_system.Repository.ApplicantRepository;
import com.shahd.immigration_system.Repository.OfficerRepository;
import com.shahd.immigration_system.Repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                throw ImmigrationException.badRequest(ErrorMessages.ASYLUM_CLEARANCE_REQUIRED);
            }

        }
        visaApplication.setHandlingOfficer(officer);

        return visaApplicationRepository.save(visaApplication);
    }
    public VisaApplication processVisa(Long visaId, String newStatus, String notes){

        VisaApplication visaApplication = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.VISA_NOT_FOUND));
        if (!newStatus.equalsIgnoreCase("APPROVED") && !newStatus.equalsIgnoreCase("REJECTED")) {
            throw ImmigrationException.badRequest(ErrorMessages.INVALID_VISA_STATUS);
        }
        visaApplication.setStatus(newStatus);
        visaApplication.setOfficerNotes(notes);

        return visaApplicationRepository.save(visaApplication);
    }

    //
    public List<VisaApplication> getApplicantVisas(Long applicantId) {

        applicantRepository.findById(applicantId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.APPLICANT_NOT_FOUND));
        return visaApplicationRepository.findByApplicantId(applicantId);
    }
    public List<VisaApplication> getVisasByStatus(String status) {
        return visaApplicationRepository.findByStatus(status);
    }


}
