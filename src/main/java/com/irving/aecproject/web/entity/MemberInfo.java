package com.irving.aecproject.web.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "SicMemberInfo")
public class MemberInfo implements UserDetails, Serializable, SocialUserDetails {

    private static final long serialVersionUID = 1L;

    private static final String ADMIN_STR = "admin";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mid;

    private String username;

    private String memberPassword;

    private String contactName;

    private String major;

    private String estimateGraduateTime;

    private String wechatid;

    private Integer memberscore;

    private Integer active;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<MemberRole> role;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    private List<ScoreRecord> scores;

    public MemberInfo(String username, String memberPassword, String contactName, String major, String estimateGraduateTime, String wechatid, Integer memberscore, Integer active, List<MemberRole> role) {
        this.username = username;
        this.memberPassword = memberPassword;
        this.contactName = contactName;
        this.major = major;
        this.estimateGraduateTime = estimateGraduateTime;
        this.wechatid = wechatid;
        this.memberscore = memberscore;
        this.active = active;
        this.role = role;
    }

    public static String getAdminStr() {
        return ADMIN_STR;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEstimateGraduateTime() {
        return estimateGraduateTime;
    }

    public void setEstimateGraduateTime(String estimateGraduateTime) {
        this.estimateGraduateTime = estimateGraduateTime;
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid;
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

    public List<MemberRole> getRole() {
        return role;
    }

    public void setRole(List<MemberRole> role) {
        this.role = role;
    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
//        if (StringUtils.startsWith(this.getMid(), ADMIN_STR)) {
//            auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            auths.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
//        }
        return auths;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return this.getMemberPassword();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return this.getUsername();
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

    /**
     * The user's identity at the provider.
     * Might be same as {@link #getUsername()} if users are identified by username
     *
     * @return user's id used to assign connections
     */
    @Override
    public String getUserId() {
        return this.getUsername();
    }
}