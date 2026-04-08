package com.ifs.supplier_dashboard_api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OmsClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String OMS_URL = "http://localhost:8083/api/orders/supplier";

    public String getOrdersIncoming(String supplierId) {
        try {
            String response = restTemplate.getForObject(
                    OMS_URL + "/" + supplierId,
                    String.class);
            return response;
        } catch (Exception e) {
            System.err.println("Gagal mengambil pesanan: " + e.getMessage());
            return "[]";
        }
    }
}