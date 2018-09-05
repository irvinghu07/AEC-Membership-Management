package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SicMemberRole")
public class MemberRole {

    public MemberRole() {
    }

    public MemberRole(Role role, MemberInfo memberInfo) {
        this.role = role;
        this.memberInfo = memberInfo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberRoleID;

    @Enumerated
    private Role role;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MemberInfo memberInfo;

    public Long getMemberRoleID() {
        return MemberRoleID;
    }

    public void setMemberRoleID(Long memberRoleID) {
        this.MemberRoleID = memberRoleID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    @JsonBackReference
    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberRole{");
        sb.append("MemberRoleID=").append(MemberRoleID);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
