package com.a1st.ecom.product.controller;

import com.a1st.ecom.product.request.ProductPurchaseRequest;
import com.a1st.ecom.product.request.ProductRequest;
import com.a1st.ecom.product.response.ProductPurchaseResponse;
import com.a1st.ecom.product.response.ProductResponse;
import com.a1st.ecom.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody List<ProductPurchaseRequest> requestedProducts) {
        return ResponseEntity.ok(productService.purchaseProducts(requestedProducts));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
