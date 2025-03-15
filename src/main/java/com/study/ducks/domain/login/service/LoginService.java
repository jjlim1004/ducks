package com.study.ducks.domain.login.service;

import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public LoginResponse loginProcess(LoginRequest loginRequest);
    public void logoutProcess(LoginRequest loginRequest);
}
