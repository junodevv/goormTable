package com.goormTable.login.service;

import com.goormTable.login.dto.LoginDto;
import com.goormTable.login.repository.LoginRepository;
import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.entity.Member;
import com.goormTable.member.entity.Reservation;
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
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    public ResponseEntity chkAdmin(String id,String pw) {
        Member checkAdmin = loginRepository.findByAdminIdAndAdminYn(id, "Y");

        if (checkAdmin != null && passwordEncoder.matches(pw, checkAdmin.getPassword())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
        Reservation reservation= new Reservation();
        reservation.setReservationTime(reservationDto.getReservationTime());
        reservation.setPeopleNum(reservationDto.getPeopleNum());
        reservation.setPhoneNum(reservationDto.getPhoneNum());
        reservation.setExtra(reservationDto.getExtra());
        reservation.setStatus(reservationDto.getStatus());
        reservationRepository.save(reservation);

    }
}
