package com.irving.aecproject.web.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SicActivityInfo")
public class ActivityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acid;

    private String activityName;

//    Todo
    private List<MemberInfo> participant;


}
