package org.work.springworkv2.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.work.springworkv2.core.results.DataResult;
import org.work.springworkv2.core.results.ErrorDataResult;
import org.work.springworkv2.core.results.Result;
import org.work.springworkv2.core.results.SuccessDataResult;
import org.work.springworkv2.model.concretes.Product;
import org.work.springworkv2.services.concretes.ProductService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Product>>> getAll() {
        DataResult<List<Product>> result = productService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addNewProduct(@RequestBody Product product) {
        Result result = productService.addNewProduct(product);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<DataResult<Product>> updateProduct(@RequestBody Product product, @PathVariable int productId) {
        DataResult<Product> result = productService.updateProduct(product, productId);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable int id) {
        Result result = productService.deleteProduct(id);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<Product>> getById(@PathVariable int id) {
        Product product = productService.getById(id).getData();
        if (product != null) {
            return ResponseEntity.ok(new SuccessDataResult<>(product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDataResult<>("Product not found"));
        }
    }
}
