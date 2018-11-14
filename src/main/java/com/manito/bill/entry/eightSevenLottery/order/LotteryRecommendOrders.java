package com.manito.bill.entry.eightSevenLottery.order;

import java.util.List;

public class LotteryRecommendOrders {
    private int count;
    private List<LotteryRecommends> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<LotteryRecommends> getData() {
        return data;
    }

    public void setData(List<LotteryRecommends> data) {
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
