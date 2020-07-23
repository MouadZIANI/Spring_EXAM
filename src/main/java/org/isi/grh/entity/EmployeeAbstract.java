package org.isi.grh.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
@Table(name = "employees")
public abstract class EmployeeAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "remuneration_id")
    private Remuneration remuneration;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
