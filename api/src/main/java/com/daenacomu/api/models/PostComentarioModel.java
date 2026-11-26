package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(
        name = "post_comentarios"
)
@Getter
@Setter
@NoArgsConstructor
public class PostComentarioModel extends BaseModel {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostagemModel postagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

}
