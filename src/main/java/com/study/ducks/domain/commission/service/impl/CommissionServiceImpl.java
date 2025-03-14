package com.study.ducks.domain.commission.service.impl;

import com.study.ducks.domain.commission.dto.CommissionRequestDTO;
import com.study.ducks.domain.commission.dto.CommissionResponseDTO;
import com.study.ducks.domain.commission.entity.Commission;
import com.study.ducks.domain.commission.enums.CommissionStatus;
import com.study.ducks.domain.commission.repository.CommissionRepository;
import com.study.ducks.domain.user.entity.Users;
import com.study.ducks.domain.user.repository.UserRepository;
import com.study.ducks.domain.commission.service.CommissionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommissionServiceImpl implements CommissionService {
    private final CommissionRepository commissionRepository;
    private final UserRepository userRepository;

    // 커미션 생성
    @Override
    public CommissionResponseDTO createCommission(CommissionRequestDTO commissionRequestDTO) {
        // 사용자 찾기
        Users user = userRepository.findById(commissionRequestDTO.usersId())
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다."));

        // 커미션 엔티티 생성
        Commission commission = Commission.builder()
                .title(commissionRequestDTO.title())
                .content(commissionRequestDTO.content())
                .commissionStatus(CommissionStatus.valueOf(commissionRequestDTO.commissionStatus()))
                .users(user)
                .build();

        // 저장
        Commission savedCommission = commissionRepository.save(commission);

        return CommissionResponseDTO.builder()
                .commissionId(savedCommission.getCommissionId())
                .title(savedCommission.getTitle())
                .content(savedCommission.getContent())
                .commissionStatus(savedCommission.getCommissionStatus().name())
//                .usersId(savedCommission.getUsers().getId())
                .build();
    }

    // 모든 커미션 조회
    @Override
    public List<CommissionResponseDTO> commissionLists() {
        return commissionRepository.findAll().stream()
                .map(commission -> CommissionResponseDTO.builder()
                        .commissionId(commission.getCommissionId())
                        .title(commission.getTitle())
                        .content(commission.getContent())
                        .commissionStatus(commission.getCommissionStatus().name())
//                        .usersId(commission.getUsers().getId())
                        .build())
                .collect(Collectors.toList());
    }

    // 특정 커미션 조회
    @Override
    public CommissionResponseDTO getCommission(Long commissionId) {
        Commission commission = commissionRepository.findById(commissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 커미션을 찾을 수 없습니다."));

        return CommissionResponseDTO.builder()
                .commissionId(commission.getCommissionId())
                .title(commission.getTitle())
                .content(commission.getContent())
                .commissionStatus(commission.getCommissionStatus().name())
//                .usersId(commission.getUsers().getId())
                .build();
    }

    // 커미션 수정
    @Override
    public CommissionResponseDTO updateCommission(Long commissionId, CommissionRequestDTO commissionRequestDTO) {
        Commission commission = commissionRepository.findById(commissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 커미션을 찾을 수 없습니다."));

        commission.update(
                commissionRequestDTO.title(),
                commissionRequestDTO.content(),
                CommissionStatus.valueOf(commissionRequestDTO.commissionStatus())
        );

        return CommissionResponseDTO.builder()
                .commissionId(commission.getCommissionId())
                .title(commission.getTitle())
                .content(commission.getContent())
                .commissionStatus(commission.getCommissionStatus().name())
//                .usersId(commission.getUsers().getId())       // 추후 getUsers() 가 추가되면 넣을 것
                .build(); 
    }

    // 커미션 삭제
    @Override
    public void deleteCommission(Long commissionId) {
        Commission commission = commissionRepository.findById(commissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 커미션을 찾을 수 없습니다."));

        commissionRepository.delete(commission);
    }
}
