package com.study.ducks.domain.login;

import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import com.study.ducks.domain.login.repository.LoginRepository;
import com.study.ducks.domain.login.service.LoginServiceImpl;
import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.repository.UserRepository;
import com.study.ducks.domain.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {

    @InjectMocks
    private LoginServiceImpl loginService;
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private LoginRepository loginRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    void doLogin() {
        UserSignupRequest userSignupRequest = UserSignupRequest.builder()
                .loginId("test")
                .password("1234")
                .build();
        userService.signup(userSignupRequest);

        //given
        LoginRequest loginRequest = new LoginRequest("test","1234");
        LoginResponse fakeLoginResponse = new LoginResponse("test");
        String fakeEncodedPassword = passwordEncoder.encode("1234");

        //when
        when(passwordEncoder.matches("1234", fakeEncodedPassword)).thenReturn(true);
        LoginResponse loginResponse = loginService.loginProcess(loginRequest);

        //then
        assertNotNull(loginResponse);
        assertEquals(fakeLoginResponse, loginResponse);
    }

}