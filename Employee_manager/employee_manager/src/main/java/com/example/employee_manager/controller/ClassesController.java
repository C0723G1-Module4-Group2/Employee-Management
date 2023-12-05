package com.example.employee_manager.controller;

import com.example.employee_manager.model.Classes;
import com.example.employee_manager.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newClass", new Classes());
        return "/classes/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Classes newClass, RedirectAttributes attributes) {
        if (classesService.findByName(newClass.getClassName()) == null) {
            newClass.setStatus(true);
            classesService.addClass(newClass);
            attributes.addFlashAttribute("success", "Thêm mới thành công!");
            return "redirect:/classes";
        } else {
            attributes.addFlashAttribute("unsuccess", "Lớp này đã có rồi, vui lòng kiểm tra lại");
            return "redirect:/classes/create";
        }
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam int id, Model model) {
        model.addAttribute("editingClass", classesService.findById(id));
        return "/classes/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Classes editingClass, RedirectAttributes attributes) {
        if (classesService.findByName(editingClass.getClassName()) == null) {
            editingClass.setStatus(true);
            classesService.addClass(editingClass);
            attributes.addFlashAttribute("success", "Đã sửa thành công!");
            return "redirect:/classes";
        } else {
            int id = editingClass.getClassId();
            attributes.addFlashAttribute("unsuccess", "Tên lớp này đã tồn tại, vui lòng kiểm tra lại!");
            return "redirect:/classes/edit?id=" + id;
        }
    }
    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        classesService.remove(id);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/classes";
    }

}
