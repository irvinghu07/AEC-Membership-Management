package com.irving.aecproject.web.entity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberInfo implements UserDetailsService {
    private String memberid;

    private String memberpwd;

    private String cnname;

    private String egname;

    private String wechatname;

    private String wechatid;

    private Integer memberscore;

    private Integer active;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getMemberpwd() {
        return memberpwd;
    }

    public void setMemberpwd(String memberpwd) {
        this.memberpwd = memberpwd == null ? null : memberpwd.trim();
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public String getEgname() {
        return egname;
    }

    public void setEgname(String egname) {
        this.egname = egname == null ? null : egname.trim();
    }

    public String getWechatname() {
        return wechatname;
    }

    public void setWechatname(String wechatname) {
        this.wechatname = wechatname == null ? null : wechatname.trim();
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid == null ? null : wechatid.trim();
    }

    public Integer getMemberscore() {
        return memberscore;
    }

    public void setMemberscore(Integer memberscore) {
        this.memberscore = memberscore;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberInfo{");
        sb.append("memberid='").append(memberid).append('\'');
        sb.append(", memberpwd='").append(memberpwd).append('\'');
        sb.append(", cnname='").append(cnname).append('\'');
        sb.append(", egname='").append(egname).append('\'');
        sb.append(", wechatname='").append(wechatname).append('\'');
        sb.append(", wechatid='").append(wechatid).append('\'');
        sb.append(", memberscore=").append(memberscore);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }

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
        return null;
    }
}