package com.groomTable.member.dto;

import com.groomTable.member.entity.Login;
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
