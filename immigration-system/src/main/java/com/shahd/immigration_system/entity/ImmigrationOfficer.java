package com.shahd.immigration_system.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ImmigrationOfficer  extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeNumber;

    private String rank;

    private int clearanceLevel;

    private boolean active;
}
