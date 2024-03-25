package com.goormTable.main.service;

import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
import com.goormTable.member.entity.Status;
import com.goormTable.member.repository.member.SpringDataJpaMemberRepository;
import com.goormTable.member.repository.reservation.SpringDataJpaReservationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MainService {
    private final SpringDataJpaReservationRepository reservationRepository;
    private final SpringDataJpaMemberRepository memberRepository;
    @Transactional
    public ResponseEntity registerReservation(ReservationDto reservationDto){
        Member member = memberRepository.findById(Long.valueOf(reservationDto.getMemberSeq()))
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Reservation reservation = Reservation.builder()
                .reservationTime(LocalDateTime.now())
                .peopleNum(reservationDto.getPeopleNum())
                .phoneNum(reservationDto.getPhoneNum())
                .extra(reservationDto.getExtra())
                .status(Status.WAIT.getSmallValue())
                .member(member)
                .build();

        return ResponseEntity.ok(reservationRepository.save(reservation));
    }
}
