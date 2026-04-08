package com.ifs.inventory_api.service;

import com.ifs.inventory_api.model.ReservationRequest;
import com.ifs.inventory_api.model.ReservationResponse;
import com.ifs.inventory_api.model.Stock;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StockService {

    // Simulasi database stok
    private Map<String, Stock> stockDatabase = new HashMap<>();

    public StockService() {
        // Inisialisasi data awal
        Stock product1 = new Stock();
        product1.setProductId("PROD-001");
        product1.setProductName("Bayam Organik");
        product1.setQuantity(100);
        product1.setReserved(0);
        stockDatabase.put("PROD-001", product1);

        Stock product2 = new Stock();
        product2.setProductId("PROD-002");
        product2.setProductName("Wortel Fresh");
        product2.setQuantity(200);
        product2.setReserved(0);
        stockDatabase.put("PROD-002", product2);
    }

    public Stock checkStock(String productId) {
        return stockDatabase.get(productId);
    }

    public ReservationResponse reserveStock(ReservationRequest request) {
        ReservationResponse response = new ReservationResponse();
        response.setReservationId("RES-" + UUID.randomUUID().toString().substring(0, 8));

        boolean allAvailable = true;
        for (var item : request.getItems()) {
            Stock stock = stockDatabase.get(item.getProductId());
            if (stock == null || stock.getQuantity() - stock.getReserved() < item.getQuantity()) {
                allAvailable = false;
                break;
            }
        }

        if (allAvailable) {
            for (var item : request.getItems()) {
                Stock stock = stockDatabase.get(item.getProductId());
                stock.setReserved(stock.getReserved() + item.getQuantity());
            }
            response.setSuccess(true);
            response.setMessage("Stok berhasil direservasi");
        } else {
            response.setSuccess(false);
            response.setMessage("Stok tidak mencukupi");
        }

        return response;
    }
}