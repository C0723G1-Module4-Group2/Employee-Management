package com.example.employee_manager.service.impl;

import com.example.employee_manager.model.TeachingSchedule;
import com.example.employee_manager.repository.ITeachingScheduleRepository;
import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingScheduleService implements ITeachingScheduleService {
    @Autowired
    private ITeachingScheduleRepository teachingScheduleRepository;

    @Override
    public void save(TeachingSchedule teachingSchedule) {
        teachingScheduleRepository.save(teachingSchedule);
    }

    @Override
    public void update(TeachingSchedule teachingSchedule) {
        teachingScheduleRepository.save(teachingSchedule);
    }

    @Override
    public List<TeachingSchedule> getAll() {
        return teachingScheduleRepository.findAll();
    }

    @Override
    public void delete(int id) {
        teachingScheduleRepository.delete(getById(id));
    }

    @Override
    public TeachingSchedule getById(int id) {
        return teachingScheduleRepository.findById(id).get();
    }
}
