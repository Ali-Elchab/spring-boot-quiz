package com.example.springbootquiz.product;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "Product 1", "Description 1", "Category 1", "2021-01-01"),
                new Product(2L, "Product 2", "Description 2", "Category 2", "2021-01-02"),
                new Product(3L, "Product 3", "Description 3", "Category 3", "2021-01-03"));
    }
}
