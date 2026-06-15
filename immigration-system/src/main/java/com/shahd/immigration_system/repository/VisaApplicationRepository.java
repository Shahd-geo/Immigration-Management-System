package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
}
