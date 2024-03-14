package com.goormTable.login.service;

import com.goormTable.login.dto.LoginDto;
import com.goormTable.login.entity.Login;
import com.goormTable.login.repository.LoginRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;
    public ResponseEntity chkAdmin(String id,String pw) {
        Login checkAdmin = loginRepository.findByAdminIdAndPasswordAndAdminYn(id,pw,"Y");

//        LoginDto dto = new LoginDto();
//        Login login = Login.builder()
//                .adminId(dto.getAdminId())
//                .adminYn(dto.getAdminYn())
//                .build();
//        ;


        System.out.println(checkAdmin);
        if(checkAdmin != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
