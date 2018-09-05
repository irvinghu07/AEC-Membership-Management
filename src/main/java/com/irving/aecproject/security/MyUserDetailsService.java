package com.irving.aecproject.security;

import com.irving.aecproject.web.service.MemberInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        根据用户名使用数据持久层查找用户信息
//        MemberInfo queriesMemberInfo = memberInfoService.queryMemberByUsername(username);
//        logger.info("表单登录用户名: {}", username);
//        MemberInfo memberInfo = new MemberInfo();
//        return buildUser(username);
//        return memberInfoService.queryMemberByUsername(username);
        return null;
    }

    /**
     * @param userId the user ID used to lookup the user details
     * @return the SocialUserDetails requested
     * @see UserDetailsService#loadUserByUsername(String)
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
//        根据用户名使用数据持久层查找用户信息
        logger.info("社交登录用户ID: {}", userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
//        String pwd = memberInfoService.queryMemberByUsername(userId).getMemberPassword();
//        logger.info("数据库密码是:{}", pwd);
//        return new SocialUser(userId, pwd, true, true, true, true, AuthorityUtils
//                .commaSeparatedStringToAuthorityList("admin"));
        return null;
    }
}
