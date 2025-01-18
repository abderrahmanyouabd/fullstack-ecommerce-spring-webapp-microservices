package com.a1st.ecom.payment.kafka.request;

import com.a1st.ecom.payment.model.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record PaymentNotificationRequest
        (
                String orderReference,
                BigDecimal amount,
                PaymentMethod paymentMethod,
                String userFirstName,
                String userLastName,
                String userEmail
        ) {
}
