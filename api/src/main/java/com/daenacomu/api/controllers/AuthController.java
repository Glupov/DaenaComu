package com.daenacomu.api.controllers;

import com.daenacomu.api.dto.requests.LoginRequest;
import com.daenacomu.api.dto.requests.RegistroCompletoRequest;
import com.daenacomu.api.dto.requests.RegistroRequest;
import com.daenacomu.api.dto.responses.BaseResponse;
import com.daenacomu.api.dto.responses.UsuarioResponse;
import com.daenacomu.api.mappers.UsuarioMapper;
import com.daenacomu.api.models.UsuarioModel;
import com.daenacomu.api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuarioMapper usuarioMapper;



    public AuthController(AuthService authService, UsuarioMapper usuarioMapper) {
        this.authService = authService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UsuarioResponse>> cadastrar(@Valid @RequestBody RegistroRequest request) {
        UsuarioResponse usuario = authService.cadastrar(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new BaseResponse<>(true, "Usuário cadastrado com sucesso", usuario, null));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<UsuarioResponse>> login(@Valid @RequestBody LoginRequest request) {
        UsuarioResponse usuario = authService.login(request);
        return ResponseEntity
                .ok(new BaseResponse<>(true, "Login realizado com sucesso", usuario, null));
    }

    @PatchMapping("/complete-registration/{email}")
    public ResponseEntity<BaseResponse<UsuarioResponse>> completarRegistro(
            @PathVariable String email,
            @Valid @RequestBody RegistroCompletoRequest request) {

        UsuarioResponse response = authService.completarRegistro(request, email);

        return ResponseEntity.ok(
                new BaseResponse<>(true, "Registro completado com sucesso", response, null)
        );
    }


}
