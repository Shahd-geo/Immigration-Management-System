package com.shahd.immigration_system.repository;

import com.shahd.immigration_system.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository   extends JpaRepository<Interview, Long> {
}
