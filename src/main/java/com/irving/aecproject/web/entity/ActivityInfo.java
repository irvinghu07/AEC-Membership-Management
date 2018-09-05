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
    private Long acid;

    //    Activity Name
    private String activityName;

    @ManyToMany
    //    members who attended to this activity
    private Set<MemberInfo> participant;

    @OneToMany(mappedBy = "activityInfo", cascade = CascadeType.ALL)
//    grade for this activity
    private Set<ActivityGrade> activityGrades;

    public Long getAcid() {
        return acid;
    }

    public void setAcid(Long acid) {
        this.acid = acid;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Set<MemberInfo> getParticipant() {
        return participant;
    }

    @JsonBackReference
    public void setParticipant(Set<MemberInfo> participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActivityInfo{");
        sb.append("acid=").append(acid);
        sb.append(", activityName='").append(activityName).append('\'');
        sb.append(", participant=").append(participant);
        sb.append('}');
        return sb.toString();
    }
}
