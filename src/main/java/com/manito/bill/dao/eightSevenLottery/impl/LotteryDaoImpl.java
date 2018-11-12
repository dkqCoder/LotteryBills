package com.manito.bill.dao.eightSevenLottery.impl;

import com.manito.bill.dao.eightSevenLottery.LotteryDao;
import com.manito.bill.entry.eightSevenLottery.order.Recommends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class LotteryDaoImpl implements LotteryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveRecommendListData(Recommends recommends, String lotteryAppKey) {
        StringBuilder sql = new StringBuilder(" INSERT INTO recommeds (bet_id,recommended_user_id,recommended_user,bet_amount,bet_model,declaration,followNumber,sp_value,stop_follow_date) " +
                " VALUE(?,?,?,?,?,?,?,?,?)");
        sql.append(" on duplicate key update followNumber = ")
                .append(recommends.getFollowNumber());
        int resRow = jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1,recommends.getBetId());
                ps.setLong(2,recommends.getRecommendedUserId());
                ps.setString(3,recommends.getRecommendedUser());
                ps.setLong(4,recommends.getBetAmount());
                ps.setString(5,recommends.getBetMode());
                ps.setString(6,recommends.getDeclaration());
                ps.setInt(7,recommends.getFollowNumber());
                ps.setDouble(8,recommends.getSpValue());
                ps.setString(9,recommends.getStopFollowDate());
            }
        });
        return resRow;
    }
}
