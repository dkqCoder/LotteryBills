package com.manito.bill.controller.eightSevenLottery;

import com.manito.bill.entry.eightSevenLottery.LoginOptQuery;
import com.manito.bill.entry.eightSevenLottery.user.UserEntry;
import com.manito.bill.service.eightServenLottery.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eightSeven/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/addUser")
    public UserEntry getListUser() {
        UserEntry userEntrie = null;
        try {
            LoginOptQuery loginOpt = new LoginOptQuery();
            loginOpt.setType("1");
            loginOpt.setAppVersion("2.0.0");
            loginOpt.setCredential("3a5e140a595179c6ef74966b11a3f630");
            loginOpt.setIdentity("红火炎焱燚");
            loginOpt.setAppType("iOS");
            loginOpt.setUmengchannel("iOS");
            loginOpt.setAppPlatform("1");
            userEntrie = loginService.getUserInfo(loginOpt,"87");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntrie;
    }
}
