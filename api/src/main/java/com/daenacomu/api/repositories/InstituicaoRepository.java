package com.daenacomu.api.repositories;

import com.daenacomu.api.models.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, Integer> {
}
