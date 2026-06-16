package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.repository.CenterRepository;
import com.shahd.immigration_system.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseSeedController {
    @Autowired
    private CenterRepository centerRepository;
    @Autowired
    private OfficerRepository officerRepository;


}
