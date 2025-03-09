package com.study.ducks.exception.custom;

import com.study.ducks.exception.ApiException;
import org.springframework.http.HttpStatus;

public class IsExistedUser extends ApiException {
    public IsExistedUser() {
        super("이미 존재하는 아이디입니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
