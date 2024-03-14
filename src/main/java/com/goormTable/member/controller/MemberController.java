package com.goormTable.member.controller;

import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "MemberController", description = "손님(조회) 관련 API")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "날짜별 손님 조회", description = "날짜별 손님 목록을 반환합니다.")
    @GetMapping("/admin") // admin?company_id=null&day=null
    public List<ReservationDto> findListByDate(
            @RequestParam("company_id") String companyId,
            @RequestParam("day") @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime day
    ){
        return memberService.findAllByCompanyIdAndDay(companyId, day);
    }

    @Operation(summary = "대기중 손님 수 조회", description = "대기중인 손님의 수를 반환합니다.")
    @GetMapping("/waitingCnt") // watingCnt?company_id=null
    public Integer waitingCnt(@RequestParam("company_id") String companyId){
        // ToDo 대기 중인 손님 수 반환 로직
        log.info("company_id={}", companyId);
        return 11;
    }

    @GetMapping("/test") // admin?company_id&day
    public String test(
            @RequestParam("company_id") String companyId,
            @RequestParam("day") @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime day
            ){
        return "companyId=" + companyId + "time= " + day;
    }
}

