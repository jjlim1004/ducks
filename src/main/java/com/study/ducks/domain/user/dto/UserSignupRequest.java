package com.study.ducks.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Schema(title = "회원가입 요청")
public record UserSignupRequest(
        @Schema(description = "아이디", example = "qwerty")
        @NotBlank(message = "아이디를 입력해주세요")
        String loginId,
        @Schema(description = "비밀번호", example = "1234")
        @NotBlank(message = "비밀번호를 입력해주세요")
        String password
)
{
        @Builder
        public UserSignupRequest(String loginId, String password) {
                this.loginId = loginId;
                this.password = password;
        }
}
