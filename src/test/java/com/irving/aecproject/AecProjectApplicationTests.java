package com.irving.aecproject;

import com.irving.aecproject.web.entity.DepartmentName;
import com.irving.aecproject.web.entity.MemberInfo;
import com.irving.aecproject.web.entity.MemberRole;
import com.irving.aecproject.web.entity.Role;
import com.irving.aecproject.web.repository.MemberInfoRepository;
import com.irving.aecproject.web.service.MemberInfoService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AecProjectApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(AecProjectApplicationTests.class);

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Ignore
    @Test
    public void testSave() {
//        Set<MemberRole> memberRoles = new HashSet<MemberRole>() {{
//            add(MemberRole);
//        }};
        MemberInfo memberInfo = new MemberInfo("Ethan", "Irving",
                DepartmentName.NEW_MEDIUM, "irving", "123456", "CS",
                "2020", Long.valueOf("1000"), "TBD");
        memberInfoService.saveNewMember(memberInfo);
//        logger.info("result:{}", );
    }

    @Test
    public void testSaveWithChinese() {
        MemberInfo memberInfo = new MemberInfo("芮铨", "胡",
                DepartmentName.NEW_MEDIUM, "irving", "123456", "CS",
                "2020", Long.valueOf("1000"), "TBD");
        memberInfoService.saveNewMember(memberInfo);
    }

    @Test
    public void testQueryAll() {
        logger.info("result:{}", memberInfoService.queryAllMembers());
    }

    @Test
    public void queryMemberByUsername() {
        String username = "irving";
        logger.info("member:{}", memberInfoService.loadUserByUsername(username));
    }

    @Test
    public void addRole() {
        String username = "irving";
        MemberInfo memberInfo = memberInfoRepository.findByUsername(username);
        MemberRole memberRole = new MemberRole(Role.EXECUTIVE, memberInfo);
        Set<MemberRole> roles = memberInfo.getRole();
        roles.add(memberRole);
        memberInfo.setRole(roles);
        memberInfoRepository.saveAndFlush(memberInfo);
    }
}
