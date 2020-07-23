package org.isi.grh.controller;


import org.isi.grh.entity.Employee;
import org.isi.grh.entity.EmployeeAbstract;
import org.isi.grh.entity.Manager;
import org.isi.grh.service.departement.DepartmentService;
import org.isi.grh.service.employee.EmployeeService;
import org.isi.grh.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/employees")
    public String list(Model model)
    {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("managers", employeeService.findAllManagers());

        return "admin/employees/index";
    }

    @GetMapping(path = "/employees/create")
    public String employeeForm(EmployeeAbstract employee, Model model)
    {
        model.addAttribute("departments", departmentService.findAll());
        return "admin/employees/create";
    }

    @PostMapping(path = "/employees/save")
    public String store(@Valid EmployeeAbstract employee, BindingResult result, Model model, @RequestParam("role") String role)
    {
        if (result.hasErrors()) {
            return "admin/employees/create";
        }

        if(role.equals("Manager")) {
            Manager manager = new Manager();
            manager.setFirstName(employee.getFirstName());
            manager.setLastName(employee.getLastName());
            manager.setEmail(employee.getEmail());
            manager.setBirthDate(employee.getBirthDate());
            manager.setRemuneration(employee.getRemuneration());
            manager.setDepartment(employee.getDepartment());
            this.employeeService.saveManager(manager);
        } else {
            Employee normalEmployee = new Employee();
            normalEmployee.setFirstName(employee.getFirstName());
            normalEmployee.setLastName(employee.getLastName());
            normalEmployee.setEmail(employee.getEmail());
            normalEmployee.setBirthDate(employee.getBirthDate());
            normalEmployee.setRemuneration(employee.getRemuneration());
            normalEmployee.setDepartment(employee.getDepartment());
            this.employeeService.saveEmployee(normalEmployee);
        }

        return "redirect:employees";

    }

    @GetMapping(path = "/employees/delete")
    public String delete(Long id)
    {
        employeeService.deleteEmployeeById(id);
        return "redirect:employees";
    }
}
