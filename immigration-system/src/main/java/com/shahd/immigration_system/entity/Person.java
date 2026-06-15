package com.shahd.immigration_system.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@MappedSuperclass
public  abstract class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
}
