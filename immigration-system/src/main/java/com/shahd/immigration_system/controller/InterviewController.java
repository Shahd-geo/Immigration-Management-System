package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.dto.InterviewDTO;
import com.shahd.immigration_system.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    // POST /api/interviews/schedule/{applicantId}/{officerId}?date=2025-06-16
    @PostMapping("/schedule/{applicantId}/{officerId}")
    public InterviewDTO scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date) {
        return InterviewDTO.convertToDTO(interviewService.scheduleInterview(applicantId, officerId, date));
    }


}
