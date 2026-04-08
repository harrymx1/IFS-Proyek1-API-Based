package com.ifs.oms_api.service;

import com.ifs.oms_api.client.InventoryClient;
import com.ifs.oms_api.client.PaymentClient;
import com.ifs.oms_api.model.Order;
import com.ifs.oms_api.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderOrchestratorService {

    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private PaymentClient paymentClient;

    public Order processOrder(OrderRequest request) {
        // Buat order ID baru
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8);

        // Step 1: Reservasi stok ke Inventory
        boolean stockReserved = inventoryClient.reserveStock(request);
        if (!stockReserved) {
            throw new RuntimeException("Gagal reservasi stok");
        }

        // Step 2: Proses pembayaran ke Payment
        String paymentResult = paymentClient.processPayment(request);
        if (paymentResult == null) {
            throw new RuntimeException("Gagal proses pembayaran");
        }

        // Step 3: Buat objek Order
        Order order = new Order();
        order.setOrderId(orderId);
        order.setBuyerId(request.getBuyerId());
        order.setBuyerName(request.getBuyerName());
        order.setBuyerEmail(request.getBuyerEmail());
        order.setBuyerPhone(request.getBuyerPhone());
        order.setShippingAddress(request.getShippingAddress());
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus("PAID");
        order.setCreatedAt(LocalDateTime.now());

        return order;
    }
}