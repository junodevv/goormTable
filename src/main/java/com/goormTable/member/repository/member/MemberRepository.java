package com.goormTable.member.repository.member;


import com.goormTable.member.entity.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findMemberByCompanyId(String companyId);
}
