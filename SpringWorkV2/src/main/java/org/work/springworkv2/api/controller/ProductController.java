package org.work.springworkv2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.work.springworkv2.model.concretes.Product;
import org.work.springworkv2.services.concretes.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private  final ProductService productService;

    @GetMapping("/getall")
    public List<Product> getAll(){
        return productService.getAll();
    }
}
