package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.dto.VisaApplicationDTO;
import com.shahd.immigration_system.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visas")
public class VisaApplicationController {
    @Autowired
    private VisaApplicationService visaApplicationService;

    // POST /api/visas/submit/{applicantId}?type
    @PostMapping("/submit/{applicantId}")
    public VisaApplicationDTO submitVisa(@PathVariable Long applicantId, @RequestParam String type) {
        return VisaApplicationDTO.convertToDTO(visaApplicationService.submitApplication(applicantId, type)
        );
    }
}
