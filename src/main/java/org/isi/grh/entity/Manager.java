package org.isi.grh.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
@DiscriminatorValue("Manager")
public class Manager extends EmployeeAbstract {
    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;
}
