package com.ifs.oms_api.client;

import com.ifs.oms_api.model.OrderItem;
import com.ifs.oms_api.model.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class InventoryClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String INVENTORY_URL = "http://localhost:8084/api/reservations";

    public boolean reserveStock(OrderRequest request) {
        try {
            // Buat request body untuk Inventory API
            Map<String, Object> reservationRequest = new HashMap<>();
            reservationRequest.put("orderId", "ORD-" + UUID.randomUUID().toString().substring(0, 8));

            // Konversi OrderItem ke format yang sesuai untuk Inventory
            List<Map<String, Object>> items = request.getItems().stream().map(item -> {
                Map<String, Object> map = new HashMap<>();
                map.put("productId", item.getProductId());
                map.put("quantity", item.getQuantity());
                map.put("supplierId", item.getSupplierId());
                return map;
            }).toList();

            reservationRequest.put("items", items);

            // Kirim request
            restTemplate.postForObject(INVENTORY_URL, reservationRequest, String.class);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal reservasi stok: " + e.getMessage());
            return false;
        }
    }
}