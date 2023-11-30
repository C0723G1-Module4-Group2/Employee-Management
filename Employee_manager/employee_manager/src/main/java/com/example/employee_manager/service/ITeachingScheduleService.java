package com.example.employee_manager.service;

import com.example.employee_manager.model.TeachingSchedule;

import java.util.List;

public interface ITeachingScheduleService {
    void save(TeachingSchedule teachingSchedule);
    void update(TeachingSchedule teachingSchedule);
    List<TeachingSchedule> getAll();
    void delete(int id);
    TeachingSchedule getById(int id);

}
