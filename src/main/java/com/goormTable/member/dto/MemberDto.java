package com.goormTable.member.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private Long memberSeq;
    private String adminId;
    private String password;
    private String adminYn;
    private String companyId;
    private LocalDateTime reg_time;
}
