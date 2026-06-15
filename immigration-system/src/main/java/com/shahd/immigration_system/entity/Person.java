package com.shahd.immigration_system.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public  abstract class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
}
