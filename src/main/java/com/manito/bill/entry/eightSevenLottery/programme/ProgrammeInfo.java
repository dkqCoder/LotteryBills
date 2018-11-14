package com.manito.bill.entry.eightSevenLottery.programme;

public class ProgrammeInfo {
    private String planId;
    private String planDescription;
    private Integer clickRete;
    private Integer expertId;
    private String expertName;
    private ProgrammeMatchInfo matchinfo;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public Integer getClickRete() {
        return clickRete;
    }

    public void setClickRete(Integer clickRete) {
        this.clickRete = clickRete;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public ProgrammeMatchInfo getMatchinfo() {
        return matchinfo;
    }

    public void setMatchinfo(ProgrammeMatchInfo matchinfo) {
        this.matchinfo = matchinfo;
    }
}
