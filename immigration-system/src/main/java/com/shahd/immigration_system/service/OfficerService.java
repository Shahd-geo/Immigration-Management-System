package com.shahd.immigration_system.service;

import com.shahd.immigration_system.entity.ImmigrationCenter;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
import com.shahd.immigration_system.exception.ErrorMessages;
import com.shahd.immigration_system.exception.ImmigrationException;
import com.shahd.immigration_system.repository.CenterRepository;
import com.shahd.immigration_system.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficerService {
    @Autowired
    private OfficerRepository officerRepository;
    @Autowired
    private CenterRepository centerRepository;


    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel){
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw new RuntimeException("Clearance level must be between 1 and 5");
        }
        officer.setOfficerRank(newRank);
        officer.setClearanceLevel(newClearanceLevel);
        return officerRepository.save(officer);

    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));
        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("Center not found"));
        officer.setCenter(center);
        return officerRepository.save(officer);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank) {
        return officerRepository.findByOfficerRank(rank);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank, int minimumClearanceLevel){
        List<ImmigrationOfficer> officers = officerRepository.findByOfficerRank(rank);

        List<ImmigrationOfficer> result = new ArrayList<>();

        for (ImmigrationOfficer officer : officers) {

            if (officer.getClearanceLevel() >= minimumClearanceLevel) {
                result.add(officer);
            }

        }

        return result;
    }

}
