package com.shahd.immigration_system.entity;

import jakarta.persistence.Entity;

@Entity
public class AsylumSeeker extends  Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
