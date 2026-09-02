package com.ehub.productservice.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public record ProductDTO(
        UUID productId,
        String productName,
        double productPrice,
        String productDescription){}