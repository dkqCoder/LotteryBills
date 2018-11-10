package com.manito.bill.service.eightServenLottery.impl;

import com.manito.bill.common.Constants;
import com.manito.bill.dao.eightSevenLottery.UserDao;
import com.manito.bill.entry.eightSevenLottery.LoginEntry;
import com.manito.bill.entry.eightSevenLottery.user.UserEntry;
import com.manito.bill.service.eightServenLottery.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{

    private final static String loginUrl = Constants.LOTTERY87LOGINURL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntry getUserInfo(LoginEntry loginEntry,String lotteryAppKey) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Content-Type","application/json");
        UserEntry userEntryPost = restTemplate.postForObject(loginUrl,loginEntry,UserEntry.class);
        userDao.saveUser(userEntryPost.getData(),"87");
        return userEntryPost;
    }

}
