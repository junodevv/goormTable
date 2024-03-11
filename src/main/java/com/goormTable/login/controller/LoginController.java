package com.goormTable.login.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "LoginController", description = "로그인 관련 API")
@RestController
public class LoginController {

    @Operation(summary = "로그인", description = "사용자 로그인을 처리합니다.")
    @GetMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password) {
        //ToDO 로그인 처리 로직 작성 필요
        return "로그인 성공";
    }
}