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
    // PUT /api/interviews/{id}/complete
    @PutMapping("/{id}/complete")
    public InterviewDTO completeInterview(@PathVariable Long id) {
        return InterviewDTO.convertToDTO(interviewService.completeInterview(id));
    }
    // PUT /api/interviews/{id}/cancel
    @PutMapping("/{id}/cancel")
    public InterviewDTO cancelInterview(@PathVariable Long id) {
        return InterviewDTO.convertToDTO(interviewService.cancelInterview(id));
    }



}
