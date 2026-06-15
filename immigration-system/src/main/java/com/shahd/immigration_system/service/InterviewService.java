package com.shahd.immigration_system.service;

import com.shahd.immigration_system.repository.ApplicantRepository;
import com.shahd.immigration_system.repository.InterviewRepository;
import com.shahd.immigration_system.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private OfficerRepository officerRepository;
}
