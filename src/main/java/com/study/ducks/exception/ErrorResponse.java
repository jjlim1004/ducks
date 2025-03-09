package com.study.ducks.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponse(Integer code, String message, Map<String, String> validation) {
    @Builder
    public ErrorResponse(Integer code, String message, Map<String, String> validation) {
        this.code = code;
        this.message = message == null ? "" : message;
        this.validation = validation == null ? new HashMap<>() : validation;
    }
}
