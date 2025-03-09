package com.study.ducks.domain.commission.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum CommissionStatus {
    REQUESTED("요청"),
    IN_PROGRESS("진행중"),
    COMPLETED("완료"),
    CANCELLED("취소");

    private final String description;
}
