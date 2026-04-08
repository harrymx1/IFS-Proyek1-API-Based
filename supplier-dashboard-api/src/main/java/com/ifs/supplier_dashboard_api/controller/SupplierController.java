package com.ifs.supplier_dashboard_api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Supplier Dashboard API berjalan dengan baik!";
    }

    @GetMapping("/products/my")
    public String getMyProducts() {
        return "Daftar produk supplier akan segera tersedia";
    }
}