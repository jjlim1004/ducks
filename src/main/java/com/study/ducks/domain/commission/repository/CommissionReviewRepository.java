package com.study.ducks.domain.commission.repository;

import com.study.ducks.domain.commission.entity.CommissionReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionReviewRepository extends JpaRepository<CommissionReview, Long> {
}
