package com.study.ducks.domain.user.service;

import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.dto.UserSignupResponse;

public interface UserService {
    UserSignupResponse signup(UserSignupRequest userSignupRequest);
}
