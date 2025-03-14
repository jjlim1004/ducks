package com.study.ducks.domain.commission.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(title = "커미션 응답 DTO")
public record CommissionResponseDTO(
        @Schema(description = "커미션 ID", example = "1")
        Long commissionId,

        @Schema(description = "커미션 제목", example = "일러스트 커미션 신청")
        String title,

        @Schema(description = "커미션 내용", example = "캐릭터 일러스트 의뢰합니다.")
        String content,

        @Schema(description = "커미션 상태", example = "PENDING")
        String commissionStatus,

        @Schema(description = "사용자 ID", example = "1")
        Long usersId
) {
    @Builder
    public CommissionResponseDTO(Long commissionId, String title, String content, String commissionStatus, Long usersId) {
        this.commissionId = commissionId;
        this.title = title;
        this.content = content;
        this.commissionStatus = commissionStatus;
        this.usersId = usersId;
    }
}
