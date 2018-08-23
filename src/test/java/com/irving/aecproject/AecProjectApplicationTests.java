package com.irving.aecproject;

import com.irving.aecproject.web.entity.MemberInfo;
import com.irving.aecproject.web.service.MemberInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AecProjectApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(AecProjectApplicationTests.class);

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private MemberInfoService memberInfoService;


    @Test
    public void testPassword() {
        ArrayList<MemberInfo> allMembers = (ArrayList<MemberInfo>) memberInfoService.queryAllMembers();
        boolean isWorking = true;
        for (MemberInfo memberInfo : allMembers) {
            String pwd = memberInfo.getMemberpwd();
            logger.info("===============================================");
            logger.info("validating member info for :{}", memberInfo);
            String encodedPwd = passwordEncoder.encode(pwd);
            boolean flag = passwordEncoder.matches(pwd, encodedPwd);
            logger.info("encoded password :{}", encodedPwd);
            logger.info("match result:{}", flag);
            logger.info("===============================================");
            if (!flag) {
                isWorking = false;
                break;
            }
        }
        Assert.assertTrue(isWorking);
    }


    @Test
    public void changePwd() {
        ArrayList<MemberInfo> allMembers = (ArrayList<MemberInfo>) memberInfoService.queryAllMembers();
        allMembers.forEach(memberInfo -> memberInfo.setMemberpwd(passwordEncoder.encode(memberInfo
        .getMemberpwd())));
        allMembers.forEach(memberInfo -> memberInfoService.updateMemberInfo(memberInfo));
    }
}
