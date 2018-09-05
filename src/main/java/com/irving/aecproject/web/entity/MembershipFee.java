package com.irving.aecproject.web.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SicMembershipFee")
public class MembershipFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Mfid;

    private Long mid;

    @Temporal(TemporalType.DATE)
    private Date createTime;

    //    时间 e.g: 2018-2019;
    private String descriptionForDuration;

}
