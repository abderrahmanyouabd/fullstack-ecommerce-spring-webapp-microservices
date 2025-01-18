package com.a1st.ecom.product.service;

import com.a1st.ecom.product.model.Product;
import com.a1st.ecom.product.request.ProductPurchaseRequest;
import com.a1st.ecom.product.request.ProductRequest;
import com.a1st.ecom.product.response.ProductPurchaseResponse;
import com.a1st.ecom.product.response.ProductResponse;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface ProductService {
    Long createProduct(ProductRequest productRequest);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> products);

    ProductResponse getProduct(Long productId);

    List<ProductResponse> getAllProducts();
}
