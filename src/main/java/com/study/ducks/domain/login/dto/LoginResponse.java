package com.study.ducks.domain.login.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

@Schema(title = "로그인 응답")
public record LoginResponse(
        @Schema(description = "회원 ID",example = "qwerty")
        String loginId,
        @Schema(description = "닉네임",example = "qwerty")
        String nickname,
        @Schema(description = "국가코드")
        String countryCode,
        @Schema(description = "이메일",example = "jjlim940224@gamil.com")
        String email,
        @Schema(description = "전화번호",example = "01012345678")
        String phone,
        @Schema(description = "권한",example = "1")
        String role,
        @Schema(description = "응답 메세지",example = "1")
        String responseMessage,
        @Schema(description = "응답 코드",example = "1")
        int httpStatus
        ) {
        public LoginResponse(String responseMessage, int httpStatus){
               this(null,null,null,null,null,null,responseMessage,httpStatus);
        }
        public LoginResponse(String loginId){
                this(loginId,null,null,null,null,null,null,HttpStatus.OK.value());
        }

}
