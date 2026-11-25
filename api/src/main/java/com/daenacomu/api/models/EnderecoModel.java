package com.daenacomu.api.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
public class EnderecoModel extends BaseModel {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "rua", nullable = false)
    private String rua;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "codigo_cep", nullable = false)
    private String cep;
    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private CidadeModel cidade;

    @OneToOne(mappedBy = "endereco")
    private UnidadeModel unidade;


}
