package com.goormTable.login.service;

import com.goormTable.login.dto.LoginDto;
import com.goormTable.login.repository.LoginRepository;
import com.goormTable.member.dto.MemberDto;
import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
import com.goormTable.member.repository.member.SpringDataJpaMemberRepository;
import com.goormTable.member.repository.reservation.SpringDataJpaReservationRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final SpringDataJpaReservationRepository reservationRepository;
    private final SpringDataJpaMemberRepository memberRepository;
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    public ResponseEntity<MemberDto> chkAdmin(String id,String pw) {
        Member checkAdmin = loginRepository.findByAdminIdAndAdminYn(id, "Y");

        if (checkAdmin != null && passwordEncoder.matches(pw, checkAdmin.getPassword())) {
            MemberDto memberDto = new MemberDto();
            memberDto.setAdminId(checkAdmin.getAdminId());
            memberDto.setCompanyId(checkAdmin.getCompanyId()); // 예시에서 username 필드에 adminId 값을 사용
            memberDto.setAdminYn(checkAdmin.getAdminYn());
            return ResponseEntity.ok(memberDto);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @Transactional
    public boolean registerUser(LoginDto loginDto){
        try {
            Member existingUser = loginRepository.findByAdminId(loginDto.getAdminId());
            if (existingUser != null) {
                //TODO 이미 존재하는 경우, 추가적인 처리가 필요.
                return false;
            }
            String encodedPassword = passwordEncoder.encode(loginDto.getPassword());
            Member insMember = Member.builder()
                    .adminId(loginDto.getAdminId())
                    .password(encodedPassword) // 비밀번호 암호화
                    .companyId(loginDto.getCompanyId())
                    .adminYn("Y")
                    .regTime(LocalDateTime.now()) // 현재 시간 등록
                    .build();

            loginRepository.save(insMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Transactional
    public void registerReservation(ReservationDto reservationDto){
        Member member = memberRepository.findById(Long.valueOf(reservationDto.getMemberSeq()))
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Reservation reservation = Reservation.builder()
                .reservationTime(reservationDto.getReservationTime())
                .peopleNum(reservationDto.getPeopleNum())
                .phoneNum(reservationDto.getPhoneNum())
                .extra(reservationDto.getExtra())
                .status(reservationDto.getStatus())
                .member(member) // 조회한 Member 엔티티 설정
                .build();
        reservationRepository.save(reservation);

    }
}
