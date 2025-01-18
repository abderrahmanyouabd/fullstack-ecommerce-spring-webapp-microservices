package com.a1st.ecom.payment.repository;

import com.a1st.ecom.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
