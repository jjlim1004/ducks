package com.study.ducks.domain.user.controller;

import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.dto.UserSignupResponse;
import com.study.ducks.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "회원가입 API", description = "회원가입 API 입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @Operation(summary = "일반 회원가입", description = "일반 회원가입 API 입니다.")
    @PostMapping("/auth/signup")
    public ResponseEntity<UserSignupResponse> signup(@RequestBody @Validated UserSignupRequest userSignupRequest){
        return ResponseEntity.ok()
                .body(userService.signup(userSignupRequest));
    }

}
