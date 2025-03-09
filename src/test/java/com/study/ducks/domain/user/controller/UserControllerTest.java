package com.study.ducks.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {
        userRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("회원가입 성공 확인")
    void signup() throws Exception {
        //given
        UserSignupRequest userSignupRequest = UserSignupRequest.builder()
                .loginId("testId")
                .password("1234")
                .build();

        String json = objectMapper.writeValueAsString(userSignupRequest);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("비밀번호 미기입으로 인한 회원가입 실패")
    void signupFailedByNullPassword() throws Exception {
        //given
        UserSignupRequest userSignupRequest = UserSignupRequest.builder()
                .loginId("testId")
                .build();

        String json = objectMapper.writeValueAsString(userSignupRequest);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}