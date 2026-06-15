package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository  extends JpaRepository<ImmigrationCenter, Long> {
}
