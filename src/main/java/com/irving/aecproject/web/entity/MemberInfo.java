package com.irving.aecproject.web.entity;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberInfo implements UserDetails {
    private static final String ADMIN_STR = "admin";

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
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
        if (StringUtils.startsWith(this.getMemberid(), ADMIN_STR)) {
            auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            auths.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
        }
        return auths;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return this.getMemberpwd();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return this.getMemberid();
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}