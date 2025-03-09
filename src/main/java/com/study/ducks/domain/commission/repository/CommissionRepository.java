package com.study.ducks.domain.commission.repository;

import com.study.ducks.domain.commission.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {

}
