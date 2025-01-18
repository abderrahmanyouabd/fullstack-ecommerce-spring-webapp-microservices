package com.a1st.ecom.order.clients;

import com.a1st.ecom.order.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@FeignClient(name = "payment-service", url = "${application.config.payment-url}")
public interface PaymentClient {
    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequest paymentRequest);

}
