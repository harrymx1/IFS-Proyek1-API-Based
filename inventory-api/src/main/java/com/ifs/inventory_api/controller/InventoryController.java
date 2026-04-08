package com.ifs.inventory_api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Inventory API berjalan dengan baik!";
    }

    @GetMapping("/stock/{productId}")
    public String checkStock(@PathVariable String productId) {
        return "Stok untuk produk " + productId + " akan segera tersedia";
    }
}