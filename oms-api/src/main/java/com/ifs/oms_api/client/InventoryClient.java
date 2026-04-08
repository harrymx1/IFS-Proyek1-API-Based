package com.ifs.oms_api.client;

import com.ifs.oms_api.model.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String INVENTORY_URL = "http://localhost:8084/api/reservations";

    public boolean reserveStock(OrderRequest request) {
        try {
            // Kirim request ke Inventory API
            String response = restTemplate.postForObject(
                    INVENTORY_URL,
                    request.getItems(),
                    String.class);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal reservasi stok: " + e.getMessage());
            return false;
        }
    }
}