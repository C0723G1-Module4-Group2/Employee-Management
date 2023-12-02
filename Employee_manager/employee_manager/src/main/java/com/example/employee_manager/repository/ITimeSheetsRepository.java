package com.example.employee_manager.repository;

import com.example.employee_manager.model.TimeSheets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITimeSheetsRepository extends JpaRepository<TimeSheets,Integer> {
}
