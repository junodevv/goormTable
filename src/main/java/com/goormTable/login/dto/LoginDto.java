package com.goormTable.login.dto;

import com.goormTable.member.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private int seq;
    private String adminId;
    private String password;
    private String companyId;
    private String adminYn;
    private LocalDateTime regTime;
    public Member toLoginData() {
        return Member.builder()
                .memberSeq(this.seq)
                .adminId(this.adminId)
                .password(this.password)
                .companyId(this.companyId)
                .adminYn(this.adminYn)
                .regTime(this.regTime)
                .build();
    }
    public Member toRegisterUser() {
        return Member.builder()
                .adminId(this.adminId)
                .password(this.password)
                .companyId(this.companyId)
                .adminYn(this.adminYn)
                .regTime(this.regTime)
                .build();
    }
}
