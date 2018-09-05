package com.irving.aecproject.web.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SicAssignmentInfo")
public class AssignmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    任务id
    private Long AssignmentInfoID;

    //    是否达标
    private int isCompleted;

    //    任务描述
    private String description;

    @ManyToMany(mappedBy = "assignmentInfos")
    private Set<MemberInfo> memberInfos;

    public Long getAssignmentInfoID() {
        return AssignmentInfoID;
    }

    public void setAssignmentInfoID(Long assignmentInfoID) {
        this.AssignmentInfoID = assignmentInfoID;
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

    public Set<MemberInfo> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(Set<MemberInfo> memberInfos) {
        this.memberInfos = memberInfos;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AssignmentInfo{");
        sb.append("AssignmentInfoID=").append(AssignmentInfoID);
        sb.append(", isCompleted=").append(isCompleted);
        sb.append(", description='").append(description).append('\'');
        sb.append(", memberInfos=").append(memberInfos);
        sb.append('}');
        return sb.toString();
    }
}
