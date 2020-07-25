package org.isi.grh.service.employee;

import org.isi.grh.entity.Employee;
import org.isi.grh.entity.Manager;
import org.isi.grh.repository.EmployeeRepository;
import org.isi.grh.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Manager> findAllManagers() {
        return this.managerRepository.findAll();
    }

    @Override
    public Optional<Manager> findManagerById(long id) {
        return this.managerRepository.findById(id);
    }

    @Override
    public void saveManager(Manager manager) {
        this.managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(long id) {
        this.managerRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
