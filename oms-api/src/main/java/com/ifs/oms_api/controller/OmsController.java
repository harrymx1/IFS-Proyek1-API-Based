package com.ifs.oms_api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OmsController {

    @GetMapping("/health")
    public String healthCheck() {
        return "OMS API berjalan dengan baik!";
    }

    @PostMapping("/orders")
    public String createOrder() {
        return "Endpoint create order akan segera diimplementasikan";
    }
}