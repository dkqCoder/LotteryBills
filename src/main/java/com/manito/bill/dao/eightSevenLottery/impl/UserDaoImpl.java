package com.manito.bill.dao.eightSevenLottery.impl;

import com.manito.bill.dao.eightSevenLottery.UserDao;
import com.manito.bill.dao.eightSevenLottery.pojo.LotteryUserInfo;
import com.manito.bill.entry.eightSevenLottery.user.UserInfoEntry;
import com.manito.bill.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveUser(UserInfoEntry userInfoEntry,String lotteryAppKey) {
        StringBuilder sql = new StringBuilder(" INSERT INTO user (n_user_id,n_user_name,n_token,n_lottery_app,n_insert_time) " +
                "VALUE (?,?,?,?,?)");
        sql.append(" on duplicate key update n_token = ")
                .append("'")
                .append(userInfoEntry.getData())
                .append("' ,")
                .append(" n_insert_time = ")
                .append("'")
                .append(DateUtils.getNowTime())
                .append("'");
        int resRow = jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,userInfoEntry.getUserId());
                ps.setString(2,userInfoEntry.getUsername());
                ps.setString(3,userInfoEntry.getData());
                ps.setString(4,lotteryAppKey);
                ps.setString(5, DateUtils.getNowTime());
            }
        });

        return resRow;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LotteryUserInfo> getToken(String lotteryApp) {
        StringBuilder sql = new StringBuilder(" SELECT n_id,n_user_id,n_user_name,n_token,n_lottery_app,n_insert_time,n_update_time " +
                " FROM user where n_lottery_app =?");
        List<LotteryUserInfo> lotteryUserInfoList = jdbcTemplate.query(sql.toString(),new Object[]{lotteryApp},new UserRowMapper());
        return lotteryUserInfoList;
    }

    class UserRowMapper implements RowMapper<LotteryUserInfo> {

        @Override
        public LotteryUserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
            LotteryUserInfo lotteryUserInfo = new LotteryUserInfo();
            lotteryUserInfo.setN_id(resultSet.getInt("n_id"));
            lotteryUserInfo.setN_user_name(resultSet.getString("n_user_name"));
            lotteryUserInfo.setN_token(resultSet.getString("n_token"));
            lotteryUserInfo.setN_lottery_app(resultSet.getString("n_lottery_app"));
            lotteryUserInfo.setN_insert_time(resultSet.getString("n_insert_time"));
            lotteryUserInfo.setN_update_tiem(resultSet.getString("n_update_time"));
            return lotteryUserInfo;
        }
    }
}
