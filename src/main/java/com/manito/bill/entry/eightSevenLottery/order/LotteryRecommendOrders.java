package com.manito.bill.entry.eightSevenLottery.order;

import java.util.List;

public class LotteryRecommendOrders {
    private int count;
    private List<RecommendList> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RecommendList> getData() {
        return data;
    }

    public void setData(List<RecommendList> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LotteryRecommendOrders{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }
}
