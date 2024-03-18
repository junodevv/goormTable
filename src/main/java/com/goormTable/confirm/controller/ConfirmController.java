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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @PostMapping("/admin/confirm")
    public ResponseEntity<?> confirm(@Validated @RequestBody ConfirmRequest confirmRequest) {
        boolean isConfirmed = confirmService.confirmUserStatus(confirmRequest.getTel(),confirmRequest.getSequence());
        if(isConfirmed){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
