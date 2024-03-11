package com.goormTable.login.controller;

import com.goormTable.login.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "LoginController", description = "로그인 관련 API")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Operation(summary = "로그인", description = "사용자 로그인을 처리합니다.")
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String id, @RequestParam String password) {
        //ToDO 로그인 처리 로직 작성 필요

        return ResponseEntity.ok(loginService.chkAdmin(id,password));
    }

//    public ResponseEntity insMember(String[] args) {
//
//    }
}