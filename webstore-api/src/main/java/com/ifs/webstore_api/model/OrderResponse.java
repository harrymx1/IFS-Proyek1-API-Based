package com.ifs.webstore_api.model;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderId;
    private String status;
    private String paymentUrl;
    private String message;
}