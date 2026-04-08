package com.ifs.payment_api.controller;

import com.ifs.payment_api.model.PaymentRequest;
import com.ifs.payment_api.model.PaymentResponse;
import com.ifs.payment_api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Payment API berjalan dengan baik!";
    }

    @PostMapping("/payments")
    public PaymentResponse createPayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}