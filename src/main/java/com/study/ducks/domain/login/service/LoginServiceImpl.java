package com.study.ducks.domain.login.service;

import com.study.ducks.domain.login.dto.*;
import com.study.ducks.domain.user.entity.Users;
import com.study.ducks.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public LoginResponse loginProcess(LoginRequest loginRequest) {

        Optional<Users> users = userRepository.findByLoginId(loginRequest.loginId());

        String encodedPassword = passwordEncoder.encode(loginRequest.password());

        if(users.isPresent()){
            Users user = users.get();
            if(user.getPassword().equals(encodedPassword) ){
                return new LoginResponse(
                        user.getLoginId()
                        ,user.getNickname()
                        ,user.getCountryCode()
                        ,user.getEmail()
                        ,user.getPhone()
                        ,user.getRole()
                        ,"login success"
                        , HttpStatus.OK.value()
                );
            }else{
                return new LoginResponse(
                        "password incorrect"
                        , HttpStatus.OK.value()
                );
            }
        }

        return new LoginResponse(
                "User not found"
                , HttpStatus.OK.value()
        );
    }

    @Override
    public void logoutProcess(LoginRequest loginRequest) {
    }

    @Override
    public LoginResponse signInProcess(SigninRequest signinRequest) {
        Users users = modelMapper.map(signinRequest, Users.class);
        LoginResponse loginResponse = modelMapper.map(userRepository.save(users), LoginResponse.class);

        return loginResponse;
    }

    @Override
    public LoginResponse singOutProcess(Long id) {
        return null;
    }



}
