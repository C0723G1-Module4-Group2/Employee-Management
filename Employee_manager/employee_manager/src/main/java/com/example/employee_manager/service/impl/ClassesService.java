package com.example.employee_manager.service.impl;

import com.example.employee_manager.model.Classes;
import com.example.employee_manager.repository.IClassesRepository;
import com.example.employee_manager.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public void addClass(Classes newClass) {
        classesRepository.save(newClass);
    }

    @Override
    public Classes findById(int id) {
        return classesRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        classesRepository.deleteById(id);
    }

    @Override
    public Page<Classes> findAllPage(String name, Pageable pageable) {
        return classesRepository.search(name, pageable);
    }
}
