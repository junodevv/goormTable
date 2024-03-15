package com.goormTable.login.repository;

import com.goormTable.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member,Long> {
    public Member findByAdminIdAndPasswordAndAdminYn(String id,String password,String yn);
    public Member findByAdminIdAndAdminYn(String id,String adminYn);

    public Member findByAdminId(String id);

}
