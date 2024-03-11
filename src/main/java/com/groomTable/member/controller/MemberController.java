package com.groomTable.member.controller;

import com.groomTable.member.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MemberController", description = "손님(조회) 관련 API")
@RestController
public class MemberController {

    @Operation(summary = "날짜별 손님 조회", description = "날짜별 손님 목록을 반환합니다.")
    @GetMapping("/admin")
    public List<Member> list(@RequestParam String companyId, @RequestParam LocalDateTime day){
        // ToDo 손님 목록 조회 로직
        return null; //손님 목록 객체
    }

    @Operation(summary = "대기중 손님 수 조회", description = "대기중인 손님의 수를 반환합니다.")
    @GetMapping("/waitingCnt")
    public Integer waitingCnt(@RequestParam String companyId){
        // ToDo 대기 중인 손님 수 반환 로직
        return null;
    }
}
