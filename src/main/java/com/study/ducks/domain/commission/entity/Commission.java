package com.study.ducks.domain.commission.entity;

import com.study.ducks.common.BaseTimeEntity;
import com.study.ducks.domain.commission.enums.CommissionStatus;
import com.study.ducks.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Commission extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionId;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CommissionStatus commissionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Commission(String title, String content, CommissionStatus commissionStatus, User user) {
        this.title = title;
        this.content = content;
        this.commissionStatus = commissionStatus;
        this.user = user;
    }

}
