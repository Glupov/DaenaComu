package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "post_curtidas")
@Getter
@Setter
@NoArgsConstructor
public class PostCurtidaModel {

    @EmbeddedId
    private PostCurtidaId id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id", nullable = false)
    private PostagemModel postagem;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private OffsetDateTime criadoEm;

}
