package com.ifs.inventory_api.model;

import lombok.Data;

@Data
public class Stock {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer reserved;
}