package com.a1st.ecom.order.service.Impl;

import com.a1st.ecom.order.clients.ProductClient;
import com.a1st.ecom.order.exceptions.BusinessException;
import com.a1st.ecom.order.kafka.OrderConfirmation;
import com.a1st.ecom.order.kafka.OrderProducer;
import com.a1st.ecom.order.model.Order;
import com.a1st.ecom.order.repository.OrderRepository;
import com.a1st.ecom.order.request.OrderRequest;
import com.a1st.ecom.order.request.PurchaseRequest;
import com.a1st.ecom.order.response.PurchaseResponse;
import com.a1st.ecom.order.service.OrderService;
import com.a1st.ecom.order.clients.UserClient;
import com.a1st.ecom.order.utils.OrderMapper;
import com.a1st.ecom.orderLine.model.OrderLine;
import com.a1st.ecom.orderLine.request.OrderLineRequest;
import com.a1st.ecom.orderLine.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserClient userClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    @Override
    public Long createOrder(OrderRequest orderRequest) {
        // TODO: Implement the logic
        // check the user exists using openfeign or webClient user-ms
        var user = userClient.findUserById(orderRequest.userId())
                .orElseThrow(() -> new BusinessException(String.format("User with id %s not found", orderRequest.userId())));

        // purchase the product from the product service product-ms

        List<PurchaseResponse> purchaseResponses = this.productClient.purchaseProduct(orderRequest.desiredProducts());

        // persist the order in the database
        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));
        // persist the order lines in the database
        for (PurchaseRequest purchaseRequest : orderRequest.desiredProducts()) {
            orderLineService.createOrderLine(new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
        }
        // start payment process (TODO)

        // send order confirmation to notification service notification-ms
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        user,
                        purchaseResponses
                )
        );
        return order.getId();
    }
}
