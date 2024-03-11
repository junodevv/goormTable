package com.goormTable.login.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="login") //사용하지 않으면 클래스 이름이 테이블 이름이 됨
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, unique = true)
    private Long seq;
    @Column(name="adminId") //어드민 아이디
    private String adminId;
    @Column(name="password") //패스워드
    private String password;
    @Column(name="company_id") //고객사별 식별자
    private String companyId;
    @Column(name="admin_yn") //어드민 구분
    private String adminYn;
    @Column(name="reg_time") // 등록 시간
    private LocalDateTime regTime;

}
