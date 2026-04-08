package com.ifs.webstore_api.client;

import com.ifs.webstore_api.model.CheckoutRequest;
import com.ifs.webstore_api.model.OrderResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OmsClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String OMS_URL = "http://localhost:8083/api/orders";

    public OrderResponse createOrder(CheckoutRequest request) {
        try {
            OrderResponse response = restTemplate.postForObject(
                    OMS_URL,
                    request,
                    OrderResponse.class);
            return response;
        } catch (Exception e) {
            System.err.println("Gagal menghubungi OMS: " + e.getMessage());
            OrderResponse errorResponse = new OrderResponse();
            errorResponse.setStatus("ERROR");
            errorResponse.setMessage("Gagal memproses pesanan: " + e.getMessage());
            return errorResponse;
        }
    }
}