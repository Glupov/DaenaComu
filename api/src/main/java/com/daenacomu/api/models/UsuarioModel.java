package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioModel extends BaseModel{

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;


    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nome_social")
    private String nome_social;

    @Column(name = "pronomes")
    private String pronomes;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha_hash", nullable = false)
    private String senha;

    @Column(name = "foto_url")
    private String foto;

    @Column(name = "capa_url")
    private String capaUrl;

    @Column(name = "bio")
    private String bio;

    @Column(name = "data_nascimento")
    private LocalDate nascimento;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;




}
