package com.study.ducks.domain.commission.service;

import com.study.ducks.domain.commission.dto.CommissionRequestDTO;
import com.study.ducks.domain.commission.dto.CommissionResponseDTO;

import java.util.List;

public interface CommissionService {
    
    // 커미션 생성
    CommissionResponseDTO createCommission(CommissionRequestDTO commissionRequestDTO);

    // 커미션 목록 조회
    List<CommissionResponseDTO> commissionLists();

    // 커미션 단건 조회
    CommissionResponseDTO getCommission(Long commissionId);

    // 커미션 수정
    CommissionResponseDTO updateCommission(Long commissionId, CommissionRequestDTO commissionRequestDTO);

    // 커미션 삭제
    void deleteCommission(Long commissionId);
}
