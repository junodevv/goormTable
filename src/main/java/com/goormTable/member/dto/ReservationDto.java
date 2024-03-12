package com.goormTable.member.dto;

import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Status;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDto {
    private Long reserveSeq;
    private LocalDateTime reservationTime;
    private int peopleNum;
    private String phoneNum;
    private String extra;
    private Status status;
    private Member member;
}
