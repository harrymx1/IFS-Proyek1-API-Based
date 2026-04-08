package com.ifs.oms_api.model;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private String buyerId;
    private String buyerName;
    private String buyerEmail;
    private String buyerPhone;
    private String shippingAddress;
    private List<OrderItem> items;
    private Integer totalAmount;
    private String paymentMethod;
}

@Data
class OrderItem {
    private String productId;
    private String productName;
    private Integer quantity;
    private Integer price;
    private String supplierId;
}