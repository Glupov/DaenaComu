package com.daenacomu.api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "paises")
@Getter
@Setter
@NoArgsConstructor
public class PaisModel extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,updatable = false)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "codigo_alpha2", nullable = false)
    private String codigoAlpha2;

    @OneToMany(mappedBy = "pais")
    private Set<EstadoModel> estados;
}
