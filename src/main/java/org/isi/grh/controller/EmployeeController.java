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
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("managers", employeeService.findAllManagers());
        
        return "admin/employees/index";
    }

    @GetMapping(path = "/employee_form")
    public String employeeForm(Employee employee) {
        return "employee_form";
    }

    @PostMapping(path = "/addEmployee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employee_form";
        }
        //departmentService.save(department);
        return "redirect:employees";

    }
    @PostMapping(path = "/updateEmployee")
    public String updateEmployee(long id,@Valid Employee employee, BindingResult result, Model model){
        if (result.hasErrors()) {
            employee.setId(id);
            return "update_employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:departments";
    }
    @GetMapping(path = "/deleteEmployee")
    public String deleteEmployee(Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:departments";
    }
}
