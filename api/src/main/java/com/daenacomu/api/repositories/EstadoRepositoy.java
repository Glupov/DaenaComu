package com.daenacomu.api.repositories;

import com.daenacomu.api.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositoy extends JpaRepository<EstadoModel, Integer> {
}
