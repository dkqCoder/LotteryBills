package com.manito.bill.dao.eightSevenLottery.pojo;

public class LotteryUserInfo {
    private Long n_user_id;
    private String n_user_name;
    private String n_token;
    private String n_lottery_app;
    private String n_insert_time;
    private String n_update_tiem;


    public Long getN_user_id() {
        return n_user_id;
    }

    public void setN_user_id(Long n_user_id) {
        this.n_user_id = n_user_id;
    }

    public String getN_user_name() {
        return n_user_name;
    }

    public void setN_user_name(String n_user_name) {
        this.n_user_name = n_user_name;
    }

    public String getN_token() {
        return n_token;
    }

    public void setN_token(String n_token) {
        this.n_token = n_token;
    }

    public String getN_lottery_app() {
        return n_lottery_app;
    }

    public void setN_lottery_app(String n_lottery_app) {
        this.n_lottery_app = n_lottery_app;
    }

    public String getN_insert_time() {
        return n_insert_time;
    }

    public void setN_insert_time(String n_insert_time) {
        this.n_insert_time = n_insert_time;
    }

    public String getN_update_tiem() {
        return n_update_tiem;
    }

    public void setN_update_tiem(String n_update_tiem) {
        this.n_update_tiem = n_update_tiem;
    }

    @Override
    public String toString() {
        return "LotteryUserInfo{" +
                ", n_user_id=" + n_user_id +
                ", n_user_name='" + n_user_name + '\'' +
                ", n_token='" + n_token + '\'' +
                ", n_lottery_app='" + n_lottery_app + '\'' +
                ", n_insert_time='" + n_insert_time + '\'' +
                ", n_update_tiem='" + n_update_tiem + '\'' +
                '}';
    }
}
