package com.a1st.ecom.product.response;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ProductPurchaseResponse
        (
                Long productId,
                String name,
                String description,
                Double quantity,
                BigDecimal price
        ) {
}
