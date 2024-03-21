package com.goormTable.main.controller;

import com.goormTable.login.dto.LoginDto;
import com.goormTable.login.service.LoginService;
import com.goormTable.main.service.MainService;
import com.goormTable.member.dto.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MainController", description = "메인 페이지 API")
@RestController
public class MainController {
    @Autowired
    private MainService mainService;
    //TODO 마스터계정만 멤버(가게사장님)를 등록할수 있게 필요
    @Operation(summary = "예약하기", description = "예약할 데이터를 처리합니다.")
    @PostMapping("/insReser")
    public ResponseEntity<String> insMem(@RequestBody ReservationDto reservationDto) {
        ResponseEntity responseEntity = mainService.registerReservation(reservationDto);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("예약 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약 실패");
        }
    }
}
