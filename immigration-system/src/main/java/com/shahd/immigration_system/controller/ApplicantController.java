package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.dto.ApplicantDTO;
import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    //POST /api/applicants
    @PostMapping
    public ApplicantDTO createApplicant(@RequestBody Applicant applicant) {

        return ApplicantDTO.convertToDTO(applicantService.saveApplicant(applicant)
        );
    }

}
