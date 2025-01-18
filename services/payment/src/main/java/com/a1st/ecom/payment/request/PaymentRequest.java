package com.a1st.ecom.payment.request;

import com.a1st.ecom.payment.model.PaymentMethod;
import com.a1st.ecom.payment.model.User;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record PaymentRequest
        (
                Long id,
                BigDecimal amount,
                PaymentMethod paymentMethod,
                Long orderId,
                String orderReference,
                User user
        ) {
}
