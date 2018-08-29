package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

    @Override
    List<MemberInfo> findAll();

    MemberInfo findByConnactName(String conntactName);

    @Override
    <S extends MemberInfo> S save(S entity);
}
