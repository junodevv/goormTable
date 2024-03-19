package com.goormTable.call.controller;

import com.goormTable.call.service.CallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CallController {

    @Autowired
    private CallService callService;

    @PostMapping("admin/call")
    public ResponseEntity<?> call(@RequestParam String tel, @RequestParam int sequence, @RequestParam String status){

        boolean isConfirmed = callService.CallReservation(tel, sequence);
        if(isConfirmed){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
