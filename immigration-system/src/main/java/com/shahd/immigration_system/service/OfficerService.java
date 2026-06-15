package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.ImmigrationOfficer;
import com.shahd.immigration_system.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {
    @Autowired
    private OfficerRepository officerRepository;


    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel){
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));
        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5");
        }

    }
}
