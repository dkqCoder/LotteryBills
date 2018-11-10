package com.manito.bill.entry.eightSevenLottery;

public class QueryRecommendOptQuery extends QueryBaseOpt {
    private String desc;
    private Integer pageNo;
    private Integer pageSize;
    private String rForm;
    private String sid;
    private String token;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getrForm() {
        return rForm;
    }

    public void setrForm(String rForm) {
        this.rForm = rForm;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
