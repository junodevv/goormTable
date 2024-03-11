package com.goormTable.login.dto;

import com.goormTable.login.entity.Login;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class LoginDto {
    public Login toLoginData() {
        return Login.builder().build();
    }
}
