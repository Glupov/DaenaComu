package com.daenacomu.api.dto.requests;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {}