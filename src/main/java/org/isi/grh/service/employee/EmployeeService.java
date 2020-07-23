package org.isi.grh.service.employee;

import org.isi.grh.entity.Department;
import org.isi.grh.entity.Employee;
import org.isi.grh.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Manager> findAllManagers();

    Optional<Manager> findManagerById(long id) ;

    void saveManager(Manager manager);

    void deleteManagerById(long id);

    public List<Employee> findAllEmployees();

    Optional<Employee> findEmployeeById(long id) ;

    void saveEmployee(Employee employee);

    void deleteEmployeeById(long id);
}
