package com.shahd.immigration_system.Repository;

import com.shahd.immigration_system.Entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository   extends JpaRepository<Interview, Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);
    List<Interview> findByApplicantId(Long applicantId);
}
