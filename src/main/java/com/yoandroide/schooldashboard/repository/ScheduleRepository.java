package com.yoandroide.schooldashboard.repository;

import com.yoandroide.schooldashboard.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
}
