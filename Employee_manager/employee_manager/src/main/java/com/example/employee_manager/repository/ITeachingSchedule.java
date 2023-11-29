package com.example.employee_manager.repository;

import com.example.employee_manager.model.TeachingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeachingSchedule extends JpaRepository<TeachingSchedule,Integer> {
}
