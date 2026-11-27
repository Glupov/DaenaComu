package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "instituicoes")
@Getter
@Setter
@NoArgsConstructor
public class InstituicaoModel extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "instituicao")
    private Set<UnidadeModel> unidades;

}
