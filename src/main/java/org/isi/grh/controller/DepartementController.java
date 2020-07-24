package org.isi.grh.controller;

import org.isi.grh.entity.Department;
import org.isi.grh.service.departement.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartementController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/departments")
    public String list(Model model)
    {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        return "admin/departments/index";
    }

    @GetMapping(path = "/departments/create")
    public String create(Department department)
    {
        return "admin/departments/create";
    }

    @PostMapping(path = "/departments/save")
    public String store(@Valid Department department, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "admin/departments/create";
        }
        departmentService.save(department);
        return "redirect:departments";
    }
}
