package com.study.ducks.domain.commission.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Schema(title = "커미션 요청 DTO")
public record CommissionRequestDTO(
        @Schema(description = "커미션 제목", example = "일러스트 커미션 신청")
        @NotBlank(message = "제목을 입력해주세요")
        String title,

        @Schema(description = "커미션 내용", example = "캐릭터 일러스트 의뢰합니다.")
        @NotBlank(message = "내용을 입력해주세요")
        String content,

        @Schema(description = "커미션 상태", example = "PENDING")
        @NotNull(message = "커미션 상태를 입력해주세요")
        String commissionStatus,

        @Schema(description = "사용자 ID", example = "1")
        @NotNull(message = "사용자 ID를 입력해주세요")
        Long usersId
) {
    @Builder
    public CommissionRequestDTO(String title, String content, String commissionStatus, Long usersId) {
        this.title = title;
        this.content = content;
        this.commissionStatus = commissionStatus;
        this.usersId = usersId;
    }
}
