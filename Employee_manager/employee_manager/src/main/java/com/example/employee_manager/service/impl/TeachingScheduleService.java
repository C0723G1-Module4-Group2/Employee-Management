package com.example.employee_manager.service.impl;

import com.example.employee_manager.dto.TeacherDto;
import com.example.employee_manager.dto.TeachingScheduleDto;
import com.example.employee_manager.dto.TimeSheetDto;
import com.example.employee_manager.model.TeachingSchedule;
import com.example.employee_manager.model.TimeSheets;
import com.example.employee_manager.repository.ITeachingScheduleRepository;
import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<TeachingScheduleDto> getAllDto() {
        return teachingScheduleRepository.getAll();
    }

    @Override
    public List<TimeSheetDto> getTimeSheetsFree(int classId, LocalDate startDate, LocalDate endDate) {
        return teachingScheduleRepository.getTimeSheetsFree(classId,startDate,endDate);
    }

    @Override
    public boolean isScheduleOverlapping(int classId, int teacherId, LocalDate newStartDate, LocalDate newEndDate) {
        return teachingScheduleRepository.isScheduleOverlapping(classId,teacherId,newStartDate,newEndDate);
    }

    @Override
    public List<TeacherDto> getTeacherFree(LocalDate startDate,LocalDate endDate, int timeSheetId) {
        return teachingScheduleRepository.getTeacherFree(startDate,endDate,timeSheetId);
    }

    @Override
    public List<TimeSheetDto> getTimeSheetsFreeForUpdate(int classId, LocalDate startDate, LocalDate endDate, int teachingScheduleId) {
        return teachingScheduleRepository.getTimeSheetsFreeForUpdate(classId,startDate,endDate,teachingScheduleId);
    }

    @Override
    public List<TeacherDto> getTeacherFreeForUpdate(int teachingScheduleId, LocalDate startDate,LocalDate endDate, int timeSheetId) {
        return teachingScheduleRepository.getTeacherFreeForUpdate(startDate,endDate,timeSheetId,teachingScheduleId);
    }
}
