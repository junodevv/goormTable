package com.goormTable.call.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CallController {

    @PostMapping("admin/call")
    public ResponseEntity<?> call(@RequestParam String tel, @RequestParam int sequence, @RequestParam String status){
        return ResponseEntity.ok().build();
    }
}
