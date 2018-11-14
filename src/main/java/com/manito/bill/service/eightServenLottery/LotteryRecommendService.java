package com.manito.bill.service.eightServenLottery;

import com.manito.bill.entry.eightSevenLottery.QueryOrderDetailOpt;
import com.manito.bill.entry.eightSevenLottery.QueryProgrammOpt;
import com.manito.bill.entry.eightSevenLottery.QueryRecommendOpt;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.entry.eightSevenLottery.order.detail.OrderDetail;
import com.manito.bill.entry.eightSevenLottery.programme.ProGrammeData;
import com.manito.bill.entry.eightSevenLottery.programme.ProgrammeInfo;

public interface LotteryRecommendService {
    LotteryRecommendOrders postLotteryRecommendOrders(QueryRecommendOpt queryRecommendOpt);

    OrderDetail postLotteryOrderDetail(QueryOrderDetailOpt queryOrderDetailOpt);

    ProGrammeData postLotteryProgrammInfo(QueryProgrammOpt queryProgrammOpt);
}
