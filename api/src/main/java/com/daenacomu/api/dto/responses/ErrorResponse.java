package com.daenacomu.api.dto.responses;

import java.util.List;

public record ErrorResponse(String code, String message, List<String> details) {}
