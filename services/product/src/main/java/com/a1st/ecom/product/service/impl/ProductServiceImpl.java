package com.a1st.ecom.product.service.impl;

import com.a1st.ecom.product.exceptions.ProductNotFoundException;
import com.a1st.ecom.product.exceptions.ProductPurchaseException;
import com.a1st.ecom.product.repository.ProductRepository;
import com.a1st.ecom.product.request.ProductPurchaseRequest;
import com.a1st.ecom.product.request.ProductRequest;
import com.a1st.ecom.product.response.ProductPurchaseResponse;
import com.a1st.ecom.product.response.ProductResponse;
import com.a1st.ecom.product.service.ProductService;
import com.a1st.ecom.product.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Long createProduct(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> products) {
        var desiredProducts = products.stream().map(ProductPurchaseRequest::productId).toList();
        var existingProducts = productRepository.findAllById(desiredProducts);
        return products.stream().map(productPurchaseRequest -> {
            var product = existingProducts.stream()
                    .filter(existingProduct -> existingProduct.getId().equals(productPurchaseRequest.productId()))
                    .findFirst()
                    .orElseThrow(
                            () -> new ProductPurchaseException(String.format("Product with id %s not found", productPurchaseRequest.productId()))
                    );
            if (product.getAvailableQuantity() < productPurchaseRequest.quantity()) {
                throw new ProductPurchaseException(String.format("Product with id %s has only %s available quantity", product.getId(), product.getAvailableQuantity()));
            }
            product.setAvailableQuantity(product.getAvailableQuantity() - productPurchaseRequest.quantity());
            productRepository.save(product);
            return productMapper.toProductPurchaseResponse(product, productPurchaseRequest.quantity());
        }).toList();
    }

    @Override
    public ProductResponse getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(
                () -> new ProductNotFoundException(String.format("Product with id %s not found", productId))
        );
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }
}
