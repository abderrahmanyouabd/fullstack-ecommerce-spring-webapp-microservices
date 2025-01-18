package com.a1st.ecom.product.response;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record ProductResponse
        (
                Long id,
                String name,
                String description,
                Double availableQuantity,
                BigDecimal price,
                Long categoryId,
                String categoryName,
                String categoryDescription


        ) {
}
