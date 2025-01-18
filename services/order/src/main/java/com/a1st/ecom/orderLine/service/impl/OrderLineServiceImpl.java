package com.a1st.ecom.orderLine.service.impl;

import com.a1st.ecom.order.request.PurchaseRequest;
import com.a1st.ecom.orderLine.exceptions.OrderLineNotFoundException;
import com.a1st.ecom.orderLine.repository.OrderLineRepository;
import com.a1st.ecom.orderLine.request.OrderLineRequest;
import com.a1st.ecom.orderLine.response.OrderLineResponse;
import com.a1st.ecom.orderLine.service.OrderLineService;
import com.a1st.ecom.orderLine.utils.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public void createOrderLine(OrderLineRequest orderLineRequest) {
        this.orderLineRepository.save(orderLineMapper.toOrderLine(orderLineRequest));
    }

    @Override
    public List<OrderLineResponse> getOrderLinesByOrderId(Long orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .toList();
    }
}
