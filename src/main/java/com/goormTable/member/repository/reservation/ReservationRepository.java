package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import com.goormTable.member.entity.Status;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository {

    List<Reservation> findByMemberAndDate(Integer MemberSeq, LocalDateTime day);

    Integer findCountByStatus(Status status);
}
