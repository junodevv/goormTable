package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataJpaReservationRepository extends JpaRepository<Reservation, Long>{

    // 멤버 시퀀스와 시간으로 조회
    @Query("select r from Reservation as r where r.member.memberSeq = :memberSeq and DATE(r.reservationTime) = DATE(:date)")
    List<Reservation> findByMemberSeqAndReservationTime(
            @Param("memberSeq") Integer memberSeq, @Param("date") LocalDateTime day
    );
}
