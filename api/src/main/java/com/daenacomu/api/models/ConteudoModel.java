package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "conteudos")
@Getter
@Setter
@NoArgsConstructor
public class ConteudoModel extends BaseModel{

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "duracao_minutos", nullable = false)
    private Integer duracao;

    @Column(name = "data_publicacao", nullable = false)
    private OffsetDateTime dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoModel curso;

}
