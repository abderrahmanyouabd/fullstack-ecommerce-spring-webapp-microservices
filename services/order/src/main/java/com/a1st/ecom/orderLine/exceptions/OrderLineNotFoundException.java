package com.a1st.ecom.orderLine.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderLineNotFoundException extends RuntimeException {
    private final String message;
}
