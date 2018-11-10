package com.manito.bill.service.eightServenLottery;

import com.manito.bill.entry.eightSevenLottery.QueryRecommendOptQuery;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;

public interface LotteryRecommendService {
    LotteryRecommendOrders postLotteryRecommendOrders(QueryRecommendOptQuery queryRecommendOptQuery);
}
