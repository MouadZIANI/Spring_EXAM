package org.isi.grh.entity;

import lombok.Data;
import org.isi.grh.utils.enums.DepartmentType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private DepartmentType type;
}
