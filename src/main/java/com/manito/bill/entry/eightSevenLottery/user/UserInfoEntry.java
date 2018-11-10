package com.manito.bill.entry.eightSevenLottery.user;

public class UserInfoEntry {
    private String data;
    private String headicon;
    private String niname;
    private String rcuserid;
    private String registType;
    private String slwId;
    private String slwName;
    private String timesTamp;
    private String userId;
    private String username;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
    }

    public String getNiname() {
        return niname;
    }

    public void setNiname(String niname) {
        this.niname = niname;
    }

    public String getRcuserid() {
        return rcuserid;
    }

    public void setRcuserid(String rcuserid) {
        this.rcuserid = rcuserid;
    }

    public String getRegistType() {
        return registType;
    }

    public void setRegistType(String registType) {
        this.registType = registType;
    }

    public String getSlwId() {
        return slwId;
    }

    public void setSlwId(String slwId) {
        this.slwId = slwId;
    }

    public String getSlwName() {
        return slwName;
    }

    public void setSlwName(String slwName) {
        this.slwName = slwName;
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfoEntry{" +
                "data='" + data + '\'' +
                ", headicon='" + headicon + '\'' +
                ", niname='" + niname + '\'' +
                ", rcuserid='" + rcuserid + '\'' +
                ", registType='" + registType + '\'' +
                ", slwId='" + slwId + '\'' +
                ", slwName='" + slwName + '\'' +
                ", timesTamp='" + timesTamp + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
