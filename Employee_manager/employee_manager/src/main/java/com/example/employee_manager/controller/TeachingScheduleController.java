package com.example.employee_manager.controller;

import com.example.employee_manager.model.TeachingSchedule;
import com.example.employee_manager.service.ITeachingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class TeachingScheduleController {
    @Autowired
    private ITeachingScheduleService teachingScheduleService;
    @GetMapping("")
    public String showCalendar(Model model){
        List<TeachingSchedule> teachingSchedules = teachingScheduleService.getAll();
        model.addAttribute("listSchedule",teachingSchedules);
        return "/teaching_schedule/list1";
    }
}
