package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "areas")
@Getter
@Setter
@NoArgsConstructor
public class AreaModel extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,updatable = false)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "areas")
    private Set<CursoModel> cursos;

    @ManyToMany(mappedBy = "areas")
    private Set<CarreiraModel> carreiras;
}
