package com.a1st.ecom.order.response;

import com.a1st.ecom.order.model.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record OrderResponse
        (
                Long id,
                String reference,
                BigDecimal amount,
                PaymentMethod paymentMethod,
                String userId
        ) {
}
