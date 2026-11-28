package com.daenacomu.api.mappers;
import com.daenacomu.api.dto.requests.RegistroRequest;
import com.daenacomu.api.dto.responses.UsuarioResponse;
import com.daenacomu.api.models.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel cadastroRequestToEntity(RegistroRequest novoUsuario, String senha) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(novoUsuario.nome());
        usuario.setEmail(novoUsuario.email());
        usuario.setSenha(senha);
        return usuario;
    }

    public UsuarioResponse toUsuarioResponse(UsuarioModel u) {
        return new UsuarioResponse(
                u.getId(),
                u.getNome(),
                u.getNome_social(),
                u.getPronomes(),
                u.getEmail(),
                u.getFoto(),
                u.getCapaUrl(),
                u.getBio(),
                u.getNascimento()
        );
    }
}
