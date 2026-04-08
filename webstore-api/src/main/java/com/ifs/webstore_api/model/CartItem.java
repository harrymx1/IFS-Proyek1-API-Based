package com.ifs.webstore_api.model;

import lombok.Data;

@Data
public class CartItem {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer price;
}