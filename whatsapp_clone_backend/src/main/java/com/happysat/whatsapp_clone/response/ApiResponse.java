package com.happysat.whatsapp_clone.response;

public class ApiResponse {

    private String message;
    private boolean status;

    public ApiResponse(String message, boolean status) {
        this.status = status;
        this.message = message;
    }
}
