package org.isi.grh.controller;


import org.isi.grh.entity.Employee;
import org.isi.grh.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public String list(Model model)
    {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("managers", employeeService.findAllManagers());

        return "admin/employees/index";
    }

    @GetMapping(path = "/employees/create")
    public String employeeForm(Employee employee)
    {
        return "admin/employees/create";
    }

    @PostMapping(path = "/employees/save")
    public String store(@Valid Employee employee, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            return "admin/employees/create";
        }
        this.employeeService.saveEmployee(employee);
        return "redirect:employees";

    }

    @GetMapping(path = "/employees/delete")
    public String deleteEmployee(Long id)
    {
        employeeService.deleteEmployeeById(id);
        return "redirect:employees";
    }
}
