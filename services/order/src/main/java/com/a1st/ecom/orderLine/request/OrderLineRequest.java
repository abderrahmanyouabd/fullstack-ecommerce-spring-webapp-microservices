package com.a1st.ecom.orderLine.request;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public record OrderLineRequest(Long id, Long orderId, Long productId, Double quantity) {
}
