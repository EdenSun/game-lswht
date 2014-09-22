package com.gofaner.game.lswht.model;

public class ExchangeCode {
    private Integer id;

    private String code;

    private String password;

    private Integer status;

    private Integer ownerId;

    private String ownerIp;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerIp() {
        return ownerIp;
    }

    public void setOwnerIp(String ownerIp) {
        this.ownerIp = ownerIp == null ? null : ownerIp.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}