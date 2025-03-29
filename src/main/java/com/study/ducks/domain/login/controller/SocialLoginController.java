package com.study.ducks.domain.login.controller;

import com.study.ducks.domain.login.dto.KakaoUserInfoResponse;
import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import com.study.ducks.domain.login.service.LoginService;
import com.study.ducks.domain.login.service.SocialLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SocialLoginController {
    @Value("${spring.kakao.auth.client}")
    private String clientId;
    @Value("${spring.kakao.auth.redirect}")
    private String redirectUrl;

    private final SocialLoginService socialLoginService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl;
        model.addAttribute("location", location);

        return "login";
    }

    @GetMapping("/oauth/login")
    public ResponseEntity<?> callback(@RequestParam("code") String code) {
        KakaoUserInfoResponse kakaoUserInfoResponse = socialLoginService.getUserInfo(code);
        return ResponseEntity.ok().build();
    }

}
