package com.ifs.webstore_api.controller;

import com.ifs.webstore_api.model.CheckoutRequest;
import com.ifs.webstore_api.model.OrderResponse;
import com.ifs.webstore_api.service.WebStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebStoreController {

    @Autowired
    private WebStoreService webStoreService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Web Store API berjalan dengan baik!";
    }

    @GetMapping("/products")
    public String getProducts() {
        return "Daftar produk: 1. Bayam Organik (Rp 8.000), 2. Wortel Fresh (Rp 5.000)";
    }

    @PostMapping("/checkout")
    public OrderResponse checkout(@RequestBody CheckoutRequest request) {
        return webStoreService.checkout(request);
    }
}