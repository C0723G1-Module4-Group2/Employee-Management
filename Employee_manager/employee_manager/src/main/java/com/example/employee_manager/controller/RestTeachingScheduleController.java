package com.example.employee_manager.controller;

import com.example.employee_manager.model.TeachingSchedule;
import com.example.employee_manager.model.TimeSheets;
import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api-schedules")
public class RestTeachingScheduleController {
    @Autowired
    private ITeachingScheduleService teachingScheduleService;
    @GetMapping("")
    public ResponseEntity<List<TeachingSchedule>> getList() {
        List<TeachingSchedule> events = teachingScheduleService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(events, HttpStatus.OK);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
