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
    public boolean  confirmUserStatus(String tel, int memberSeq) {
        return confirmRepository.findByMember_MemberSeqAndPhoneNum(memberSeq, tel)
                .map(user -> {
                    user.setStatus("confirm");
                    confirmRepository.save(user);
                    return true; // 상태 변경 성공
                }).orElse(false); // 해당 조건의 사용자를 찾지 못함
    }
}
