package com.manito.bill.service.eightServenLottery.impl;

import com.manito.bill.common.Constants;
import com.manito.bill.dao.eightSevenLottery.LotteryDao;
import com.manito.bill.entry.eightSevenLottery.QueryOrderDetailOpt;
import com.manito.bill.entry.eightSevenLottery.QueryProgrammOpt;
import com.manito.bill.entry.eightSevenLottery.QueryRecommendOpt;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.entry.eightSevenLottery.order.RecommendOrderReponse;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommends;
import com.manito.bill.entry.eightSevenLottery.order.detail.Match;
import com.manito.bill.entry.eightSevenLottery.order.detail.OrderDetail;
import com.manito.bill.entry.eightSevenLottery.order.detail.ReponseOrderDetail;
import com.manito.bill.entry.eightSevenLottery.programme.ProGrammeData;
import com.manito.bill.entry.eightSevenLottery.programme.ProgrammeInfo;
import com.manito.bill.entry.eightSevenLottery.programme.ProgrammeMatchInfo;
import com.manito.bill.service.eightServenLottery.LotteryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LotteryRecommendServiceImpl implements LotteryRecommendService {
    private final static String url = Constants.LOTTERY87RECOMMENDLISTURL;
    private final static String orderUrl = Constants.LOTTERY87ORDERDETAIL;
    private final static String programmeUrl = Constants.LOTTERY87PROGRAMME;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LotteryDao lotteryDao;

    @Override
    public LotteryRecommendOrders postLotteryRecommendOrders(QueryRecommendOpt queryRecommendOpt) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        RecommendOrderReponse recommendOrderReponse = restTemplate.postForObject(url, queryRecommendOpt,RecommendOrderReponse.class);
        List<LotteryRecommends> recommends = recommendOrderReponse.getData().getData();
        for (LotteryRecommends rec : recommends) {
            lotteryDao.saveRecommendListData(rec,"87");
        }
        return recommendOrderReponse.getData();
    }

    @Override
    public OrderDetail postLotteryOrderDetail(QueryOrderDetailOpt queryOrderDetailOpt) {
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        ReponseOrderDetail reponseOrderDetail = restTemplate.postForObject(orderUrl,queryOrderDetailOpt,ReponseOrderDetail.class);
        List<Match> matchList = reponseOrderDetail.getData().getMatch();
        for (Match match : matchList) {
            lotteryDao.saveOrderDetailData(reponseOrderDetail.getData().getId(),reponseOrderDetail.getData().getRecommendedUser(),match,"87");
        }
        return reponseOrderDetail.getData();
    }

    @Override
    public ProGrammeData postLotteryProgrammInfo(QueryProgrammOpt queryProgrammOpt) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        ProGrammeData proGrammeData = restTemplate.postForObject(programmeUrl,queryProgrammOpt,ProGrammeData.class);
        List<ProgrammeInfo> matchInfoList = proGrammeData.getData();
        return proGrammeData;
    }


    class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
         WxMappingJackson2HttpMessageConverter(){
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.TEXT_PLAIN);
            mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);  //加入text/html类型的支持
            setSupportedMediaTypes(mediaTypes);// tag6
        }
    }

}
