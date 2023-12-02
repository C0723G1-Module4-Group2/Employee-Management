package com.example.employee_manager.service;

import com.example.employee_manager.model.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassesService {
    List<Classes> findAll();
    void addClass(Classes blog);

    Classes findById(int id);

    void remove(int id);

    Page<Classes> findAllPage(String name, Pageable pageable);
}
