package com.shahd.immigration_system.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsylumSeeker extends  Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
