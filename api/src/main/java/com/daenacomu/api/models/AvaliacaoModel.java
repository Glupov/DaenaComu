package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoModel extends BaseModel {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pontos", nullable = false)
    private Short pontos;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoModel curso;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

}
