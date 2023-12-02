package com.example.employee_manager.controller;

import com.example.employee_manager.model.Teacher;
import com.example.employee_manager.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api-teacher")
public class RestTeacherController {
    @Autowired
    private ITeacherService iTeacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> showListTeachers(){
        List<Teacher> teacherList = iTeacherService.getAll();
        return new ResponseEntity<>(teacherList,HttpStatus.OK);
    }
}
