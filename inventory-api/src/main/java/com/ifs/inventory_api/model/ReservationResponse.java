package com.ifs.inventory_api.model;

import lombok.Data;

@Data
public class ReservationResponse {
    private String reservationId;
    private Boolean success;
    private String message;
}