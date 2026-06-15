package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
}
