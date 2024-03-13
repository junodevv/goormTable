package com.goormTable.member.repository.member;

import com.goormTable.member.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final SpringDataJpaMemberRepository repository;

    @Override
    public List<Member> findMemberByCompanyId(String companyId) {
        return repository.findMemberByAdminIdEquals(companyId);
    }
}
