package com.groomTable.login.dto;

import com.groomTable.login.entity.Login;
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
