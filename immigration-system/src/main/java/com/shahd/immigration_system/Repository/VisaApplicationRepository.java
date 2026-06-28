package com.shahd.immigration_system.Repository;

import com.shahd.immigration_system.Entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
    List<VisaApplication> findByApplicantId(Long applicantId);
    List<VisaApplication> findByStatus(String status);
}
