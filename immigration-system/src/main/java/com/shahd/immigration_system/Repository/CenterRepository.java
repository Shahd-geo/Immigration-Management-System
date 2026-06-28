package com.shahd.immigration_system.Repository;

import com.shahd.immigration_system.Entity.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository  extends JpaRepository<ImmigrationCenter, Long> {
}
