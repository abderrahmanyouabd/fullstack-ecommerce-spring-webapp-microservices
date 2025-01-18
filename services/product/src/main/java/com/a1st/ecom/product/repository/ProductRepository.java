package com.a1st.ecom.product.repository;

import com.a1st.ecom.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAllByIdInOrderById(List<Long> desiredProducts);
}
