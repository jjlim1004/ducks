package com.study.ducks.domain.user.service;

import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.entity.User;
import com.study.ducks.domain.user.repository.UserRepository;
import com.study.ducks.exception.custom.IsExistedUser;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {userRepository.deleteAllInBatch();}

    @Test
    @DisplayName("회원가입 성공")
    void signup() {
        //given
        UserSignupRequest userSignupRequest = UserSignupRequest.builder()
                .loginId("test")
                .password("1234")
                .build();

        //when
        userService.signup(userSignupRequest);

        //then
        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
        assertThat(userRepository.count()).isEqualTo(1);
        assertThat(users.get(0).getLoginId()).isEqualTo("test");
        assertThat(users.get(0).getPassword()).isNotEqualTo("1234");
    }

    @Test
    @DisplayName("아이디 중복으로 인한 회원가입 실패")
    void signupFailedByDuplicateLoginId() {
        //given
        User user = User.builder()
                .loginId("test")
                .password("1234")
                .build();
        userRepository.save(user);

        UserSignupRequest userSignupRequest = UserSignupRequest.builder()
                .loginId("test")
                .password("1234")
                .build();

        //then
        assertThatThrownBy(() -> userService.signup(userSignupRequest))
                .isInstanceOf(IsExistedUser.class)
                .hasMessage("이미 존재하는 아이디입니다.");
    }
}