package com.example.employee_manager.controller;

import com.example.employee_manager.dto.TeacherDto;
import com.example.employee_manager.dto.TeachingScheduleDto;
import com.example.employee_manager.dto.TeachingScheduleMapDto;
import com.example.employee_manager.dto.TimeSheetDto;
import com.example.employee_manager.model.Classes;
import com.example.employee_manager.model.Teacher;
import com.example.employee_manager.model.TeachingSchedule;

import com.example.employee_manager.model.TimeSheets;
import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api-schedules")
public class RestTeachingScheduleController {
    @Autowired
    private ITeachingScheduleService teachingScheduleService;

    @GetMapping("")
    public ResponseEntity<List<TeachingScheduleDto>> getList() {
        List<TeachingScheduleDto> events = teachingScheduleService.getAllDto();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/change-date")
    public ResponseEntity<List<TimeSheetDto>> getListDate(@RequestParam int classId,
                                                          @RequestParam LocalDate startDate,
                                                          @RequestParam LocalDate endDate) {
        List<TimeSheetDto> timeSheets = teachingScheduleService.getTimeSheetsFree(classId, startDate, endDate);
        if (timeSheets.isEmpty()) {
            return new ResponseEntity<>(timeSheets, HttpStatus.OK);
        }
        return new ResponseEntity<>(timeSheets, HttpStatus.OK);
    }

    @GetMapping("/change-sheets")
    public ResponseEntity<List<TeacherDto>> getListTeacher(@RequestParam LocalDate startDate,
                                                           @RequestParam LocalDate endDate,
                                                           @RequestParam int timeSheetId) {
        List<TeacherDto> teacherDtos = teachingScheduleService.getTeacherFree(startDate,endDate, timeSheetId);
        if (teacherDtos.isEmpty()) {
            return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSchedule(@RequestBody TeachingScheduleMapDto teachingScheduleMapDto) {
        TeachingSchedule teachingSchedule = new TeachingSchedule();
        teachingSchedule.setClasses(new Classes(teachingScheduleMapDto.getClassId()));
        ;
        teachingSchedule.setTimeSheets(new TimeSheets(teachingScheduleMapDto.getTimeSheetId()));
        teachingSchedule.setTeacher(new Teacher(teachingScheduleMapDto.getTeacherId()));
        teachingSchedule.setStartDate(teachingScheduleMapDto.getStartDate());
        teachingSchedule.setEndDate(teachingScheduleMapDto.getEndDate());
        teachingSchedule.setStatus(true);
        teachingScheduleService.save(teachingSchedule);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteSchedule(@RequestParam int teachingScheduleId) {
        TeachingSchedule teachingSchedule = teachingScheduleService.getById(teachingScheduleId);
        if (teachingSchedule == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        teachingScheduleService.delete(teachingScheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("")
    public ResponseEntity<?> updateSchedule(@RequestBody TeachingScheduleMapDto teachingScheduleMapDto,
                                            @RequestParam int teachingScheduleId) {
        TeachingSchedule teachingSchedule = teachingScheduleService.getById(teachingScheduleId);
        teachingSchedule.setTimeSheets(new TimeSheets(teachingScheduleMapDto.getTimeSheetId()));
        teachingSchedule.setClasses(new Classes(teachingScheduleMapDto.getClassId()));
        teachingSchedule.setTeacher(new Teacher(teachingScheduleMapDto.getTeacherId()));
        teachingSchedule.setStartDate(teachingScheduleMapDto.getStartDate());
        teachingSchedule.setEndDate(teachingScheduleMapDto.getEndDate());
        teachingScheduleService.update(teachingSchedule);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/change-update-date")
    public ResponseEntity<List<TimeSheetDto>> getListDateForUpdate(@RequestParam int classId,
                                                                   @RequestParam int teachingScheduleId,
                                                                   @RequestParam LocalDate startDate,
                                                                   @RequestParam LocalDate endDate) {
        List<TimeSheetDto> timeSheets = teachingScheduleService.getTimeSheetsFreeForUpdate(classId, startDate, endDate, teachingScheduleId);
        if (timeSheets.isEmpty()) {
            return new ResponseEntity<>(timeSheets, HttpStatus.OK);
        }
        return new ResponseEntity<>(timeSheets, HttpStatus.OK);
    }

    @GetMapping("/change-update-sheets")
    public ResponseEntity<List<TeacherDto>> getListTeacherForUpdate(@RequestParam int teachingScheduleId,
                                                                    @RequestParam LocalDate startDate,
                                                                    @RequestParam LocalDate endDate,
                                                                    @RequestParam int timeSheetId
    ) {
        List<TeacherDto> teacherDtos = teachingScheduleService.getTeacherFreeForUpdate(teachingScheduleId, startDate, endDate, timeSheetId);
        if (teacherDtos.isEmpty()) {
            return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<TeachingSchedule> getInfoForUpdate(@RequestParam int teachingScheduleId) {
        TeachingSchedule teachingSchedule = teachingScheduleService.getById(teachingScheduleId);
        if (teachingSchedule == null) {
            return new ResponseEntity<>(teachingSchedule, HttpStatus.OK);
        }
        return new ResponseEntity<>(teachingSchedule, HttpStatus.OK);
    }
}
