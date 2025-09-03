package com.happysat.whatsapp_clone.request;

public class SingleChatRequest {

    private Integer userId;

    public SingleChatRequest() {
    }

    public SingleChatRequest(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
