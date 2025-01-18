package com.a1st.ecom.order.service.Impl;

import com.a1st.ecom.order.clients.PaymentClient;
import com.a1st.ecom.order.clients.ProductClient;
import com.a1st.ecom.order.clients.UserClient;
import com.a1st.ecom.order.exceptions.BusinessException;
import com.a1st.ecom.order.exceptions.OrderNotFoundException;
import com.a1st.ecom.order.kafka.OrderConfirmation;
import com.a1st.ecom.order.kafka.OrderProducer;
import com.a1st.ecom.order.repository.OrderRepository;
import com.a1st.ecom.order.request.OrderRequest;
import com.a1st.ecom.order.request.PaymentRequest;
import com.a1st.ecom.order.request.PurchaseRequest;
import com.a1st.ecom.order.response.OrderResponse;
import com.a1st.ecom.order.response.PurchaseResponse;
import com.a1st.ecom.order.service.OrderService;
import com.a1st.ecom.order.utils.OrderMapper;
import com.a1st.ecom.orderLine.request.OrderLineRequest;
import com.a1st.ecom.orderLine.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final PaymentClient paymentClient;

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
        // start payment process
        // send payment request to payment service payment-ms
        paymentClient.requestOrderPayment(
                new PaymentRequest(
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        order.getId(),
                        order.getReference(),
                        user
                )
        );


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

    @Override
    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Override
    public OrderResponse findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order with id %s not found", orderId)));
    }
}
