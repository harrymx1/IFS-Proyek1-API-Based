package com.ifs.supplier_dashboard_api.controller;

import com.ifs.supplier_dashboard_api.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Supplier Dashboard API berjalan dengan baik!";
    }

    @GetMapping("/products/my")
    public String getMyProducts() {
        return "Produk supplier: 1. Bayam Organik (stok: 100), 2. Wortel Fresh (stok: 200)";
    }

    @GetMapping("/orders/incoming")
    public String getIncomingOrders(@RequestParam String supplierId) {
        return supplierService.getIncomingOrders(supplierId);
    }
}