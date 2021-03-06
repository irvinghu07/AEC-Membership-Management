package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "SicActivityGrade")
public class ActivityGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    activity grade ID
    private Long ActivityGradeID;

    @ManyToOne(optional = false)
    private ActivityInfo activityInfo;

    private String comment;

    private Integer grade;

    public Long getActivityGradeID() {
        return ActivityGradeID;
    }

    public void setActivityGradeID(Long activityGradeID) {
        this.ActivityGradeID = activityGradeID;
    }

    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }

    @JsonBackReference
    public void setActivityInfo(ActivityInfo activityInfo) {
        this.activityInfo = activityInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActivityGrade{");
        sb.append("ActivityGradeID=").append(ActivityGradeID);
        sb.append(", activityInfo=").append(activityInfo);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }
}
