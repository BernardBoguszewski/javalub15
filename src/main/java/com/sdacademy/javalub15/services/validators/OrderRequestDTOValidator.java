package com.sdacademy.javalub15.services.validators;

import com.sdacademy.javalub15.controllers.dtos.OrderRequestDTO;
import org.springframework.util.CollectionUtils;

public class OrderRequestDTOValidator {


    public static boolean validate(OrderRequestDTO orderRequestDTO) {
        // TODO: 24.11.2019
        if (CollectionUtils.isEmpty(orderRequestDTO.getProductIds())) {
            return false;
        }

        return true;
    }
}
