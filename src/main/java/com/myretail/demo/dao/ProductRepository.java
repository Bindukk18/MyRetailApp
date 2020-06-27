package com.myretail.demo.dao;

import com.myretail.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author Bindumalini
 * The Interface ProductRepository.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    
    /**
     * Find by product id.
     *
     * @param productId the product id
     * @return the product
     */
    public Product findByProductId(String productId);
}
