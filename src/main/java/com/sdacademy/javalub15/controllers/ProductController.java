package com.sdacademy.javalub15.controllers;

import com.sdacademy.javalub15.controllers.dtos.ProductDTO;
import com.sdacademy.javalub15.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        // TODO: 23.11.2019  dodanie produktu
        return null;
    }

    public ResponseEntity<ProductDTO> findProductByPrice(String price) {
        // TODO: 23.11.2019 wyszukanie produktu po cenie
        return null;
    }

    public ResponseEntity<ProductDTO> changeProductPrice(String price) {
        // TODO: 23.11.2019 zmiana ceny
        return null;
    }


}
