package com.irving.aecproject.web.service;

import com.irving.aecproject.web.entity.MemberInfo;

import java.util.List;

public interface MemberInfoService {
    List<MemberInfo> queryAllMembers();

    List<MemberInfo> queryMembersByPage(int currentPage, int pageSize);

    MemberInfo queryMemberByUsername(String username);

    int updateMemberInfo(MemberInfo memberInfo);
}
