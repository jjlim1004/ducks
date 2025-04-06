package com.study.ducks.domain.login.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(title="로그인 요청")
public record LoginRequest(
        @Schema(description = "아이디", example = "qwerty")
        @NotBlank
        String loginId,
        @Schema(description = "비밀번호", example = "1234")
        @NotBlank
        String password
) {

}
