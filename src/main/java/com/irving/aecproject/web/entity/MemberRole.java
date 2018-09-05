package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SicMemberRole")
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @Enumerated
    private Role role;

    @ManyToOne(optional = false)
    private MemberInfo memberInfo;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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
        sb.append("rid=").append(rid);
        sb.append(", role=").append(role);
        sb.append(", memberInfo=").append(memberInfo);
        sb.append('}');
        return sb.toString();
    }
}
