package com.iraianbu.ecommerce.controller;

import com.iraianbu.ecommerce.body.ProductPurchaseRequest;
import com.iraianbu.ecommerce.body.ProductPurchaseResponse;
import com.iraianbu.ecommerce.body.ProductRequest;
import com.iraianbu.ecommerce.body.ProductResponse;
import com.iraianbu.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productRequest
    ) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody List<ProductPurchaseRequest> productPurchaseRequest) {
        return ResponseEntity.ok(productService.purchaseProducts(productPurchaseRequest));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

}
