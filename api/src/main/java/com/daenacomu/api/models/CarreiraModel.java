package com.daenacomu.api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "carreiras")
@Getter
@Setter
@NoArgsConstructor
public class CarreiraModel {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "principais_habilidades")
    private String habilidades;

    @Column(name = "faixa_salarial_min")
    private String salarioMin;

    @Column(name = "faixa_salarial_max")
    private String salarioMax;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "areas_carreiras",
            joinColumns = @JoinColumn(name = "carreira_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private Set<AreaModel> areas;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "cursos_carreiras",
            joinColumns = @JoinColumn(name = "carreira_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<CursoModel> cursos;
}
