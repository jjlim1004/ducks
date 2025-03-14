package com.study.ducks.domain.commission.entity;

import com.study.ducks.common.BaseTimeEntity;
import com.study.ducks.domain.commission.enums.CommissionStatus;
import com.study.ducks.domain.user.entity.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommissionUser extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionUsersId;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CommissionStatus commissionStatus;

    private LocalDateTime complete_at;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commission commission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Builder
    public CommissionUser(CommissionStatus commissionStatus, LocalDateTime complete_at, Commission commission, Users users) {
        this.commissionStatus = commissionStatus;
        this.complete_at = complete_at;
        this.commission = commission;
        this.users = users;
    }
}
