package com.a1st.ecom.order.service;

import com.a1st.ecom.order.request.OrderRequest;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface OrderService {
    Long createOrder(OrderRequest orderRequest);
}
