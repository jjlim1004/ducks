package com.study.ducks.domain.commission.controller;

import com.study.ducks.domain.commission.dto.CommissionRequestDTO;
import com.study.ducks.domain.commission.dto.CommissionResponseDTO;
import com.study.ducks.domain.commission.service.CommissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Commission", description = "커미션 관련 API")
@RestController
@RequestMapping("/api/commissions")
@RequiredArgsConstructor
public class CommissionController {

    private final CommissionService commissionService;

    // 커미션 생성
    @Operation(summary = "커미션 생성", description = "새로운 커미션을 생성합니다.")
    @PostMapping
    public ResponseEntity<CommissionResponseDTO> createCommission(
            @Valid @RequestBody CommissionRequestDTO commissionRequestDTO) {
        CommissionResponseDTO response = commissionService.createCommission(commissionRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 모든 커미션 조회
    @Operation(summary = "모든 커미션 조회", description = "모든 커미션을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<CommissionResponseDTO>> getAllCommissions() {
        List<CommissionResponseDTO> responseList = commissionService.commissionLists();
        return ResponseEntity.ok(responseList);
    }

    // 커미션 단건 조회
    @Operation(summary = "커미션 단건 조회", description = "커미션 ID를 기반으로 단건 커미션을 조회합니다.")
    @GetMapping("/{commissionId}")
    public ResponseEntity<CommissionResponseDTO> getCommission(@PathVariable Long commissionId) {
        CommissionResponseDTO response = commissionService.getCommission(commissionId);
        return ResponseEntity.ok(response);
    }

    // 커미션 수정
    @Operation(summary = "커미션 수정", description = "커미션 ID를 기반으로 해당 커미션을 수정합니다.")
    @PutMapping("/{commissionId}")
    public ResponseEntity<CommissionResponseDTO> updateCommission(
            @PathVariable Long commissionId,
            @Valid @RequestBody CommissionRequestDTO commissionRequestDTO) {
        CommissionResponseDTO response = commissionService.updateCommission(commissionId, commissionRequestDTO);
        return ResponseEntity.ok(response);
    }

    // 커미션 삭제
    @Operation(summary = "커미션 삭제", description = "커미션 ID를 기반으로 해당 커미션을 삭제합니다.")
    @DeleteMapping("/{commissionId}")
    public ResponseEntity<Void> deleteCommission(@PathVariable Long commissionId) {
        commissionService.deleteCommission(commissionId);
        return ResponseEntity.noContent().build();
    }
}
