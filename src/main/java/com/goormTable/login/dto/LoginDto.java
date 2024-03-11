package com.goormTable.login.dto;

import com.goormTable.login.entity.Login;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private Long seq;
    private String adminId;
    private String password;
    private String companyId;
    private String adminYn;
    private LocalDateTime regTime;
    public Login toLoginData() {
        return Login.builder()
                .seq(this.seq)
                .adminId(this.adminId)
                .password(this.password)
                .companyId(this.companyId)
                .adminYn(this.adminYn)
                .regTime(this.regTime)
                .build();
    }
}
