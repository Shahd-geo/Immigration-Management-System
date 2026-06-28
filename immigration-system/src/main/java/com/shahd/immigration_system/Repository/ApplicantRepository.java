package com.shahd.immigration_system.Repository;

import com.shahd.immigration_system.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByNationality(String nationality);
}
