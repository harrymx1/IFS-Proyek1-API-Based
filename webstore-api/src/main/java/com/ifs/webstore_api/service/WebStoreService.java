package com.ifs.webstore_api.service;

import com.ifs.webstore_api.client.OmsClient;
import com.ifs.webstore_api.model.CheckoutRequest;
import com.ifs.webstore_api.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebStoreService {

    @Autowired
    private OmsClient omsClient;

    public OrderResponse checkout(CheckoutRequest request) {
        // Validasi sederhana
        if (request.getItems() == null || request.getItems().isEmpty()) {
            OrderResponse response = new OrderResponse();
            response.setStatus("ERROR");
            response.setMessage("Keranjang belanja kosong");
            return response;
        }

        // Kirim ke OMS
        return omsClient.createOrder(request);
    }
}