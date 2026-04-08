package com.ifs.inventory_api.model;

import lombok.Data;

@Data
public class ReservationItem {
    private String productId;
    private Integer quantity;
    private String supplierId;
}