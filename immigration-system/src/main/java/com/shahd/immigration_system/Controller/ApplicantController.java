package com.shahd.immigration_system.Controller;

import com.shahd.immigration_system.Dto.ApplicantDTO;
import com.shahd.immigration_system.Entity.Applicant;
import com.shahd.immigration_system.Entity.AsylumSeeker;
import com.shahd.immigration_system.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    //POST /api/applicants
    @PostMapping("/add")
    public ApplicantDTO createApplicant(@RequestBody Applicant applicant) {

        return ApplicantDTO.convertToDTO(applicantService.saveApplicant(applicant)
        );
    }
    //POST /api/applicants/asylum
    @PostMapping("/asylum")
    public ApplicantDTO createAsylumSeeker(@RequestBody AsylumSeeker seeker) {

        return ApplicantDTO.convertToDTO(applicantService.saveApplicant(seeker)
        );
    }
    //GET /api/applicants
    @GetMapping
    public List<ApplicantDTO> getAllApplicants() {
        return ApplicantDTO.convertToDTO(applicantService.getAllApplicants()
        );
    }
    //GET /api/applicants/search?nationality=Omani
    @GetMapping("/search")
    public List<ApplicantDTO> findByNationality(@RequestParam String nationality) {
        return ApplicantDTO.convertToDTO(applicantService.findApplicantsByNationality(nationality)
        );
    }
    //PUT /api/applicants/{id}/flag
    @PutMapping("/{id}/flag")
    public ApplicantDTO flagApplicant(@PathVariable Long id) {
        return ApplicantDTO.convertToDTO(applicantService.flagCriminalRecord(id));
    }

}
