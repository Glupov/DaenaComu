package com.daenacomu.api.dto.responses;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String nome,
        String nomeSocial,
        String pronomes,
        String email,
        String foto,
        String capaUrl,
        String bio,
        LocalDate nascimento
) {}
