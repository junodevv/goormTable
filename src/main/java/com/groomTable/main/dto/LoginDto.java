package com.groomTable.main.dto;

import com.groomTable.main.entity.Login;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    public Login toLoginData() {
        return Login.builder().build();
    }
}
