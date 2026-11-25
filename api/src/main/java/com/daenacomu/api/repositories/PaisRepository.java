package com.daenacomu.api.repositories;

import com.daenacomu.api.models.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Integer> {
}
