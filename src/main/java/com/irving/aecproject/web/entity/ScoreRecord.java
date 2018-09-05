package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SicScoreRecord")
public class ScoreRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ScoreRecordID;

    @ManyToOne(optional = false)
    private MemberInfo memberInfo;

    private String operator;

    private Integer amount;

    private String content;

    @Temporal(TemporalType.DATE)
    private Date operateTime;


    public Long getScoreRecordID() {
        return ScoreRecordID;
    }

    public void setScoreRecordID(Long scoreRecordID) {
        this.ScoreRecordID = scoreRecordID;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    @JsonBackReference
    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ScoreRecord{");
        sb.append("ScoreRecordID=").append(ScoreRecordID);
        sb.append(", memberInfo=").append(memberInfo);
        sb.append(", operator='").append(operator).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", content='").append(content).append('\'');
        sb.append(", operateTime=").append(operateTime);
        sb.append('}');
        return sb.toString();
    }

}