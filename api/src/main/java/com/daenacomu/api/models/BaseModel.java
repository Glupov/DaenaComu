package com.daenacomu.api.models;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Collate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @CreationTimestamp
    @Column(name = "criado_em",nullable = false,updatable = false)
    protected Instant criadoEm;

    @UpdateTimestamp
    @Column(name = "alterado_em",nullable = false)
    protected Instant alteradoEm;

    @Column(name = "deletado_em")
    protected Instant deletadoEm;

}


