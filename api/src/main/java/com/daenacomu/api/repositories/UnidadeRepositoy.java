package com.daenacomu.api.repositories;

import com.daenacomu.api.models.UnidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepositoy extends JpaRepository<UnidadeModel, Integer> {
}
