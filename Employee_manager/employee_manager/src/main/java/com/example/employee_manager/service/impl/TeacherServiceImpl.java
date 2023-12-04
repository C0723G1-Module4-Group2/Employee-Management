package com.example.employee_manager.service.impl;

import com.example.employee_manager.model.Teacher;
import com.example.employee_manager.repository.ITeacherRepository;
import com.example.employee_manager.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    ITeacherRepository iTeacherRepository;
    @Override
    public void addNewTeacher(Teacher teacher) {
    iTeacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
    iTeacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return iTeacherRepository.findAll();
    }

    @Override
    public void editTeacher(Teacher teacher) {
    iTeacherRepository.save(teacher);
    }
    public Teacher findById(int id){
        return iTeacherRepository.findById(id).get();
    }
}
