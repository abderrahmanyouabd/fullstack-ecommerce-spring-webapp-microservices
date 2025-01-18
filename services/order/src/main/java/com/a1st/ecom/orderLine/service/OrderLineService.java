package com.a1st.ecom.orderLine.service;

import com.a1st.ecom.orderLine.request.OrderLineRequest;
import com.a1st.ecom.orderLine.response.OrderLineResponse;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface OrderLineService {
    void createOrderLine(OrderLineRequest orderLineRequest);
    List<OrderLineResponse> getOrderLinesByOrderId(Long orderId);
}
