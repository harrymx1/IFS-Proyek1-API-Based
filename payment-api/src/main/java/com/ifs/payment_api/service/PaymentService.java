package com.ifs.payment_api.service;

import com.ifs.payment_api.model.PaymentRequest;
import com.ifs.payment_api.model.PaymentResponse;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {

    public PaymentResponse processPayment(PaymentRequest request) {
        // Simulasi proses pembayaran
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId("PAY-" + UUID.randomUUID().toString().substring(0, 8));
        response.setOrderId(request.getOrderId());
        response.setStatus("SUCCESS");
        response.setPaymentUrl("https://payment.ifs.com/pay/" + response.getPaymentId());
        response.setMessage("Pembayaran berhasil diproses");

        return response;
    }
}