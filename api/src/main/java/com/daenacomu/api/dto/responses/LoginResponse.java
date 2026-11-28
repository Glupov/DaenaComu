package com.daenacomu.api.dto.responses;

public record LoginResponse(
        String accessToken,
        UsuarioResponse usuario
) {}
