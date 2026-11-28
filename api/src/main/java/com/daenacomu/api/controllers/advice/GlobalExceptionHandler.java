package com.daenacomu.api.controllers.advice;

import com.daenacomu.api.dto.responses.BaseResponse;
import com.daenacomu.api.dto.responses.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Void>> handleValidation(MethodArgumentNotValidException ex) {
        List<String> details = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        ErrorResponse error = new ErrorResponse("VALIDATION_ERROR", "Dados inválidos", details);
        return ResponseEntity.badRequest().body(new BaseResponse<>(false, "Erro de validação", null, error));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse<Void>> handleBusiness(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse("BUSINESS_ERROR", ex.getMessage(), null);
        return ResponseEntity.badRequest().body(new BaseResponse<>(false, ex.getMessage(), null, error));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BaseResponse<Void>> handleConflict(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse("CONFLICT", "Registro duplicado ou violação de integridade", null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new BaseResponse<>(false, "Conflito de dados", null, error));
    }
}
