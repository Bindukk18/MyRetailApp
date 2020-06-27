package com.myretail.demo.service;

import org.springframework.stereotype.Component;

import com.myretail.demo.model.Product;


/**
 * 
 * @author Bindumalini
 * The Interface ProductService.
 */
@Component
public interface ProductService {
	
	/**
	 * Gets the product by id.
	 *
	 * @param productd the productd
	 * @return the product by id
	 */
	public Product getProductById(String productd);
	
	/**
	 * Update product price.
	 *
	 * @param p the p
	 * @param productId the product id
	 * @return the string
	 */
	public String updateProductPrice(Product p,String productId);
	

}
