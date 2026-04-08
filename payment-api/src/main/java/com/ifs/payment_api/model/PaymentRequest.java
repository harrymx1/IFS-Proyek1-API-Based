package com.ifs.payment_api.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String orderId;
    private Integer amount;
    private String paymentMethod;
    private String buyerEmail;
}