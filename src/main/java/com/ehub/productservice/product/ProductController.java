package com.ehub.productservice.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(
            @RequestBody ProductDTO product) {

        System.out.println("Received: "+ product.productName());
        // TODO Add/Congigure Database
        return null;

    }
}
