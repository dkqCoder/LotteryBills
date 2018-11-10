package com.manito.bill.controller.eightSevenLottery;

import com.manito.bill.entry.eightSevenLottery.LoginEntry;
import com.manito.bill.entry.eightSevenLottery.user.UserEntry;
import com.manito.bill.service.eightServenLottery.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eightSeven/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/addUser")
    public UserEntry getListUser() {
        UserEntry userEntrie = null;
        try {
            LoginEntry loginEntry = new LoginEntry();
            loginEntry.setType("1");
            loginEntry.setAppVersion("2.0.0");
            loginEntry.setCredential("3a5e140a595179c6ef74966b11a3f630");
            loginEntry.setIdentity("红火炎焱燚");
            loginEntry.setAppType("iOS");
            loginEntry.setUmengchannel("iOS");
            loginEntry.setAppLatform("1");
            userEntrie = loginService.getUserInfo(loginEntry,"87");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntrie;
    }
}
