package com.daenacomu.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
public class CursoModel extends BaseModel{

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "imagem_url", nullable = false)
    private String imagem;

    @Column(name = "url_inscricao", nullable = false)
    private String url;

    @Column(name = "requisitos", nullable = false)
    private Double requisitos;

    @Column(name = "modalidade", nullable = false)
    private String modalidade;

    @Column(name = "status_inscricao", nullable = false, columnDefinition = "RASCUNHO")
    private String status;


    @ManyToOne
    @JoinColumn(name = "instituicao_id", nullable = false)
    private InstituicaoModel instituicao;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private UnidadeModel unidade;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cursos_areas",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private Set<AreaModel> areas;

    @ManyToMany(mappedBy = "cursos")
    private Set<CarreiraModel> carreiras;

    @OneToMany(mappedBy = "curso")
    private Set<ConteudoModel> conteudos;

    @OneToMany(mappedBy = "curso")
    private Set<AvaliacaoModel> avaliacoes;





}
