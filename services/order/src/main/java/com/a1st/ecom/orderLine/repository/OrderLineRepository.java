package com.a1st.ecom.orderLine.repository;

import com.a1st.ecom.orderLine.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrderId(Long orderId);
}
