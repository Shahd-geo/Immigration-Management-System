package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
import com.shahd.immigration_system.entity.Interview;
import com.shahd.immigration_system.repository.ApplicantRepository;
import com.shahd.immigration_system.repository.InterviewRepository;
import com.shahd.immigration_system.repository.OfficerRepository;
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

    public Interview scheduleInterview(Long applicantId, Long officerId, String date) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));
        List<Interview> interviews = interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);

        if (!interviews.isEmpty()) {
            throw new RuntimeException("Officer is double-booked!");
        }
        Interview interview = new Interview();
        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(date);
        interview.setStatus("SCHEDULED");
        return interviewRepository.save(interview);
    }
    public Interview completeInterview(Long interviewId) {

}
