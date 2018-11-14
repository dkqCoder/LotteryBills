package com.manito.bill.dao.eightSevenLottery.impl;

import com.manito.bill.dao.eightSevenLottery.LotteryDao;
import com.manito.bill.dao.eightSevenLottery.pojo.LotteryRecommendDetail;
import com.manito.bill.entry.eightSevenLottery.order.LotteryRecommends;
import com.manito.bill.entry.eightSevenLottery.order.detail.Match;
import com.manito.bill.utils.DateUtils;
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
public class LotteryDaoImpl implements LotteryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveRecommendListData(LotteryRecommends lotteryRecommends, String lotteryAppKey) {
        StringBuilder sql = new StringBuilder(" INSERT INTO recommeds (bet_id,recommended_user_id,recommended_user,bet_amount,bet_model,declaration,followNumber,sp_value,stop_follow_date,lottery_app_key,p_day) " +
                " VALUE(?,?,?,?,?,?,?,?,?,?,?)");
        sql.append(" on duplicate key update followNumber = ")
                .append(lotteryRecommends.getFollowNumber());
        int resRow = jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, lotteryRecommends.getBetId());
                ps.setLong(2, lotteryRecommends.getRecommendedUserId());
                ps.setString(3, lotteryRecommends.getRecommendedUser());
                ps.setLong(4, lotteryRecommends.getBetAmount());
                ps.setString(5, lotteryRecommends.getBetMode());
                ps.setString(6, lotteryRecommends.getDeclaration());
                ps.setInt(7, lotteryRecommends.getFollowNumber());
                ps.setDouble(8, lotteryRecommends.getSpValue());
                ps.setString(9, lotteryRecommends.getStopFollowDate());
                ps.setString(10,lotteryAppKey);
                ps.setString(11, DateUtils.getTodayDate());
            }
        });
        return resRow;
    }

    @Override
    public Integer saveOrderDetailData(Long orderId, String recommendUser, Match match, String lotteryAppKey) {
        StringBuilder sql = new StringBuilder(" INSERT INTO orderdetail (n_order_id,n_recommend_user,n_rac,n_day,n_time,n_leaguename,n_hostname,n_guestname,n_halfscore,n_fullscore,n_dan,n_codes,n_lottery_app_key,n_p_day) " +
                " VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
        sql.append(" on duplicate key update n_codes = '")
                .append(match.getCodes().toString())
                .append("'");
        int resRow = jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1,orderId);
                ps.setString(2,recommendUser);
                ps.setString(3,match.getRace());
                ps.setString(4,match.getDay());
                ps.setString(5,match.getTime());
                ps.setString(6,match.getLeaguename());
                ps.setString(7,match.getHostname());
                ps.setString(8,match.getGuestname());
                ps.setString(9,match.getHalfscore());
                ps.setString(10,match.getFullscore());
                ps.setString(11,match.getDan());
                ps.setString(12,match.getCodes().toString());
                ps.setString(13,lotteryAppKey);
                ps.setString(14,DateUtils.getTodayDate());
            }
        });
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LotteryRecommendDetail> getLotteryRecommends(String appKey) {
        StringBuilder sql = new StringBuilder(" select bet_id FROM recommeds where lottery_app_key ='" + appKey + "' and p_day = '" + DateUtils.getTodayDate()+"'");
        List<LotteryRecommendDetail> lotteryRecommendDetails = jdbcTemplate.query(sql.toString(),new UserRowMapper());
        return lotteryRecommendDetails;
    }

    class UserRowMapper implements RowMapper<LotteryRecommendDetail> {

        @Override
        public LotteryRecommendDetail mapRow(ResultSet resultSet, int i) throws SQLException {
            LotteryRecommendDetail lotteryRecommendDetail = new LotteryRecommendDetail();
            lotteryRecommendDetail.setBetId(resultSet.getLong("bet_id"));
            return lotteryRecommendDetail;
        }
    }
}
