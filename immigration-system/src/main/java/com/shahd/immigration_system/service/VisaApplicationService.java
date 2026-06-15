package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.VisaApplication;
import com.shahd.immigration_system.repository.ApplicantRepository;
import com.shahd.immigration_system.repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaApplicationService {
    @Autowired
    private VisaApplicationRepository visaApplicationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public VisaApplication submitApplication(Long applicantId, String visaType) {
}
