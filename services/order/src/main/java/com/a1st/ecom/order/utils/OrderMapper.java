package com.a1st.ecom.order.utils;

import com.a1st.ecom.order.model.Order;
import com.a1st.ecom.order.request.OrderRequest;
import com.a1st.ecom.order.response.PurchaseResponse;
import com.a1st.ecom.order.response.UserResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.id())
                .reference(orderRequest.reference())
                .totalAmount(orderRequest.amount())
                .userId(orderRequest.userId())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }
}
