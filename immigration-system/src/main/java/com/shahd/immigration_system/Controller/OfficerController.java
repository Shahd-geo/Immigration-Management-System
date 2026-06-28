package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.Dto.OfficerDTO;
import com.shahd.immigration_system.Entity.BorderControlOfficer;
import com.shahd.immigration_system.Entity.ImmigrationOfficer;
import com.shahd.immigration_system.Service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {
    @Autowired
    private OfficerService officerService;

    // POST /api/officers
    @PostMapping ("/add")
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
    // GET /api/officers/{id}
    @GetMapping("/{id}")
    public OfficerDTO getOfficer(@PathVariable Long id) {

        return OfficerDTO.convertToDTO(officerService.getOfficer(id));
    }
    // PUT /api/officers/{id}/promote
    @PutMapping("/{id}/promote")
    public OfficerDTO promoteOfficer(@PathVariable Long id, @RequestParam String rank, @RequestParam int clearance) {
        return OfficerDTO.convertToDTO(officerService.promoteOfficer(id, rank, clearance));
    }
    // PUT /api/officers/{id}/transfer/{centerId}
    @PutMapping("/{id}/transfer/{centerId}")
    public OfficerDTO transferOfficer(@PathVariable Long id, @PathVariable Long centerId) {
        return OfficerDTO.convertToDTO(officerService.transferOfficer(id, centerId));
    }
}
