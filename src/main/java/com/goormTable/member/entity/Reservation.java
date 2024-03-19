package com.goormTable.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Table(name = "ReservationTable")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_seq", nullable = false, unique = true)
    private Integer reserveSeq; // PK, 예약 시퀀스

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reservation_time")
    private LocalDateTime reservationTime; // 예약한 시간날짜

    @Column(name = "people_num")
    private Integer peopleNum; // 인원수

    @Column(name = "phone_num")
    private String phoneNum; // 전화번호

    @Column(name = "extra")
    private String extra; // 추가 요청사항

//    @Enumerated(EnumType.STRING)
    private String status; // 상태

    @ManyToOne
    @JoinColumn(name = "member_seq", referencedColumnName = "member_seq")
    private Member member; // FK, 회사 시퀀스
}
