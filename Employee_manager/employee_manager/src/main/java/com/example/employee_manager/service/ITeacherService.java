package com.example.employee_manager.service;

import com.example.employee_manager.model.Teacher;

import java.util.List;

public interface ITeacherService {
    public void addNewTeacher(Teacher teacher);
    public void deleteTeacher(int id);
    public List<Teacher> getAll();
    public void editTeacher(Teacher teacher);
    public Teacher findById(int id);
}
