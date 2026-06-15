package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
