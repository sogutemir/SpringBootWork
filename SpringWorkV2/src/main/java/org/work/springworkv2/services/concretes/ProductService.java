package org.work.springworkv2.services.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.springworkv2.dataAccess.abstracts.ProductRepository;
import org.work.springworkv2.model.concretes.Product;
import org.work.springworkv2.services.abstracts.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
