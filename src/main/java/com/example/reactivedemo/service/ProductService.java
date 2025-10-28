package com.example.reactivedemo.service;

import com.example.reactivedemo.model.Product;
import com.example.reactivedemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Mono<Product> saveProduct(Product product) {
        return repository.save(product);
    }

    public Mono<Void> deleteProduct(String id) {
        return repository.deleteById(id);
    }
}
