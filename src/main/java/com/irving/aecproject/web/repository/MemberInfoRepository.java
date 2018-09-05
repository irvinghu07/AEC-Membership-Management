package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

    MemberInfo findByUsername(String username);

}
