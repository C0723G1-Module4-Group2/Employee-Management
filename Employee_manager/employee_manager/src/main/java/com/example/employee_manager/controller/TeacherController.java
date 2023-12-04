package com.example.employee_manager.controller;

import com.example.employee_manager.model.Teacher;
import com.example.employee_manager.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "/index";
    }
    @GetMapping("/add")
    public String showFormTeacher(){
        return "/teacher/managementTeacher";
    }
    @PostMapping("/add")
    public String addNewTeacher(Teacher teacher){
        iTeacherService.addNewTeacher(teacher);
        return "redirect:/teacher";
    }
    @GetMapping("/edit{id}")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("teacher",iTeacherService.findById(id));
        return "/teacher/managementTeacher";
    }
    @PostMapping("/edit")
    public String edit(int id,Teacher teacher){
        Teacher teacher1 = iTeacherService.findById(id);
        teacher1 = teacher;
        iTeacherService.addNewTeacher(teacher1);
        return "redirect:/teacher";
    }
    @GetMapping("/detail{id}")
    public String findById(@PathVariable() int id,Model model){
        Teacher teacher = iTeacherService.findById(id);
        model.addAttribute("teacherDetail",teacher);
        return "redirect:/teacher";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam() int id){
        iTeacherService.deleteTeacher(id);
        return "redirect:/blog";
    }





}
