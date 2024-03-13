package com.goormTable.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MemberTable")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq", nullable = false, unique = true)
    private Integer memberSeq;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "password")
    private String password;

    @Column(name = "admin_yn")
    private String adminYn;

    @Column(name = "reg_time")
    private LocalDateTime regTime;
}