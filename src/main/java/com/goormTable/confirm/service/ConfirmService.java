package com.goormTable.confirm.service;

import com.goormTable.call.dto.CallReservationData;
import com.goormTable.confirm.repository.ConfirmRepository;
import com.goormTable.member.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConfirmService {

    @Autowired
    private ConfirmRepository confirmRepository;

    @Transactional
    public boolean  confirmUserStatus(String tel, int memberSeq) {
        return confirmRepository.findByMember_MemberSeqAndPhoneNum(memberSeq, tel)
                .map(user -> {
                    user.setStatus("confirm");
                    confirmRepository.save(user);
                    return true; // 상태 변경 성공
                }).orElse(false); // 해당 조건의 사용자를 찾지 못함
    }

    @Scheduled(fixedRate = 600000) // 10분마다 실행
    public void updateReservationStatus() {
        CallReservationData callReservationData = CallReservationData.getInstance();

        // CallReservationData 내의 모든 예약의 상태를 "confirm"으로 변경
        for (Reservation reservation : callReservationData.getReservationList()) {
            Optional<Reservation> reservationOptional = confirmRepository.findByMember_MemberSeqAndPhoneNum(reservation.getReserveSeq(), reservation.getPhoneNum());
            Reservation reserve = reservationOptional.get();
            reserve.setStatus("confirm");
            confirmRepository.save(reserve); // 상태를 업데이트하는 로직을 CallService에 구현
        }

        // 처리 후 CallReservationData 초기화 (선택적)
        callReservationData.clearReservations();
    }
}
