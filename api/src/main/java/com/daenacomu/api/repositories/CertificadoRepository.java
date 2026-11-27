package com.daenacomu.api.repositories;

import com.daenacomu.api.models.CertificadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CertificadoRepository extends JpaRepository<CertificadoModel, UUID> {
}
