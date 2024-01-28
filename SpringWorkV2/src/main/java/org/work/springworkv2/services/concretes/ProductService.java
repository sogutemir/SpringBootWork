package org.work.springworkv2.services.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.springworkv2.core.results.*;
import org.work.springworkv2.dataAccess.abstracts.ProductRepository;
import org.work.springworkv2.model.concretes.Product;
import org.work.springworkv2.services.abstracts.IProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;


    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productRepository.findAll(),"Ürünler listelendi");
    }

    @Override
    public Result addNewProduct(Product product) {
        productRepository.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> updateProduct(Product product, int productId) {
        product.setId(productId);
        productRepository.save(product);
        return new SuccessDataResult<Product>(product,"Ürün Güncellendi");
    }


    @Override
    public Result deleteProduct(int id) {
        productRepository.deleteById(id);
        return new SuccessResult("Ürün silindi");
    }

    @Override
    public DataResult<Product> getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return new SuccessDataResult<>(product.get(), "Product found");
        } else {
            return new ErrorDataResult<>("Product with ID: " + id + " not found");
        }
    }



}
