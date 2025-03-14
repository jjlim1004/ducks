package com.study.ducks.domain.commission.entity;

import com.study.ducks.common.BaseTimeEntity;
import com.study.ducks.domain.user.entity.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommissionReview extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionReviewId;

    private byte rating;

    @Lob
    @Column(nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commission commission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Builder
    public CommissionReview(byte rating, String comment, Commission commission, Users users) {
        this.rating = rating;
        this.comment = comment;
        this.commission = commission;
        this.users = users;
    }
}
