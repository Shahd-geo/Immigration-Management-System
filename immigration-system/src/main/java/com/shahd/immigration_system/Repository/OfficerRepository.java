package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
    List<ImmigrationOfficer> findByOfficerRank(String officerRank);
}
