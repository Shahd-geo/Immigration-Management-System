package com.shahd.immigration_system.Service;

import com.shahd.immigration_system.Entity.Applicant;
import com.shahd.immigration_system.Entity.ImmigrationOfficer;
import com.shahd.immigration_system.Entity.Interview;
import com.shahd.immigration_system.Exception.ErrorMessages;
import com.shahd.immigration_system.Exception.ImmigrationException;
import com.shahd.immigration_system.Repository.ApplicantRepository;
import com.shahd.immigration_system.Repository.InterviewRepository;
import com.shahd.immigration_system.Repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private OfficerRepository officerRepository;

    public Interview scheduleInterview(Long applicantId, Long officerId, String date, String purpose) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() ->  ImmigrationException.notFound(ErrorMessages.APPLICANT_NOT_FOUND));
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
        List<Interview> interviews = interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);

        if (!interviews.isEmpty()) {
            throw ImmigrationException.badRequest(ErrorMessages.OFFICER_DOUBLE_BOOKED);
        }
        Interview interview = new Interview();
        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(date);
        interview.setStatus("SCHEDULED");
        interview.setPurpose(purpose);
        return interviewRepository.save(interview);
    }

    public Interview completeInterview(Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.INTERVIEW_NOT_FOUND));
        interview.setStatus("COMPLETED");
        return interviewRepository.save(interview);
    }

    public Interview cancelInterview(Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.INTERVIEW_NOT_FOUND));
        interview.setStatus("CANCELLED");
        return interviewRepository.save(interview);
    }
    public List<Interview> getOfficerSchedule(Long officerId, String date) {
        return interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);
    }

}
