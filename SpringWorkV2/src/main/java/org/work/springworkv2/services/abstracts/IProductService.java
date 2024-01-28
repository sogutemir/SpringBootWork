package org.work.springworkv2.services.abstracts;


import org.work.springworkv2.model.concretes.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
}
