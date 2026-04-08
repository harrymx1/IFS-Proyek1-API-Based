package com.ifs.oms_api.model;

import lombok.Data;

@Data
public class PaymentCallback {
    private String paymentId;
    private String orderId;
    private String status;
    private String transactionId;
}