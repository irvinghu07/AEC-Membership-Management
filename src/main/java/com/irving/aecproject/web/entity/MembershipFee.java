package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "SicMembershipFee")
public class MembershipFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Mfid;

    @ManyToOne(optional = false)
    private MemberInfo memberInfo;

    @Temporal(TemporalType.DATE)
    private Date createTime;

    //    时间 e.g: 2018-2019;
    private String descriptionForDuration;

    public Long getMfid() {
        return Mfid;
    }

    public void setMfid(Long mfid) {
        Mfid = mfid;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    @JsonBackReference
    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescriptionForDuration() {
        return descriptionForDuration;
    }

    public void setDescriptionForDuration(String descriptionForDuration) {
        this.descriptionForDuration = descriptionForDuration;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MembershipFee{");
        sb.append("Mfid=").append(Mfid);
        sb.append(", memberInfo=").append(memberInfo);
        sb.append(", createTime=").append(createTime);
        sb.append(", descriptionForDuration='").append(descriptionForDuration).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
