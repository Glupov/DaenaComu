package com.daenacomu.api.services;

import com.daenacomu.api.dto.requests.RegistroCompletoRequest;
import com.daenacomu.api.dto.requests.RegistroRequest;
import com.daenacomu.api.dto.requests.LoginRequest;
import com.daenacomu.api.dto.responses.UsuarioResponse;
import com.daenacomu.api.mappers.UsuarioMapper;
import com.daenacomu.api.models.UsuarioModel;
import com.daenacomu.api.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioResponse cadastrar(RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Este e-mail já está em uso.");
        }
        String senhaHash = passwordEncoder.encode(request.senha());

        UsuarioModel novoUsuario = usuarioMapper.cadastroRequestToEntity(request, senhaHash);

        UsuarioModel salvo = usuarioRepository.save(novoUsuario);

        return usuarioMapper.toUsuarioResponse(salvo);
    }
    @Transactional
    public UsuarioResponse login(LoginRequest request) {
        UsuarioModel usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("E-mail ou senha inválidos."));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            throw new IllegalArgumentException("E-mail ou senha inválidos.");
        }

        return usuarioMapper.toUsuarioResponse(usuario);
    }
    @Transactional
    public UsuarioResponse completarRegistro(RegistroCompletoRequest request, String email) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário Inválido"));
        usuario.setNome_social(request.nomeSocial());
        usuario.setPronomes(request.pronomes());
        usuario.setNascimento(request.nascimento());
        usuario.setFoto(request.foto());
        usuario.setBio(request.bio());
        usuario.setCapaUrl(request.capaUrl());

        UsuarioModel salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioResponse(salvo);
    }
}
