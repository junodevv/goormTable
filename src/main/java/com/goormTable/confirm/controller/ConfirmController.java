package com.goormTable.confirm.controller;

import com.goormTable.confirm.dto.ConfirmRequest;
import com.goormTable.confirm.service.ConfirmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @PostMapping("/admin/confirm")
    public ResponseEntity<?> confirm(@RequestParam String tel, @RequestParam int sequence, @RequestParam String status) {
        // 여기서 status 파라미터를 사용하지 않는 것 같지만, 필요에 따라 로직에 추가할 수 있습니다.
        boolean isConfirmed = confirmService.confirmUserStatus(tel, sequence);
        if(isConfirmed){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
