package com.daenacomu.api.dto.responses;


public record BaseResponse<T>(boolean success, String message, T result, ErrorResponse error) {}
