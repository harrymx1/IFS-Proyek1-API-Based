package com.ifs.oms_api.controller;

import com.ifs.oms_api.model.Order;
import com.ifs.oms_api.model.OrderRequest;
import com.ifs.oms_api.service.OrderOrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OmsController {

    @Autowired
    private OrderOrchestratorService orderOrchestratorService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OMS API berjalan dengan baik!";
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderOrchestratorService.processOrder(request);
    }
}