package com.iraianbu.ecommerce.service;

import com.iraianbu.ecommerce.body.ProductPurchaseResponse;
import com.iraianbu.ecommerce.body.ProductRequest;
import com.iraianbu.ecommerce.body.ProductResponse;
import com.iraianbu.ecommerce.model.Category;
import com.iraianbu.ecommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .category(Category.builder().id(productRequest.id()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
            return new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getAvailableQuantity(),
                    product.getPrice(),
                    product.getCategory().getId(),
                    product.getCategory().getName(),
                    product.getCategory().getDescription()
            );
    }


    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
