package com.manito.bill.dao.eightSevenLottery;

import com.manito.bill.dao.eightSevenLottery.pojo.LotteryUserInfo;
import com.manito.bill.entry.eightSevenLottery.user.UserInfoEntry;

import java.util.List;

public interface UserDao {

    Integer saveUser(UserInfoEntry userInfoEntry,String lotteryAppKey);

    List<LotteryUserInfo> getToken(String lotteryApp);
}
