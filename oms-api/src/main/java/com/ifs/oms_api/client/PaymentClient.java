package com.ifs.oms_api.client;

import com.ifs.oms_api.model.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String PAYMENT_URL = "http://localhost:8085/api/payments";

    public String processPayment(OrderRequest request) {
        try {
            // Kirim request ke Payment API
            String response = restTemplate.postForObject(
                    PAYMENT_URL,
                    request,
                    String.class);
            return response;
        } catch (Exception e) {
            System.err.println("Gagal proses pembayaran: " + e.getMessage());
            return null;
        }
    }
}