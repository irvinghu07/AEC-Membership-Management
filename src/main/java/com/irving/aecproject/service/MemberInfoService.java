package com.irving.aecproject.service;

import com.irving.aecproject.entity.MemberInfo;

import java.util.List;

public interface MemberInfoService {
    List<MemberInfo> queryAllMembers();

    List<MemberInfo> queryMembersByPage(int currentPage, int pageSize);
}
