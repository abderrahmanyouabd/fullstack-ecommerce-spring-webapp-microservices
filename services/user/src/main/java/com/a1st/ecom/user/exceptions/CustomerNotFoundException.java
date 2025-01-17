package com.a1st.ecom.user.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
