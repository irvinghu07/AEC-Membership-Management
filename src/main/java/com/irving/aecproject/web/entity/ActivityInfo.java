package com.irving.aecproject.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SicActivityInfo")
public class ActivityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Activity ID
    private Long ActivityInfoID;

    //    Activity Name
    private String activityName;

    @ManyToMany(mappedBy = "participatedActivities")
    //    members who attended to this activity
    private Set<MemberInfo> participants;

    @OneToMany(mappedBy = "activityInfo", cascade = CascadeType.ALL)
//    grade for this activity
    private Set<ActivityGrade> activityGrades;

    public Long getActivityInfoID() {
        return ActivityInfoID;
    }

    public void setActivityInfoID(Long activityInfoID) {
        this.ActivityInfoID = activityInfoID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Set<MemberInfo> getParticipants() {
        return participants;
    }

    @JsonBackReference
    public void setParticipants(Set<MemberInfo> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActivityInfo{");
        sb.append("ActivityInfoID=").append(ActivityInfoID);
        sb.append(", activityName='").append(activityName).append('\'');
        sb.append(", participants=").append(participants);
        sb.append('}');
        return sb.toString();
    }
}
