package org.isi.grh.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("Employee")
public class Employee extends EmployeeAbstract {

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
