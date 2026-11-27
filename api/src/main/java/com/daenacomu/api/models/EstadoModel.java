package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "estados")
@Getter
@Setter
@NoArgsConstructor
public class EstadoModel extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private PaisModel pais;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sigla", nullable = false)
    private String sigla;

    @OneToMany(mappedBy = "estado")
    private Set<CidadeModel> cidades;

}
