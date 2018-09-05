package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SicMemberRole")
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    private String roleName;

    @ManyToOne(optional = false)
    private MemberInfo memberInfo;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberRole{");
        sb.append("rid=").append(rid);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", memberInfo=").append(memberInfo);
        sb.append('}');
        return sb.toString();
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    @JsonBackReference
    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

}
