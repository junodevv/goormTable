package com.goormTable.member.repository.reservation;

import com.goormTable.member.entity.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository{

    private final SpringDataJpaReservationRepository repository;

    @Override
    public List<Reservation> findByMemberAndDate(Integer memberSeq, LocalDateTime Date) {
        return repository.findByMemberSeqAndReservationTime(memberSeq, Date);
    }

    @Override
    public Integer getCountByMemberAndStatus(Integer memberSeq, List<String> statuses) {
        return repository.getCountByMemberAndStatus(memberSeq, statuses);
    }
}
