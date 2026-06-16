package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.entity.Applicant;
import com.shahd.immigration_system.entity.BorderControlOfficer;
import com.shahd.immigration_system.entity.ImmigrationCenter;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
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
        center2.setName("Salalah Center");
        center2.setLocationCountry("Oman");
        center2.setType("Border");
        center2.setDailyCapacity(100);
        centerRepository.save(center1);
        centerRepository.save(center2);

        // Officers
        ImmigrationOfficer officer1 = new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Ali");
        officer1.setBadgeNumber("OF001");
        officer1.setOfficerRank("Junior Officer");
        officer1.setClearanceLevel(2);
        officer1.setActive(true);
        officer1.setCenter(center1);
        ImmigrationOfficer officer2 = new ImmigrationOfficer();
        officer2.setFirstName("Sara");
        officer2.setLastName("Khalid");
        officer2.setBadgeNumber("OF002");
        officer2.setOfficerRank("Senior Officer");
        officer2.setClearanceLevel(5);
        officer2.setActive(true);
        officer2.setCenter(center1);

        BorderControlOfficer officer3 = new BorderControlOfficer();
        officer3.setFirstName("Mohammed");
        officer3.setLastName("Salim");
        officer3.setBadgeNumber("BC001");
        officer3.setOfficerRank("Border Officer");
        officer3.setClearanceLevel(3);
        officer3.setActive(true);
        officer3.setAssignedCheckpoint("Muscat Airport");
        officer3.setK9UnitAssigned(true);
        officer3.setCenter(center2);
        officerRepository.save(officer1);
        officerRepository.save(officer2);
        officerRepository.save(officer3);

        // Applicants
        Applicant applicant1 = new Applicant();
        applicant1.setFirstName("Ali");
        applicant1.setLastName("Hassan");
        applicant1.setPassportNumber("P11111");
        applicant1.setNationality("Omani");
        applicant1.setCriminalRecord(false);




    }


}
