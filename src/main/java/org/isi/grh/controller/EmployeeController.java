package org.isi.grh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping(path = "/employees")
    public String list(Model model)
    {
        return "admin/employees/index";
    }

    @GetMapping(path = "/employees/create")
    public String create()
    {
        return "admin/employees/create";
    }
}
