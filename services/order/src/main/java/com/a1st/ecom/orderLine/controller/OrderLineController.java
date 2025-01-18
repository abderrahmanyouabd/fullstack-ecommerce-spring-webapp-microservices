package com.a1st.ecom.orderLine.controller;

import com.a1st.ecom.orderLine.model.OrderLine;
import com.a1st.ecom.orderLine.response.OrderLineResponse;
import com.a1st.ecom.orderLine.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{orderId}")
    public List<OrderLineResponse> getOrderLinesByOrderId(@PathVariable Long orderId) {
        return orderLineService.getOrderLinesByOrderId(orderId);
    }

}
