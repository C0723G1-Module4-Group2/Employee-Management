package com.example.employee_manager.controller;

import com.example.employee_manager.model.Classes;
import com.example.employee_manager.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @GetMapping
    public String showList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchingName, Model model) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("class_name").ascending());
        Page<Classes> classesList = classesService.findAllPage(searchingName, pageable);
        model.addAttribute("classesList", classesList);
        model.addAttribute("searchingName", searchingName);
        return "/classes/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        classesService.remove(id);
        attributes.addFlashAttribute("success", "Deleted successfully!");
        return "redirect:/classes";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("classes", new Classes());
        return "/classes/create";
    }

    @PostMapping("/save")
    public String save(Classes newClass, RedirectAttributes attributes) {
        classesService.addClass(newClass);
        attributes.addFlashAttribute("success", "Added successfully!");
        return "redirect:/classes";
    }
}
