package com.shahd.immigration_system.Repository;

import com.shahd.immigration_system.Entity.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
    List<ImmigrationOfficer> findByOfficerRank(String officerRank);
}
