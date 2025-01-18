package com.a1st.ecom.orderLine.model;

import com.a1st.ecom.order.model.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "order_lines")
public class OrderLine {

        @Id
        @GeneratedValue
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        private Order order;
        private Long productId;
        private Double quantity;
}
