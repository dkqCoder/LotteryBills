package com.manito.bill.entry.eightSevenLottery.order;

public class RecommendOrderReponse {
    private LotteryRecommendOrders data;
    private String message;
    private String secretKey;
    private String status;
    private String timestamp;

    public LotteryRecommendOrders getData() {
        return data;
    }

    public void setData(LotteryRecommendOrders data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}