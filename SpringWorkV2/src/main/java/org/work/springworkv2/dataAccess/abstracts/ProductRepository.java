package org.work.springworkv2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springworkv2.model.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
}
