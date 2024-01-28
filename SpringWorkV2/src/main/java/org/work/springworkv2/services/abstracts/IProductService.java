package org.work.springworkv2.services.abstracts;


import org.work.springworkv2.core.results.DataResult;
import org.work.springworkv2.core.results.Result;
import org.work.springworkv2.model.concretes.Product;

import java.util.List;

public interface IProductService {
    DataResult<List<Product>> getAll();
    Result addNewProduct(Product product);
    DataResult<Product> updateProduct(Product product , int productId);
    Result deleteProduct(int id);
    DataResult<Product> getById(int id);
}
