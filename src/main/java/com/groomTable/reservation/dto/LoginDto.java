package com.groomTable.reservation.dto;

import com.groomTable.reservation.entity.Login;
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
