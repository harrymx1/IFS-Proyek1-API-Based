package com.ifs.inventory_api.controller;

import com.ifs.inventory_api.model.ReservationRequest;
import com.ifs.inventory_api.model.ReservationResponse;
import com.ifs.inventory_api.model.Stock;
import com.ifs.inventory_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private StockService stockService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Inventory API berjalan dengan baik!";
    }

    @GetMapping("/stock/{productId}")
    public Stock checkStock(@PathVariable String productId) {
        return stockService.checkStock(productId);
    }

    @PostMapping("/reservations")
    public ReservationResponse reserveStock(@RequestBody ReservationRequest request) {
        return stockService.reserveStock(request);
    }
}