package com.irving.aecproject.web.service.implementation;

import com.github.pagehelper.PageHelper;
import com.irving.aecproject.web.dao.MemberInfoMapper;
import com.irving.aecproject.web.entity.MemberInfo;
import com.irving.aecproject.web.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MemberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService {
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public List<MemberInfo> queryAllMembers() {
        return memberInfoMapper.selectAll();
    }

    @Override
    public List<MemberInfo> queryMembersByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return memberInfoMapper.selectAll();
    }

    @Override
    public MemberInfo queryMemberByUsername(String username) {
        return memberInfoMapper.selectByPrimaryKey(username);
    }

    @Override
    public int updateMemberInfo(MemberInfo memberInfo) {
        return memberInfoMapper.updateByPrimaryKey(memberInfo);
    }
}
