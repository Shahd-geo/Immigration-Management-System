package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository   extends JpaRepository<Interview, Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);
    List<Interview> findByApplicantId(Long applicantId);
}
