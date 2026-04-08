package com.ifs.supplier_dashboard_api.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String name;
    private String category;
    private Integer price;
    private Integer stock;
    private String unit;
    private Boolean isOrganic;
}