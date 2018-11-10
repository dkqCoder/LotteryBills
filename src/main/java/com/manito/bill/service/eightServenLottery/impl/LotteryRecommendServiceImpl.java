package com.manito.bill.service.eightServenLottery.impl;

import com.manito.bill.common.Constants;
import com.manito.bill.entry.eightSevenLottery.QueryRecommendOptQuery;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.entry.eightSevenLottery.order.RecommendOrderReponse;
import com.manito.bill.service.eightServenLottery.LotteryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LotteryRecommendServiceImpl implements LotteryRecommendService {
    private final static String url = Constants.LOTTERY87RECOMMENDLISTURL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public LotteryRecommendOrders postLotteryRecommendOrders(QueryRecommendOptQuery queryRecommendOptQuery) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        RecommendOrderReponse recommendOrderReponse = restTemplate.postForObject(url,queryRecommendOptQuery,RecommendOrderReponse.class);
        return recommendOrderReponse.getData();
    }
}
