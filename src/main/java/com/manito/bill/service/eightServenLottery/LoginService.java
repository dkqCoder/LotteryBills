package com.manito.bill.service.eightServenLottery;

import com.manito.bill.entry.eightSevenLottery.LoginEntry;
import com.manito.bill.entry.eightSevenLottery.user.UserEntry;

public interface LoginService {
    UserEntry getUserInfo(LoginEntry loginEntry,String lotteryAppKey);
}
