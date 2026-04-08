package com.ifs.supplier_dashboard_api.service;

import com.ifs.supplier_dashboard_api.client.OmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private OmsClient omsClient;

    public String getIncomingOrders(String supplierId) {
        return omsClient.getOrdersIncoming(supplierId);
    }
}