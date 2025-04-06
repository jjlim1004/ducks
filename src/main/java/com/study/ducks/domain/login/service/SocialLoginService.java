package com.study.ducks.domain.login.service;

import com.study.ducks.domain.login.dto.KakaoUserInfoResponse;

public interface SocialLoginService {
    public String getAccessTokenFromKakao(String code);
    public KakaoUserInfoResponse getUserInfo(String code);
}
