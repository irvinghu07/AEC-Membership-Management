package com.irving.aecproject.entity;

public class MemberInfo {
    private String memberid;

    private String memberpwd;

    private String cnname;

    private String egname;

    private String wechatname;

    private String wechatid;

    private Integer memberscore;

    private Integer active;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getMemberpwd() {
        return memberpwd;
    }

    public void setMemberpwd(String memberpwd) {
        this.memberpwd = memberpwd == null ? null : memberpwd.trim();
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public String getEgname() {
        return egname;
    }

    public void setEgname(String egname) {
        this.egname = egname == null ? null : egname.trim();
    }

    public String getWechatname() {
        return wechatname;
    }

    public void setWechatname(String wechatname) {
        this.wechatname = wechatname == null ? null : wechatname.trim();
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid == null ? null : wechatid.trim();
    }

    public Integer getMemberscore() {
        return memberscore;
    }

    public void setMemberscore(Integer memberscore) {
        this.memberscore = memberscore;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}