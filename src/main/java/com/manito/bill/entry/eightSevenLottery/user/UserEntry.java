package com.manito.bill.entry.eightSevenLottery.user;

public class UserEntry {
    private UserInfoEntry data;
    private String message;
    private String secretKey;
    private String status;
    private String timestamp;

    public UserInfoEntry getData() {
        return data;
    }

    public void setData(UserInfoEntry data) {
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

    @Override
    public String toString() {
        return "UserEntry{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
