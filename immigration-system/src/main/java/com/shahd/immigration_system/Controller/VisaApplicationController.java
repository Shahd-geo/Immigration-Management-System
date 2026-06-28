package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.Dto.VisaApplicationDTO;
import com.shahd.immigration_system.Service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visas")
public class VisaApplicationController {
    @Autowired
    private VisaApplicationService visaApplicationService;

    // POST /api/visas/submit/{applicantId}?type
    @PostMapping("/submit/{applicantId}")
    public VisaApplicationDTO submitVisa(@PathVariable Long applicantId, @RequestParam String type) {
        return VisaApplicationDTO.convertToDTO(visaApplicationService.submitApplication(applicantId, type)
        );
    }
    // PUT /api/visas/{visaId}/assign/{officerId}
    @PutMapping("/{visaId}/assign/{officerId}")
    public VisaApplicationDTO assignOfficer(@PathVariable Long visaId, @PathVariable Long officerId) {
        return VisaApplicationDTO.convertToDTO(visaApplicationService.assignOfficer(visaId, officerId)
        );
    }
    // PUT /api/visas/{visaId}/process?status=APPROVED&notes=Approved
    @PutMapping("/{visaId}/process")
    public VisaApplicationDTO processVisa(@PathVariable Long visaId, @RequestParam String status, @RequestParam String notes) {

        return VisaApplicationDTO.convertToDTO(visaApplicationService.processVisa(visaId, status, notes)
        );
    }
    // GET /api/visas/applicant/{applicantId}
    @GetMapping("/applicant/{applicantId}")
    public List<VisaApplicationDTO> getApplicantVisas(@PathVariable Long applicantId) {
        return VisaApplicationDTO.convertToDTO(visaApplicationService.getApplicantVisas(applicantId)
        );
    }
    // GET /api/visas/status/{status}
    @GetMapping("/status/{status}")
    public List<VisaApplicationDTO> getVisasByStatus(@PathVariable String status) {
        return VisaApplicationDTO.convertToDTO(visaApplicationService.getVisasByStatus(status));
    }

}
