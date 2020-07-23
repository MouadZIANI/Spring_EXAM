package org.isi.grh.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
@Table(name = "employees")
public abstract class EmployeeAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "remuneration_id")
    private Remuneration remuneration;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
