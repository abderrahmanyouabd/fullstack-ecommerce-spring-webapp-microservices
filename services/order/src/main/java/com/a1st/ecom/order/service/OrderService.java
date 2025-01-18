package com.a1st.ecom.order.service;

import com.a1st.ecom.order.request.OrderRequest;
import com.a1st.ecom.order.response.OrderResponse;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface OrderService {
    Long createOrder(OrderRequest orderRequest);
    List<OrderResponse> findAllOrders();

    OrderResponse findOrderById(Long orderId);
}
