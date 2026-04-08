package com.ifs.oms_api.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Order {
    private String orderId;
    private String buyerId;
    private String buyerName;
    private String buyerEmail;
    private String buyerPhone;
    private String shippingAddress;
    private Integer totalAmount;
    private String status;
    private LocalDateTime createdAt;
}