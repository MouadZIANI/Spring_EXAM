package org.isi.grh.service.departement;

import org.isi.grh.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public List<Department> findAll();

    Optional<Department> findById(long id) ;

    void save(Department department);

    void deleteById(long id);
}
