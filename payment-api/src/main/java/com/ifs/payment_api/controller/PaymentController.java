package com.ifs.payment_api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Payment API berjalan dengan baik!";
    }

    @PostMapping("/payments")
    public String createPayment() {
        return "Endpoint create payment akan segera diimplementasikan";
    }
}