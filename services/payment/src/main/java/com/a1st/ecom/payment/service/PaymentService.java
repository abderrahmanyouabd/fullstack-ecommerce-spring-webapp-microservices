package com.a1st.ecom.payment.service;

import com.a1st.ecom.payment.request.PaymentRequest;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface PaymentService {
    Long makePayment(PaymentRequest paymentRequest);
}
