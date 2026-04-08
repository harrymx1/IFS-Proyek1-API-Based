package com.ifs.oms_api.model;

import lombok.Data;

@Data
public class OrderItem {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer price;
    private String supplierId;
}