package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SicAssignmentInfo")
public class AssignmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    任务id
    private Long aid;

    //    是否达标
    private int isCompleted;

    //    任务描述
    private String description;

    @ManyToOne
    private MemberInfo memberInfo;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final StringBuffer sb = new StringBuffer("AssignmentInfo{");
        sb.append("aid=").append(aid);
        sb.append(", isCompleted=").append(isCompleted);
        sb.append(", description='").append(description).append('\'');
        sb.append(", memberInfo=").append(memberInfo);
        sb.append('}');
        return sb.toString();
    }
}
