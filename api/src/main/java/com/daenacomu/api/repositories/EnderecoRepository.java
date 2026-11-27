package com.daenacomu.api.repositories;

import com.daenacomu.api.models.EnderecoModel;
import lombok.Locked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}
