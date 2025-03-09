package com.study.ducks.domain.commission.repository;

import com.study.ducks.domain.commission.entity.CommissionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionUserRepository extends JpaRepository<CommissionUser, Long> {
}
