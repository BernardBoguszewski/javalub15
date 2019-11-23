package com.sdacademy.javalub15.controllers.dtos;

import java.util.List;

public class OrderRequestDTO {

    private List<Long> productIds;

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
