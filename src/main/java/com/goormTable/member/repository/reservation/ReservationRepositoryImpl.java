package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import com.goormTable.member.entity.Status;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository{

    private final SpringDataJpaReservationRepository repository;

    @Override
    public List<Reservation> findByMemberAndDate(Integer MemberSeq, LocalDateTime Date) {
        return repository.findByMemberSeqAndReservationTime(MemberSeq, Date);
    }

    @Override
    public Integer findCountByStatus(Status status) {
        return null;
    }
}
