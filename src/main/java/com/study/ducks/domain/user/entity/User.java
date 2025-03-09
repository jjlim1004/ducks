package com.study.ducks.domain.user.entity;

import com.study.ducks.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String loginId;
    private String password;
    //private String name;
    private String nickname;
    private String address;
    private String countryCode;
    private String phone;
    private String role;
    private String email;
    private Boolean isAuth;
    private Boolean isActive;

    @Builder
    public User(String loginId, String password, String nickname, String address, String countryCode, String phone, String role, String email, Boolean isAuth, Boolean isActive) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.address = address;
        this.countryCode = countryCode;
        this.phone = phone;
        this.role = role;
        this.email = email;
        this.isAuth = isAuth;
        this.isActive = isActive;
    }
}
