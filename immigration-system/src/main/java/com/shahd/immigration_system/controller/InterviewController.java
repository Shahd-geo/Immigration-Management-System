package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
}
