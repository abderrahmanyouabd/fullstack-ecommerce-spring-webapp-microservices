package com.a1st.ecom.product.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ProductRequest
        (
                Long id,
                @NotNull(message = "Product name is required")
                String name,
                @NotNull(message = "Product description is required")
                String description,
                @Positive(message = "Product available quantity must be greater than 0")
                Double availableQuantity,
                @Positive(message = "Product price must be greater than 0")
                BigDecimal price,
                @NotNull(message = "Product category is required")
                Long categoryId
        ) {
}
