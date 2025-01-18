package com.a1st.ecom.order.request;

import com.a1st.ecom.order.model.PaymentMethod;
import com.a1st.ecom.order.response.UserResponse;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record PaymentRequest
        (
                BigDecimal amount,
                PaymentMethod paymentMethod,
                Long orderId,
                String orderReference,
                UserResponse user
        ) {
}
