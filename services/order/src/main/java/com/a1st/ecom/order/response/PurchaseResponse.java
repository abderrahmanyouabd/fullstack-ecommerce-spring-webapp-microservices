package com.a1st.ecom.order.response;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record PurchaseResponse
        (
               Long productId,
               String name,
               String description,
               BigDecimal price,
               Double quantity

        ) {
}
