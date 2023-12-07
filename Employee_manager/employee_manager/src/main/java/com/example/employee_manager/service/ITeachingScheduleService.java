package com.example.employee_manager.service;

import com.example.employee_manager.dto.TeacherDto;
import com.example.employee_manager.dto.TeachingScheduleDto;
import com.example.employee_manager.dto.TimeSheetDto;
import com.example.employee_manager.model.TeachingSchedule;
import com.example.employee_manager.model.TimeSheets;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ITeachingScheduleService {
    void save(TeachingSchedule teachingSchedule);
    void update(TeachingSchedule teachingSchedule);
    List<TeachingSchedule> getAll();
    void delete(int id);
    TeachingSchedule getById(int id);
    List<TeachingScheduleDto> getAllDto() ;
    List<TimeSheetDto> getTimeSheetsFree(int classId, LocalDate startDate, LocalDate endDate) ;
    boolean isScheduleOverlapping(int classId,
                                  int teacherId,
                                  LocalDate newStartDate,
                                  LocalDate newEndDate);
    List<TeacherDto> getTeacherFree(LocalDate startDate,LocalDate endDate,int timeSheetId) ;
    List<TimeSheetDto> getTimeSheetsFreeForUpdate(int classId,
                                                  LocalDate startDate,
                                                  LocalDate endDate,
                                                  int teachingScheduleId);
    List<TeacherDto> getTeacherFreeForUpdate(int teachingScheduleId,
                                             LocalDate startDate,
                                             LocalDate endDate,
                                             int timeSheetId);
}
