package com.manito.bill.entry.eightSevenLottery.order;

public class LotteryRecommendOrders {
    private int count;
    private RecommendList data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RecommendList getData() {
        return data;
    }

    public void setData(RecommendList data) {
        this.data = data;
    }
}

class RecommendList {
    private Long betId; // 订单id
    private Long recommendedUserId;
    private String recommendUserName;
    private Long betAmount;
    private String betMode;
    private String declaration;
    private Integer followNumber;
    private Double spValue;
    private String stopFollowDate;

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getRecommendedUserId() {
        return recommendedUserId;
    }

    public void setRecommendedUserId(Long recommendedUserId) {
        this.recommendedUserId = recommendedUserId;
    }

    public String getRecommendUserName() {
        return recommendUserName;
    }

    public void setRecommendUserName(String recommendUserName) {
        this.recommendUserName = recommendUserName;
    }

    public Long getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Long betAmount) {
        this.betAmount = betAmount;
    }

    public String getBetMode() {
        return betMode;
    }

    public void setBetMode(String betMode) {
        this.betMode = betMode;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public Double getSpValue() {
        return spValue;
    }

    public void setSpValue(Double spValue) {
        this.spValue = spValue;
    }

    public String getStopFollowDate() {
        return stopFollowDate;
    }

    public void setStopFollowDate(String stopFollowDate) {
        this.stopFollowDate = stopFollowDate;
    }
}
