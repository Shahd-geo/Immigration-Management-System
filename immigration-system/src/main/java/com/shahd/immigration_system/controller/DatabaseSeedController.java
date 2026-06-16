package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.entity.ImmigrationCenter;
import com.shahd.immigration_system.repository.ApplicantRepository;
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
    @Autowired
    private ApplicantRepository applicantRepository;
    @PostMapping("/api/seed")
    public String seedDatabase() {
        // Centers
        ImmigrationCenter center1 = new ImmigrationCenter();
        center1.setName("Muscat Center");
        center1.setLocationCountry("Oman");
        center1.setType("Embassy");
        center1.setDailyCapacity(200);
        ImmigrationCenter center2 = new ImmigrationCenter();


    }


}
