package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(
        name = "posts"
)
@Getter
@Setter
@NoArgsConstructor
public class PostagemModel extends BaseModel {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "conteudo", nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "imagem_url", columnDefinition = "TEXT")
    private String imagemUrl;

    @Column(name = "visualizacoes", nullable = false)
    private Integer visualizacoes = 0;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoModel curso;

    @OneToMany(mappedBy = "postagem")
    private Set<PostComentarioModel> comentarios;

    @OneToMany(mappedBy = "postagem")
    private Set<PostCurtidaModel> curtidas;

}
