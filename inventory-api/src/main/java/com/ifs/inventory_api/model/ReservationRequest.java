package com.ifs.inventory_api.model;

import lombok.Data;
import java.util.List;

@Data
public class ReservationRequest {
    private String orderId;
    private List<ReservationItem> items; // Sekarang bisa, karena ReservationItem sudah ada
}