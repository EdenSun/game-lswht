package com.gofaner.game.lswht.model;

import java.util.Date;

public class User {
    private Integer id;

    private String account;

    private String mobile;

    private Integer playTimes;

    private Date createTime;

    private String wechatAccessToken;

    private String loginToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(Integer playTimes) {
        this.playTimes = playTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWechatAccessToken() {
        return wechatAccessToken;
    }

    public void setWechatAccessToken(String wechatAccessToken) {
        this.wechatAccessToken = wechatAccessToken == null ? null : wechatAccessToken.trim();
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }
}