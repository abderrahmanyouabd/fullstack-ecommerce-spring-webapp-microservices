package com.a1st.ecom.order.kafka;

import com.a1st.ecom.order.model.PaymentMethod;
import com.a1st.ecom.order.response.PurchaseResponse;
import com.a1st.ecom.order.response.UserResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record OrderConfirmation
        (
                String orderReference,
                BigDecimal totalAmount,
                PaymentMethod paymentMethod,
                UserResponse user,
                List<PurchaseResponse> purchasedProducts
        ) {
}
