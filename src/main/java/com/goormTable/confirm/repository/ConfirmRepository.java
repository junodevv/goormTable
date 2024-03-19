package com.goormTable.confirm.repository;

import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmRepository extends JpaRepository<Reservation, Integer> {
    Optional<Reservation> findByMember_MemberSeqAndPhoneNum(Integer memberSeq, String phoneNum);
}
