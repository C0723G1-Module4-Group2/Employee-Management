package com.example.employee_manager.controller;

import com.example.employee_manager.model.Classes;
import com.example.employee_manager.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api-classes")
public class RestClassesController {
@Autowired
private IClassesService classesService;
@GetMapping("")
    public ResponseEntity<Page<Classes>> getList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchingName) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("class_name").ascending());
        Page<Classes> classesPage = classesService.findAllPage(searchingName, pageable);
        if (classesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classesPage, HttpStatus.OK);
    }
}
