package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository {

    List<Reservation> findByMemberAndDate(Integer memberSeq, LocalDateTime day);

    Integer getCountByMemberAndStatus(Integer memberSeq, List<String> statuses);
}
