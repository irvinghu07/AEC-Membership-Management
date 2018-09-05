package com.irving.aecproject.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "SicActivityGrade")
public class ActivityGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agid;

    private Long mid;

    private Long acid;

    private String comment;

    private Integer grade;
}
