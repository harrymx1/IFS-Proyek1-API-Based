package com.ifs.payment_api.model;

import lombok.Data;

@Data
public class PaymentResponse {
    private String paymentId;
    private String orderId;
    private String status;
    private String paymentUrl;
    private String message;
}