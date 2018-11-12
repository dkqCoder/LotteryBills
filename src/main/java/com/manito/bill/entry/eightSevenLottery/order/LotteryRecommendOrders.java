package com.manito.bill.entry.eightSevenLottery.order;

import java.util.List;

public class LotteryRecommendOrders {
    private int count;
    private List<Recommends> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recommends> getData() {
        return data;
    }

    public void setData(List<Recommends> data) {
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
