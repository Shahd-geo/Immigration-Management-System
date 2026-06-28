package com.shahd.immigration_system.Service;

import com.shahd.immigration_system.Entity.BorderControlOfficer;
import com.shahd.immigration_system.Entity.ImmigrationCenter;
import com.shahd.immigration_system.Entity.ImmigrationOfficer;
import com.shahd.immigration_system.Exception.ErrorMessages;
import com.shahd.immigration_system.Exception.ImmigrationException;
import com.shahd.immigration_system.Repository.CenterRepository;
import com.shahd.immigration_system.Repository.OfficerRepository;
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

    public ImmigrationOfficer saveOfficer(ImmigrationOfficer officer) {
        return officerRepository.save(officer);
    }

    public BorderControlOfficer saveBorderOfficer(BorderControlOfficer officer) {
        return officerRepository.save(officer);
    }

    public ImmigrationOfficer getOfficer(Long id) {
        return officerRepository.findById(id)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
    }


    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel){
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw ImmigrationException.badRequest(ErrorMessages.INVALID_CLEARANCE_LEVEL);
        }
        officer.setOfficerRank(newRank);
        officer.setClearanceLevel(newClearanceLevel);
        return officerRepository.save(officer);

    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {
        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.OFFICER_NOT_FOUND));
        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> ImmigrationException.notFound(ErrorMessages.CENTER_NOT_FOUND));
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
