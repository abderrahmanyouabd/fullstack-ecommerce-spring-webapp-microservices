package com.a1st.ecom.payment.service.impl;

import com.a1st.ecom.payment.kafka.notification.NotificationProducer;
import com.a1st.ecom.payment.repository.PaymentRepository;
import com.a1st.ecom.payment.request.PaymentRequest;
import com.a1st.ecom.payment.service.PaymentService;
import com.a1st.ecom.payment.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Long makePayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        // send payment notification
         notificationProducer.sendNotification(paymentMapper.toPaymentNotificationRequest(paymentRequest));
        return payment.getId();
    }
}
