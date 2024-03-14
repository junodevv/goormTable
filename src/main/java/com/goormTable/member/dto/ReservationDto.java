package com.goormTable.member.dto;

import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
import com.goormTable.member.entity.Status;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReservationDto {
    private Integer reserveSeq;
    private LocalDateTime reservationTime;
    private Integer peopleNum;
    private String phoneNum;
    private String extra;
    private String status;
    private Integer memberSeq;

    public static ReservationDto toDto(Reservation entity){
        return ReservationDto.builder()
                .reserveSeq(entity.getReserveSeq())
                .reservationTime(entity.getReservationTime())
                .peopleNum(entity.getPeopleNum())
                .phoneNum(entity.getPhoneNum())
                .extra(entity.getExtra())
                .status(entity.getStatus())
                .memberSeq(entity.getMember().getMemberSeq())
                .build();
    }
}
