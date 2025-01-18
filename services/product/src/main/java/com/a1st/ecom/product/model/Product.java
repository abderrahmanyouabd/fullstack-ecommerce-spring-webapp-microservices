package com.a1st.ecom.product.model;

import com.a1st.ecom.category.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double availableQuantity;
    private BigDecimal price;


    @ManyToOne
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "category_id")
    private Category category;
}
