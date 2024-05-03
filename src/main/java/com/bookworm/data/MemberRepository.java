package com.bookworm.data;

import com.bookworm.models.Member;

public interface MemberRepository {


    Member findByUsername(String username);

    Member add(Member member);

    void update(Member member);
}