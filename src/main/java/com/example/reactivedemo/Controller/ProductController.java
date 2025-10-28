package com.example.reactivedemo.controller;

import com.example.reactivedemo.model.Product;
import com.example.reactivedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteProduct(id);
    }

    // Optional streaming endpoint
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> streamProducts() {
        return service.getAllProducts();
    }
}
