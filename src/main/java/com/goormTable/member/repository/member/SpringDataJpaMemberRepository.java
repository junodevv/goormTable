package com.goormTable.member.repository.member;

import com.goormTable.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {
    List<Member> findMemberByAdminIdEquals(String companyId);
}
