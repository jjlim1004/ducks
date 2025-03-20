package com.study.ducks.domain.login.repository;

import com.study.ducks.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository  extends JpaRepository<Users, Long> {
    Optional<Users> findByLoginId(String loginId);
}
