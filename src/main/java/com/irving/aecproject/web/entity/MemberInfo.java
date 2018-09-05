package com.irving.aecproject.web.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "SicMemberInfo")
public class MemberInfo implements UserDetails, Serializable, SocialUserDetails {

    private static final long serialVersionUID = 1L;

//    private static final String ADMIN_STR = "admin";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    //    实际名字
    private String contactFirstName;

    private String contactLastName;

    //    普通会员:member
//    执行团队成员: financial / new medium / internal control /  commercial management

    @Enumerated(EnumType.STRING)
    private DepartmentName departmentName;

    private String username;

    private String memberPassword;

    private String major;

    private String estimateGraduateTime;

    private Integer memberScore;

    //    预计投资金额
    private Long estimateInvestmentAmount;

    private String idealOccupation;

    @OneToMany(mappedBy = "memberInfo", cascade = CascadeType.ALL)
    private Set<MemberRole> role;

    @OneToMany(mappedBy = "memberInfo", cascade = CascadeType.ALL)
    private Set<ScoreRecord> scores;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Member_Activity_Association", joinColumns = {@JoinColumn(name = "participatedActivities")}, inverseJoinColumns = {@JoinColumn(name = "participants")})
    private Set<ActivityInfo> participatedActivities;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Member_Assignment_Association", joinColumns = {@JoinColumn(name = "assignmentInfos")}, inverseJoinColumns = {@JoinColumn(name = "memberInfos")})
    //    set of assignments given to this member
    private Set<AssignmentInfo> assignmentInfos;

    @OneToMany(mappedBy = "memberInfo", cascade = CascadeType.ALL)
    private Set<MembershipFee> membershipFees;

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getMemberScore() {
        return memberScore;
    }

    public void setMemberScore(Integer memberScore) {
        this.memberScore = memberScore;
    }

    public Long getEstimateInvestmentAmount() {
        return estimateInvestmentAmount;
    }

    public void setEstimateInvestmentAmount(Long estimateInvestmentAmount) {
        this.estimateInvestmentAmount = estimateInvestmentAmount;
    }

    public String getIdealOccupation() {
        return idealOccupation;
    }

    public void setIdealOccupation(String idealOccupation) {
        this.idealOccupation = idealOccupation;
    }

    public void setRole(Set<MemberRole> role) {
        this.role = role;
    }

    public Set<ScoreRecord> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreRecord> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberInfo{");
        sb.append("memberId=").append(memberId);
        sb.append(", contactFirstName='").append(contactFirstName).append('\'');
        sb.append(", contactLastName='").append(contactLastName).append('\'');
        sb.append(", departmentName=").append(departmentName);
        sb.append(", username='").append(username).append('\'');
        sb.append(", memberPassword='").append(memberPassword).append('\'');
        sb.append(", major='").append(major).append('\'');
        sb.append(", estimateGraduateTime='").append(estimateGraduateTime).append('\'');
        sb.append(", memberScore=").append(memberScore);
        sb.append(", estimateInvestmentAmount=").append(estimateInvestmentAmount);
        sb.append(", idealOccupation='").append(idealOccupation).append('\'');
        sb.append(", role=").append(role);
        sb.append(", scores=").append(scores);
        sb.append(", participatedActivities=").append(participatedActivities);
        sb.append(", assignmentInfos=").append(assignmentInfos);
        sb.append(", membershipFees=").append(membershipFees);
        sb.append('}');
        return sb.toString();
    }


    public long getMemberId() {
        return memberId;
    }

    public void setMid(long mid) {
        this.memberId = mid;
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


    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
//        if (StringUtils.startsWith(this.getMemberId(), ADMIN_STR)) {
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