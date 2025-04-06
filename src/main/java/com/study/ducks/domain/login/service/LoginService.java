package com.study.ducks.domain.login.service;

import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import com.study.ducks.domain.login.dto.SigninRequest;
import com.study.ducks.domain.login.dto.SigninResponse;


public interface LoginService {
    public LoginResponse loginProcess(LoginRequest loginRequest);
    public void logoutProcess(LoginRequest loginRequest);
    public LoginResponse signInProcess(SigninRequest signinRequest);
    public LoginResponse singOutProcess(Long id);

}
