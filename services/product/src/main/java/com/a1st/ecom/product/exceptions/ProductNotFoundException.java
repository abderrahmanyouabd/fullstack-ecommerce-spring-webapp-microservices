package com.a1st.ecom.product.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductNotFoundException extends RuntimeException {
    private final String message;
}
