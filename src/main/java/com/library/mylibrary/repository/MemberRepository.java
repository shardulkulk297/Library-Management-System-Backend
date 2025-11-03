package com.library.mylibrary.repository;

import com.library.mylibrary.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("Select m from Member m WHERE m.user.username = ?1")
    Member getByUsername(String name);
}
