package com.manito.bill.service.eightServenLottery;

import com.manito.bill.entry.eightSevenLottery.LoginOptQuery;
import com.manito.bill.entry.eightSevenLottery.user.UserEntry;

public interface LoginService {
    UserEntry getUserInfo(LoginOptQuery loginOpt, String lotteryAppKey);
}
