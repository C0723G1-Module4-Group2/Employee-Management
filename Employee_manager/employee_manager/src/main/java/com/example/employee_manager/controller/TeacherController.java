package com.example.employee_manager.controller;

import com.example.employee_manager.model.Teacher;
import com.example.employee_manager.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService iTeacherService;
    @GetMapping("")
    public String showManagementTeacher(Model model){
        List<Teacher> teacherList = iTeacherService.getAll();
        model.addAttribute("teachers",teacherList);
        return "/teacher/managementTeacher";
    }

}
