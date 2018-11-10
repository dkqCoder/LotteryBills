package com.manito.bill.controller.eightSevenLottery;

import com.manito.bill.entry.eightSevenLottery.QueryRecommendOptQuery;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.service.eightServenLottery.LotteryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eightSeven/lottery")
public class LotteryRecommendController {

    @Autowired
    private LotteryRecommendService lotteryRecommendService;

    @RequestMapping("/getRecommendList")
    public LotteryRecommendOrders getLotteryRecommend() {
        LotteryRecommendOrders lotteryRecommendOrders = null;
        try {
            QueryRecommendOptQuery query = new QueryRecommendOptQuery();
            query.setPageSize(200);
            query.setAppVersion("2.0.0");
            query.setPageNo(1);
            query.setAppPlatform("1");
            query.setUmengchannel("iOS");
            query.setSid("3345046");
            query.setToken("9C289DDBC7DAF602713E99765A08DC5A");
            query.setrForm("2");
            query.setDesc("1");
            query.setAppType("iOS");

            lotteryRecommendOrders = lotteryRecommendService.postLotteryRecommendOrders(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lotteryRecommendOrders;
    }
}
