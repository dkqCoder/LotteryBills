package com.manito.bill.entry.eightSevenLottery.programme;

import java.util.List;

public class ProGrammeData {
    private String status;
    private String message;
    private String timestamp;
    private String secretKey;
    private List<ProgrammeInfo> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public List<ProgrammeInfo> getData() {
        return data;
    }

    public void setData(List<ProgrammeInfo> data) {
        this.data = data;
    }
}
