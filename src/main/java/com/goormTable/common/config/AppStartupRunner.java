
package com.goormTable.common.config;

import com.goormTable.login.dto.LoginDto;
import com.goormTable.login.service.LoginService;
import com.goormTable.main.service.MainService;
import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component

public class AppStartupRunner implements CommandLineRunner {
    private final LoginService loginService; // LoginService 인스턴스 주입
    private final MainService mainService;

    @Autowired
    public AppStartupRunner(LoginService loginService, MemberService memberService, MainService mainService) {
        this.loginService = loginService; // 생성자를 통한 의존성 주입
        this.mainService = mainService;
    }
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception {

        LoginDto loginDto = new LoginDto();
        loginDto.setSeq(2);
        loginDto.setAdminId("admin");
        loginDto.setPassword("1234");
        loginDto.setCompanyId("Acafe1");

        loginService.registerUser(loginDto);
        System.out.println("-----서버 시작 시 회원가입 로직이 실행-----");
        String[] extras = {
                "애기의자 주세요",
                "창가 자리 원합니다",
                "조용한 자리로 부탁드립니다",
                "",
                "알레르기가 있어요",
                "채식 메뉴가 있나요?",
                " ",
                "외국인 메뉴판이 있나요?",
                "생일 파티를 위한 자리입니다",
                "휠체어를 사용하는데 문제 없나요?"
        };

        String[] statuses = {"confirm", "wait", "call"};

        Random random = new Random();
        // 10개의 예약 데이터 생성
        for (int i = 0; i < 10; i++) {
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setReservationTime(LocalDateTime.now());
            reservationDto.setPeopleNum(random.nextInt(5) + 1);
            reservationDto.setPhoneNum("010-1234-" + (1000 + random.nextInt(9000)));
            reservationDto.setExtra(extras[random.nextInt(extras.length)]);
            reservationDto.setStatus(statuses[random.nextInt(statuses.length)]);
            reservationDto.setMemberSeq(2);

            mainService.registerReservation(reservationDto);
        }
        System.out.println("-----서버 시작 시 예약 목록 로직이 실행-----");

    }
}
