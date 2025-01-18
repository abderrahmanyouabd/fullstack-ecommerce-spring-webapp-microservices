package com.a1st.ecom.product.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ProductPurchaseRequest
        (
                @NotNull(message = "Product id is required")
                Long productId,
                @Positive(message = "Product quantity must be greater than 0")
                @NotNull(message = "Product quantity is required")
                Double quantity
        ) {
}
