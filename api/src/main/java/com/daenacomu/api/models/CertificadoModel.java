package com.daenacomu.api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "certificados")
@Getter
@Setter
@NoArgsConstructor
public class CertificadoModel extends BaseModel{

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "organizacao", nullable = false)
    private String organizacao;

    @Column(name = "data_expiracao", nullable = false)
    private LocalDate dataValidade;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "codigo_credencial", nullable = false)
    private String codigoCredencial;

    @Column(name = "url_credencial", nullable = false)
    private String url;


}
