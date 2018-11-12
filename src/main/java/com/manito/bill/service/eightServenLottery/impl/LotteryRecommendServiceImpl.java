package com.manito.bill.service.eightServenLottery.impl;

import com.manito.bill.common.Constants;
import com.manito.bill.dao.eightSevenLottery.LotteryDao;
import com.manito.bill.entry.eightSevenLottery.QueryRecommendOptQuery;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.entry.eightSevenLottery.order.RecommendOrderReponse;
import com.manito.bill.entry.eightSevenLottery.order.Recommends;
import com.manito.bill.service.eightServenLottery.LotteryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LotteryRecommendServiceImpl implements LotteryRecommendService {
    private final static String url = Constants.LOTTERY87RECOMMENDLISTURL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LotteryDao lotteryDao;

    @Override
    public LotteryRecommendOrders postLotteryRecommendOrders(QueryRecommendOptQuery queryRecommendOptQuery) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        RecommendOrderReponse recommendOrderReponse = restTemplate.postForObject(url,queryRecommendOptQuery,RecommendOrderReponse.class);
        List<Recommends> recommends = recommendOrderReponse.getData().getData();
        for (Recommends rec : recommends) {
            lotteryDao.saveRecommendListData(rec,"87");
        }
        return recommendOrderReponse.getData();
    }
}
