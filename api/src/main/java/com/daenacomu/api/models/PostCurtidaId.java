package com.daenacomu.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostCurtidaId implements Serializable {

    @Column(name = "post_id")
    private UUID postId;

    @Column(name = "usuario_id")
    private UUID usuarioId;

}
