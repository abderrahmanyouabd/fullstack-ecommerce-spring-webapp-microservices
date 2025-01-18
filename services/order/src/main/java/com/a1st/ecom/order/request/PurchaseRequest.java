package com.a1st.ecom.order.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record PurchaseRequest
        (
                @NotNull(message = "Product id should not be null")
                Long productId,
                @Positive(message = "Quantity should be greater than 0")
                Double quantity
        ) {
}
