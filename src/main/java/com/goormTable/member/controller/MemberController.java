package com.goormTable.member.controller;

import com.goormTable.member.dto.ReservationDto;
import com.goormTable.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MemberController", description = "손님(조회) 관련 API")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "날짜별 손님 조회", description = "날짜별 손님 목록을 반환합니다.")
    @GetMapping("/admin") // admin?company_id=null&day=null
    public ResponseEntity<List<ReservationDto>> findListByDate(
            @RequestParam("company_id") String companyId,
            @RequestParam String day
    ){
        return ResponseEntity.ok(memberService.findAllByCompanyIdAndDay(companyId, day));
    }

    @Operation(summary = "대기중 손님 수 조회", description = "대기중인 손님의 수를 반환합니다.")
    @GetMapping("/waitingCnt") // watingCnt?company_id=null
    public ResponseEntity<Integer> waitingCnt(@RequestParam("company_id") String companyId){

        return ResponseEntity.ok(memberService.getCountByMember(companyId));
    }
}

