package com.a1st.ecom.payment.utils;

import com.a1st.ecom.payment.kafka.request.PaymentNotificationRequest;
import com.a1st.ecom.payment.model.Payment;
import com.a1st.ecom.payment.model.PaymentMethod;
import com.a1st.ecom.payment.request.PaymentRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentRequest.id())
                .amount(paymentRequest.amount())
                .paymentMethod(paymentRequest.paymentMethod())
                .orderId(paymentRequest.orderId())
                .build();

    }

    public PaymentNotificationRequest toPaymentNotificationRequest(PaymentRequest paymentRequest) {
        return new PaymentNotificationRequest(
                paymentRequest.orderReference(),
                paymentRequest.amount(),
                paymentRequest.paymentMethod(),
                paymentRequest.user().firstName(),
                paymentRequest.user().lastName(),
                paymentRequest.user().email()
        );
    }
}
