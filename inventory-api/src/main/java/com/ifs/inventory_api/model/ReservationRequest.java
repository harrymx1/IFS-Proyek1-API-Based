package com.ifs.inventory_api.model;

import lombok.Data;
import java.util.List;

@Data
public class ReservationRequest {
    private String orderId;
    private List<ReservationItem> items;
}

@Data
class ReservationItem {
    private String productId;
    private Integer quantity;
    private String supplierId;
}