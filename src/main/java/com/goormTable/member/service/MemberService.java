package com.goormTable.member.service;

import com.goormTable.member.dto.MemberDto;
import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
import com.goormTable.member.repository.member.MemberRepository;
import com.goormTable.member.repository.reservation.ReservationRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
    // 1. companyId 로 memberSeq 조회
    public Integer findMemberSeqByCompanyId(String companyId){
        Integer memberSeq = memberRepository
                .findMemberByCompanyId(companyId)
                .get(0)
                .getMemberSeq();
        return memberSeq;
    }

    // Todo : 날짜별 예약 손님 조회
    public List<ReservationDto> findAllByCompanyIdAndDay(String companyId, LocalDateTime day){
        Integer memberSeq = findMemberSeqByCompanyId(companyId);
        // 1-1. memberSeq와 Date로 예약 손님 목록 조회 및 반환
        List<ReservationDto> reservationDtos =
                reservationRepository.findByMemberAndDate(memberSeq, day)
                .stream()
                .map(reservation -> ReservationDto.toDto(reservation))
                .collect(Collectors.toList());
        return reservationDtos;
    }


    // Todo : 현재 대기인원 조회
    // 1-2. memberSeq와 현재날짜(Date)와 Status로 예약 손님 Count
}
