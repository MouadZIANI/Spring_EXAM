package org.isi.grh.entity;

import lombok.Data;
import org.isi.grh.utils.enums.RemunerationType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "remunerations")
public class Remuneration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private RemunerationType type;
}
