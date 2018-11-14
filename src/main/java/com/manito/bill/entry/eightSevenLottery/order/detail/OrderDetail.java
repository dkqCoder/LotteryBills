package com.manito.bill.entry.eightSevenLottery.order.detail;

import java.util.List;

public class OrderDetail {
    private String recommendedUser;
    private Long id;
    private List<Match> match;

    public String getRecommendedUser() {
        return recommendedUser;
    }

    public void setRecommendedUser(String recommendedUser) {
        this.recommendedUser = recommendedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "recommendedUser='" + recommendedUser + '\'' +
                ", id=" + id +
                ", match=" + match +
                '}';
    }
}
