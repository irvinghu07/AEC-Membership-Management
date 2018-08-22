package com.irving.aecproject.web.dao;

import com.irving.aecproject.web.entity.MemberInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberInfoMapper {
    int deleteByPrimaryKey(String memberid);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(String memberid);

    List<MemberInfo> selectAll();

    int updateByPrimaryKey(MemberInfo record);
}