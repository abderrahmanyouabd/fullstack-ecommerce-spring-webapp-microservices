package com.a1st.ecom.order.service.Impl;

import com.a1st.ecom.order.request.OrderRequest;
import com.a1st.ecom.order.service.OrderService;
import com.a1st.ecom.order.service.UserClient;
import org.springframework.stereotype.Service;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final UserClient userClient;

    @Override
    public Long createOrder(OrderRequest orderRequest) {
        // TODO: Implement the logic
        // check the user exists using openfeign or webClient user-ms

        // purchase the product from the product service product-ms
        // persist the order in the database
        // persist the order lines in the database
        // start payment process (TODO)
        // send order confirmation to notification service notification-ms (TODO Kafka)
    }
}
