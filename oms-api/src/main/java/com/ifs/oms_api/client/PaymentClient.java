package com.ifs.oms_api.client;

import com.ifs.oms_api.model.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String PAYMENT_URL = "http://localhost:8085/api/payments";

    public String processPayment(OrderRequest request) {
        try {
            Map<String, Object> paymentRequest = new HashMap<>();
            paymentRequest.put("orderId", "ORD-" + System.currentTimeMillis());
            paymentRequest.put("amount", request.getTotalAmount());
            paymentRequest.put("paymentMethod", request.getPaymentMethod());
            paymentRequest.put("buyerEmail", request.getBuyerEmail());

            String response = restTemplate.postForObject(PAYMENT_URL, paymentRequest, String.class);
            return response;
        } catch (Exception e) {
            System.err.println("Gagal proses pembayaran: " + e.getMessage());
            return null;
        }
    }
}