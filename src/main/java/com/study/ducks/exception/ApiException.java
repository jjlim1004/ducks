package com.study.ducks.exception;

import lombok.Getter;

@Getter
public abstract class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
    public abstract int getStatusCode();
}
