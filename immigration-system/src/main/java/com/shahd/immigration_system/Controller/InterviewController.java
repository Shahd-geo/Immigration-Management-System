package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.Dto.InterviewDTO;
import com.shahd.immigration_system.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    // POST /api/interviews/schedule/{applicantId}/{officerId}?date=2025-06-16
    @PostMapping("/schedule/{applicantId}/{officerId}")
    public InterviewDTO scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date,@RequestParam String purpose) {
        return InterviewDTO.convertToDTO(interviewService.scheduleInterview(applicantId, officerId, date,purpose));
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
    // GET /api/interviews/officer/{officerId}/date/{date}
    @GetMapping("/officer/{officerId}/date/{date}")
    public List<InterviewDTO> getOfficerSchedule(@PathVariable Long officerId, @PathVariable String date) {
        return InterviewDTO.convertToDTO(interviewService.getOfficerSchedule(officerId, date));
    }



}
