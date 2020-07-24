package org.isi.grh.service.departement;

import org.isi.grh.entity.Department;
import org.isi.grh.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Department> findById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    @Transactional

    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        departmentRepository.deleteById(id);
    }
}
