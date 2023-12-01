package com.example.employee_manager.controller;

import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class TeachingScheduleController {
    @Autowired
    private ITeachingScheduleService teachingScheduleService;
    @GetMapping("")
    public String showCalendar(){
        return "/teaching_schedule/list";
    }
}
