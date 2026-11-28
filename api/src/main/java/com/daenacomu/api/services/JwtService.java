package com.daenacomu.api.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.daenacomu.api.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private static final String ISSUER = "daenacomu-api";
    private final Algorithm algorithm;
    private final long accessTokenExpiration;

    public JwtService(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.access-token.expiration}") long accessTokenExpiration) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.accessTokenExpiration = accessTokenExpiration;
    }
    public String gerarAccessToken(UsuarioModel usuario) {
        Instant agora = Instant.now();
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId().toString())
                .withIssuedAt(agora)
                .withExpiresAt(agora.plusMillis(accessTokenExpiration))
                .sign(algorithm);
    }


    public String validarEExtrairEmail(String token) {
        try {
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
