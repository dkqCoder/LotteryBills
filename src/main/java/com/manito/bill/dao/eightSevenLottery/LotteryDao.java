package com.manito.bill.dao.eightSevenLottery;

import com.manito.bill.dao.eightSevenLottery.pojo.LotteryRecommendDetail;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommends;
import com.manito.bill.entry.eightSevenLottery.order.detail.Match;

import java.util.List;

public interface LotteryDao {
    Integer saveRecommendListData(LotteryRecommends recommeRecommendsndList, String lotteryAppKey);

    Integer saveOrderDetailData(Long orderId, String recommendUser, Match match, String lotteryAppKey);

    List<LotteryRecommendDetail> getLotteryRecommends(String appKey);
}
