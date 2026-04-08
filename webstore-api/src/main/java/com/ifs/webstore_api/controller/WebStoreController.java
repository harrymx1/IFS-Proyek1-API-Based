package com.ifs.webstore_api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebStoreController {

    // Endpoint test untuk cek apakah API berjalan
    @GetMapping("/health")
    public String healthCheck() {
        return "Web Store API berjalan dengan baik!";
    }

    // Endpoint untuk melihat semua produk (sementara return static)
    @GetMapping("/products")
    public String getProducts() {
        return "Daftar produk akan segera tersedia";
    }
}