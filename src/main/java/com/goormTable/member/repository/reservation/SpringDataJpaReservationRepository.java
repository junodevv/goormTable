package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import com.goormTable.member.entity.Status;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataJpaReservationRepository extends JpaRepository<Reservation, Long>{

    // 멤버 시퀀스와 시간으로 조회
    @Query(
            "select r from Reservation as r "
             + "where r.member.memberSeq = :memberSeq "
             + "and DATE(r.reservationTime) = DATE(:date)"
             + "order by (case r.status "
                    + "        when 'call' then 1"
                    + "        when 'wait' then 2"
                    + "        else 3 "
                    + "end), r.status asc, DATE(r.reservationTime) asc"
    )
    List<Reservation> findByMemberSeqAndReservationTime(
            @Param("memberSeq") Integer memberSeq,
            @Param("date") LocalDateTime day
    );

    // 멤버 시퀀스로 대기 인원 조회
    @Query(
            "select count(r.status) from Reservation as r "
            + "where r.member.memberSeq = :memberSeq "
            + "and r.status in :statuses"
    )
    Integer getCountByMemberAndStatus(
            @Param("memberSeq") Integer memberSeq,
            @Param("statuses") List<String> statuses
    );
}
