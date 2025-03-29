package com.study.ducks.exception.custom;

import com.study.ducks.exception.ApiException;
import org.springframework.http.HttpStatus;

public class LoginUserException extends ApiException {

    private int httpStatus = HttpStatus.BAD_REQUEST.value();

    public LoginUserException(String message) {
        super(message);
    }

    public LoginUserException(String message,int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    @Override
    public int getStatusCode() {
        return httpStatus;
    }
}
