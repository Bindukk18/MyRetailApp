package com.myretail.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.demo.exception.ProductMisMatchException;
import com.myretail.demo.exception.ProductNotFoundException;
import com.myretail.demo.model.Product;
import com.myretail.demo.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Bindumalini
 * The Class ProductController.
 */
@Api(value = "MyRetailApp", description = "Retrieves/Modifies the  Product Information by product id")
@RestController
public class ProductController {

	/** The product service impl. */
	@Autowired
	private ProductService productServiceImpl;

	/**
	 * Gets the product info.
	 *
	 * @param productId Id of product we need information about.
	 * @return the product info
	 * @throws ProductNotFoundException the product not found exception
	 */
	@ApiOperation(value = "Gets the product and price information by product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success response"),
			@ApiResponse(code = 404, message = "Product not found") })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Product getProductInfo(@PathVariable("id") String productId) throws ProductNotFoundException {
		return productServiceImpl.getProductById(productId);

	}

	/**
	 * Modify price.
	 *
	 * @param product  Product information in JSON request body
	 * @param productId Id of product that to be stored.
	 * @return the string
	 * @throws ProductMisMatchException the product mis match exception
	 */
	@ApiOperation(value = "Modifies the prouct information")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "ProductId in request header and body doesn't match") })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public String modifyPrice(@RequestBody Product product, @PathVariable("id") String productId)
			throws ProductMisMatchException {
	
		return productServiceImpl.updateProductPrice(product, productId);
	}

}