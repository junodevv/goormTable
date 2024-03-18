package com.goormTable.confirm.service;

import com.goormTable.confirm.repository.ConfirmRepository;
import com.goormTable.member.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConfirmService {

    @Autowired
    private ConfirmRepository confirmRepository;

    @Transactional
    public boolean  confirmUserStatus(String tel, int sequence) {
        Optional<Reservation> resevationOptional = confirmRepository.findByTelAndSequence(tel, sequence);
        if (resevationOptional.isPresent()) {
            Reservation reservation = resevationOptional.get();
            reservation.setStatus("confirm");
            confirmRepository.save(reservation); // 상태 변경을 데이터베이스에 반영
            return true; // 성공적으로 상태 변경
        } else {
            return false; // 사용자를 찾지 못함
        }
    }
}
