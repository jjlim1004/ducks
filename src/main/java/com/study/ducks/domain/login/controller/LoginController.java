package com.study.ducks.domain.login.controller;

import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import com.study.ducks.domain.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "로그인 API", description = "로그인 API 입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "일반 사용자 로그인", description = "일반 사용자 로그인")
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(HttpServletRequest httpServletRequest, @RequestBody @Validated LoginRequest loginRequest){
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession();

        LoginResponse loginResponse = loginService.loginProcess(loginRequest);
        session.setAttribute("loginResponse", loginResponse);
        session.setMaxInactiveInterval(1800);

        return ResponseEntity.ok()
                .body(loginResponse);
    }

    @Operation(summary = "일반 사용자 로그아웃", description = "일반 사용자 로그아웃")
    @PostMapping("/auth/logout")
    public ResponseEntity<LoginResponse> logout(HttpServletRequest httpServletRequest, @RequestBody @Validated LoginRequest loginRequest){
        HttpSession session = httpServletRequest.getSession(false);
        session.invalidate();

        return ResponseEntity.ok()
                .body(loginService.loginProcess(loginRequest));
    }
}
