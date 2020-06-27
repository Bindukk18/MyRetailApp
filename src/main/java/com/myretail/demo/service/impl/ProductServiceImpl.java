package com.myretail.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.demo.dao.ProductRepository;
import com.myretail.demo.exception.ProductMisMatchException;
import com.myretail.demo.exception.ProductNotFoundException;
import com.myretail.demo.model.Product;
import com.myretail.demo.service.ProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The repository. */
	@Autowired
	private ProductRepository repository;

	/**
	 * Gets the product by id.
	 *
	 * @param productId the product id
	 * @return the product by id
	 */
	@Override
	public Product getProductById(String productId) {

		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();

		String url = "https://redsky.target.com/v2/pdp/tcin/" + productId
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("id", productId);

		ObjectMapper infoMapper = new ObjectMapper();
		Map<String, Map> infoMap;

		try {

			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, urlVariables);
			infoMap = infoMapper.readValue(response.getBody(), Map.class);

			product.productId = productId;
			Map<String, Map> productMap = infoMap.get("product");
			Map<String, Map> itemMap = productMap.get("item");
			Map<String, String> prodDescrMap = itemMap.get(("product_description"));
			product.title = prodDescrMap.get("title");

			Product productInfoFromRepo = repository.findByProductId(productId);

			product.current_price = productInfoFromRepo.current_price;

		} catch (Exception e) {
			throw new ProductNotFoundException();
		}

		return product;

	}

	/**
	 * Update product price.
	 *
	 * @param p the p
	 * @param productId the product id
	 * @return the string
	 */
	@Override
	public String updateProductPrice(Product p,String productId) {
		if (!p.productId.equalsIgnoreCase(productId)) {
			throw new ProductMisMatchException();
		}
		repository.save(p);
		return "{\"response\":\"success\"}";

	}

}
