package com.manito.bill.controller.eightSevenLottery;

import com.manito.bill.dao.eightSevenLottery.LotteryDao;
import com.manito.bill.dao.eightSevenLottery.UserDao;
import com.manito.bill.dao.eightSevenLottery.pojo.LotteryRecommendDetail;
import com.manito.bill.dao.eightSevenLottery.pojo.LotteryUserInfo;
import com.manito.bill.entry.eightSevenLottery.QueryOrderDetailOpt;
import com.manito.bill.entry.eightSevenLottery.QueryProgrammOpt;
import com.manito.bill.entry.eightSevenLottery.QueryRecommendOpt;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommendOrders;
import com.manito.bill.entry.eightSevenLottery.order.detail.OrderDetail;
import com.manito.bill.entry.eightSevenLottery.programme.ProgrammeInfo;
import com.manito.bill.service.eightServenLottery.LotteryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eightSeven/lottery")
public class LotteryRecommendController {

    @Autowired
    private LotteryRecommendService lotteryRecommendService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LotteryDao lotteryDao;

    @RequestMapping("/getRecommendList")
    public LotteryRecommendOrders getLotteryRecommend() {
        LotteryRecommendOrders lotteryRecommendOrders = null;
        try {
            QueryRecommendOpt query = new QueryRecommendOpt();
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

    @RequestMapping("/getLotteryOrderDetail")
    public List<OrderDetail>  getLotteryOrderDetail(){
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            List<LotteryRecommendDetail> lotteryRecommendDetails = lotteryDao.getLotteryRecommends("87");
            List<LotteryUserInfo> lotteryUserInfos = userDao.getToken("87");

            LotteryUserInfo lotteryUserInfo = lotteryUserInfos.get(0);
            for (LotteryRecommendDetail lotteryRecommendDetail : lotteryRecommendDetails) {
                QueryOrderDetailOpt queryOrderDetailOpt = new QueryOrderDetailOpt();
                queryOrderDetailOpt.setOrderId(lotteryRecommendDetail.getBetId().toString());
                queryOrderDetailOpt.setSid(lotteryUserInfo.getN_user_id().toString());
                queryOrderDetailOpt.setAppVersion(lotteryUserInfo.getN_lottery_app());
                queryOrderDetailOpt.setToken(lotteryUserInfo.getN_token());
                queryOrderDetailOpt.setUmengchannel("iOS");
                queryOrderDetailOpt.setAppType("iOS");
                queryOrderDetailOpt.setAppPlatform("1");
                try {
                    Thread.sleep(250);
                    OrderDetail orderDetail = lotteryRecommendService.postLotteryOrderDetail(queryOrderDetailOpt);
                    orderDetails.add(orderDetail);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @RequestMapping("/getLotteryProgremmes")
    public List<ProgrammeInfo> getProgrammeInfo(){
        List<ProgrammeInfo> programmeInfos = new ArrayList<>();
        try {
            QueryProgrammOpt queryProgrammOpt = new QueryProgrammOpt();
            queryProgrammOpt.setPageSize(250);
            queryProgrammOpt.setPageNo(1);
            queryProgrammOpt.setAppVersion("2.0.0");
            queryProgrammOpt.setUmengchannel("iOS");
            queryProgrammOpt.setSid("3345046");
            queryProgrammOpt.setToken("9C289DDBC7DAF602713E99765A08DC5A");
            queryProgrammOpt.setAppType("iOS");
            queryProgrammOpt.setType("2");
            queryProgrammOpt.setAppPlatform("1");
            programmeInfos = lotteryRecommendService.postLotteryProgrammInfo(queryProgrammOpt).getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programmeInfos;

    }
}
