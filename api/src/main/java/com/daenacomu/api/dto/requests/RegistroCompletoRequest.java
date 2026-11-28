package com.daenacomu.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record RegistroCompletoRequest(
        String nomeSocial,
        String pronomes,
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate nascimento,
        String foto,
        String bio,
        String capaUrl
        ){}