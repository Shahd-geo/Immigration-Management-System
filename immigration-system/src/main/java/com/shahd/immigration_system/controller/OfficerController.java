package com.shahd.immigration_system.controller;

import com.shahd.immigration_system.dto.OfficerDTO;
import com.shahd.immigration_system.entity.BorderControlOfficer;
import com.shahd.immigration_system.entity.ImmigrationOfficer;
import com.shahd.immigration_system.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {
    @Autowired
    private OfficerService officerService;

    // POST /api/officers
    @PostMapping ("/add ")
    public OfficerDTO createOfficer(@RequestBody ImmigrationOfficer officer) {
        return OfficerDTO.convertToDTO(officerService.saveOfficer(officer)
        );
    }
    // POST /api/officers/border
    @PostMapping("/border")
    public OfficerDTO createBorderOfficer(@RequestBody BorderControlOfficer officer) {

        return OfficerDTO.convertToDTO(officerService.saveBorderOfficer(officer)
        );
    }
}
