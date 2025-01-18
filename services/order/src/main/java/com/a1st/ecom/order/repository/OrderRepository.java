package com.a1st.ecom.order.repository;

import com.a1st.ecom.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
