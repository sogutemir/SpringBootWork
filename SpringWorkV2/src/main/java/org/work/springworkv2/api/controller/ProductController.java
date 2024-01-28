package org.work.springworkv2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public Product addNewProduct(Product product){
        return productService.addNewProduct(product);
    }
    @PutMapping("/update/{productId}")
    public Product updateProduct(Product product , int productId){
        return productService.updateProduct(product , productId);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @GetMapping("/getbyid/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }
}
